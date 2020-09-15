package demo;

import com.sun.tools.javac.parser.ScannerFactory;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.junit.Test;

import javax.servlet.ServletContext;

public class SwgTest {
    @Test
    public void test(){
//        ReflectiveJaxrsScanner scanner = new ReflectiveJaxrsScanner();
//        scanner.setResourcePackage("io.swagger.sample.resource");
//        ScannerFactory.setScanner(scanner);
//
//        Info info = new Info()
//                .title("Swagger Petstore")
//                .version("1.0.0")
//                .description("This is a sample server Petstore server.  You can find out more about Swagger " +
//                        "at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, " +
//                        "you can use the api key `special-key` to test the authorization filters.")
//                .termsOfService("http://swagger.io/terms/")
//                .contact(new Contact()
//                        .email("apiteam@swagger.io"))
//                .license(new License()
//                        .name("Apache 2.0")
//                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"));
//
//        ServletContext context = config.getServletContext();
//        Swagger swagger = new Swagger()
//                .info(info)
//                .host("localhost:8002")
//                .basePath("/api");
//        swagger.securityDefinition("api_key", new ApiKeyAuthDefinition("api_key", In.HEADER));
//        swagger.securityDefinition("petstore_auth",
//                new OAuth2Definition()
//                        .implicit("http://petstore.swagger.io/api/oauth/dialog")
//                        .scope("read:pets", "read your pets")
//                        .scope("write:pets", "modify pets in your account"));
//        swagger.tag(new Tag()
//                .name("pet")
//                .description("Everything about your Pets")
//                .externalDocs(new ExternalDocs("Find out more", "http://swagger.io")));
//        swagger.tag(new Tag()
//                .name("store")
//                .description("Access to Petstore orders"));
//        swagger.tag(new Tag()
//                .name("user")
//                .description("Operations about user")
//                .externalDocs(new ExternalDocs("Find out more about our store", "http://swagger.io")));
//
//        new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
    }
}
