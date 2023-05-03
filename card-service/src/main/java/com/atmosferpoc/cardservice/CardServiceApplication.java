package com.atmosferpoc.cardservice;

import com.atmosferpoc.shared.util.DefaultProfileUtil;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
@EnableFeignClients(basePackages = "com.atmosferpoc.shared")
@RequiredArgsConstructor
@EnableAspectJAutoProxy
@EnableSwagger2
@EnableWebMvc
@ComponentScan("com.atmosferpoc")
@EnableJpaRepositories("com.atmosferpoc")
@EntityScan(value = "com.atmosferpoc.entity")
@EnableScheduling
@EnableEncryptableProperties
@Slf4j
public class CardServiceApplication {
    public static void main(String[] args) {
        var app = new SpringApplication(CardServiceApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        app.run(args);
    }
}