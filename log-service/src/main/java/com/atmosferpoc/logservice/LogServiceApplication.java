package com.atmosferpoc.logservice;

import com.atmosferpoc.shared.util.DefaultProfileUtil;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.atmosferpoc")
@EnableAspectJAutoProxy
@EnableJpaRepositories("com.atmosferpoc")
@EntityScan(value = "com.atmosferpoc.entity")
@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
@EnableScheduling
@EnableEncryptableProperties
@EnableMongoRepositories
public class LogServiceApplication {
    public static void main(String[] args) {
        var app = new SpringApplication(LogServiceApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        app.run(args);
    }
}
