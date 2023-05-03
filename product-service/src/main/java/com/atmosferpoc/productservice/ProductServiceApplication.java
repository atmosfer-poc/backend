package com.atmosferpoc.productservice;

import com.atmosferpoc.shared.util.DefaultProfileUtil;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
@EnableAspectJAutoProxy
@ComponentScan("com.atmosferpoc")
@EnableSwagger2
@EnableWebMvc
@EnableJpaRepositories("com.atmosferpoc")
@EntityScan(value = "com.atmosferpoc.entity")
@EnableScheduling
@EnableEncryptableProperties
@EnableCaching
public class ProductServiceApplication {

    public static void main(String[] args) {
        var app = new SpringApplication(ProductServiceApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        app.run(args);
    }

}
