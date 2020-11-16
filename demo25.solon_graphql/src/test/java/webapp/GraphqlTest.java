package webapp;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.junit.Test;
import org.noear.solon.Utils;
import webapp.model.Card;
import webapp.model.User;

public class GraphqlTest {
    @Test
    public void test1(){
        //定义schema文件，直接写在了代码中，包含一个hello的查询方法
        String schema = "type Query{hello: String} schema{query: Query}";
        SchemaParser schemaParser = new SchemaParser();
        //直接加载schema，初始化GraphQL
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);
        //加载一份服务端数据
        RuntimeWiring runtimeWiring =  RuntimeWiring.newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        // 构建一个GraphQL实例，执行graphql脚本
        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{hello}");

        System.out.println(executionResult.getData().toString());
        // Prints: {hello=world}
    }

    @Test
    public void test2(){
/*
            定义GraphQL对象,等同于schema中定义的
            type User {
                id:ID
                age:Int
                name:String
            }
        */
        GraphQLObjectType userObjectType = GraphQLObjectType.newObject()
                .name("User")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(Scalars.GraphQLLong))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("age").type(Scalars.GraphQLInt))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .build();
        /*
            queryUser : User 指定对象及参数类型
            等同于在GraphQL中定义一个无参方法 queryUser，返回值为User
            queryUser:User
            dataFetcher指定了响应的数据集，这个demo里使用了静态写入的方式
         */
        GraphQLFieldDefinition userFileldDefinition = GraphQLFieldDefinition.newFieldDefinition()
                .name("queryUser")
                .type(userObjectType)
                //静态数据
                .dataFetcher(new StaticDataFetcher(new User(19, 2, "CLC")))
                .build();
        /*
            type UserQuery 定义查询类型

            对应的graphQL为：
                type UserQuery {
                    queryUser:User
                }
         */
        GraphQLObjectType userQueryObjectType = GraphQLObjectType.newObject()
                .name("UserQuery")
                .field(userFileldDefinition)
                .build();
        /*
            Schema 定义查询
            定义了query的root类型
            对应的GraphQL语法为：
               schema {
                    query:UserQuery
               }
         */
        GraphQLSchema qlSchema = GraphQLSchema.newSchema().query(userQueryObjectType).build();

        //构建一个GraphQl对象，执行逻辑都在此处进行
        GraphQL graphQL = GraphQL.newGraphQL(qlSchema).build();

        //模拟客户端传入查询脚本，方法名queryUser，获取响应值为 id name age
        String query = "{queryUser{id name age}}";
        // 执行业务操作逻辑，获取返回值
        ExecutionResult result = graphQL.execute(query);

        System.out.println(result.toSpecification());
    }

    @Test
    public void test3() throws Exception{
        //读取graphqls文件
        String fileName = "user.graphqls";
        String fileContent =  Utils.getString( Utils.getResource(fileName).openStream(),null);
        //解析文件
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(fileContent);

        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
                .type("UserQuery", builder ->
                        builder.dataFetcher("queryUserById", environment -> {
                            //解析请求参数，根据业务返回结果
                            Long id = Long.parseLong(environment.getArgument("id"));
                            Card card = new Card("123456", id);
                            return new User(18, id, "user0" + id, card);
                        })
                )
                .build();

        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);

        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();

        String query = "{queryUserById(id:15){id,name,age,card{cardNumber,userId}}}";
        ExecutionResult result = graphQL.execute(query);

        System.out.println("query: " + query);
        System.out.println(result.toSpecification());
    }
}
