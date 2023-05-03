package com.atmosferpoc.apigatewayservice;

import com.atmosferpoc.shared.util.DefaultProfileUtil;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories({
        "com.atmosferpoc"
})
@ComponentScan({
        "com.atmosferpoc.shared.config.properties",
        "com.atmosferpoc.integration",
        "com.atmosferpoc.apigatewayservice",
        "com.atmosferpoc.core.exception"
})
@EntityScan(value = "com.atmosferpoc.entity")
@EnableScheduling
@EnableEncryptableProperties
public class ApiGatewayServiceApplication {
    public static void main(String[] args) {
        var app = new SpringApplication(ApiGatewayServiceApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        app.run(args);
    }
}
