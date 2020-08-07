package webapp;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class SqlSessionFactoryBean {
    private Configuration configuration;
    public SqlSessionFactoryBean(DataSource dataSource){
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("solon", transactionFactory, dataSource);
        configuration = new Configuration(environment);
    }

    /**
     * 添加 typeAliases
     * */
    public SqlSessionFactoryBean registerAliases(String packageName){
        //例："webapp.model"
        configuration.getTypeAliasRegistry().registerAliases(packageName);
        return this;
    }

    /**
     * 添加 mappers
     * */
    public SqlSessionFactoryBean addMappers(String packageName){
        //例："webapp.dso.db"
        configuration.addMappers(packageName);
        return this;
    }


    public SqlSessionFactory build(){
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
