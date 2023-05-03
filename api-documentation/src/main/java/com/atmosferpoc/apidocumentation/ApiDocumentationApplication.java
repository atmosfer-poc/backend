package com.atmosferpoc.apidocumentation;

import com.atmosferpoc.apidocumentation.service.ServiceDescriptionUpdater;
import com.atmosferpoc.apidocumentation.store.ServiceInitializationStore;
import com.atmosferpoc.shared.util.DefaultProfileUtil;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@RequiredArgsConstructor
@EnableEncryptableProperties
public class ApiDocumentationApplication implements CommandLineRunner {
    private final ServiceInitializationStore serviceInitializationStore;
    private final ServiceDescriptionUpdater serviceDescriptionUpdater;

    public static void main(String[] args) {
        var app = new SpringApplication(ApiDocumentationApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        serviceInitializationStore.patchStore();
        serviceDescriptionUpdater.refreshSwaggerConfigurations();
    }
}
