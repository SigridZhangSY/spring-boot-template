package hello;

import hello.rest.UsersResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//Component让spring boot扫描到JerseyConfig
@Component
public class JerseyConfig  extends ResourceConfig {
    public JerseyConfig() {

        //        register(UsersResource.class);
//        配置扫描的restful package.
        packages("hello.rest");

    }
}
