package com.atmosferpoc.apidocumentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Controller
public class SwaggerUIConfiguration {
    private final ServiceDefinitionsContext definitionContext;

    public SwaggerUIConfiguration(ServiceDefinitionsContext definitionContext) {
        this.definitionContext = definitionContext;
    }

    @GetMapping("/")
    public String docs(){
        return "redirect:/swagger-ui.html";
    }

    @Bean
    public RestTemplate configureTemplate() {
        return new RestTemplate();
    }

    @Primary
    @Bean
    @Lazy
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider, RestTemplate temp) {
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            resources.clear();
            resources.addAll(definitionContext.getSwaggerDefinitions());
            return resources;
        };
    }
}
