package com.atmosferpoc.apidocumentation.controller;

import com.atmosferpoc.apidocumentation.config.ServiceDefinitionsContext;
import com.atmosferpoc.apidocumentation.store.ServiceInitializationStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ServiceDefinitionController.END_POINT)
public class ServiceDefinitionController {
    public static final String END_POINT = "/api/docs";

    private final ServiceDefinitionsContext definitionContext;
    private final ServiceInitializationStore serviceInitializationStore;

    public ServiceDefinitionController(ServiceDefinitionsContext definitionContext,
                                       ServiceInitializationStore serviceInitializationStore) {
        this.definitionContext = definitionContext;
        this.serviceInitializationStore = serviceInitializationStore;
    }

    @GetMapping("/service/{serviceName}")
    public String getServiceDefinition(@PathVariable("serviceName") String serviceName) {
        return definitionContext.getSwaggerDefinition(serviceName);
    }

    @GetMapping("/fetch/{serviceName}")
    public void fetchService(@PathVariable("serviceName") String serviceName) {
        serviceInitializationStore.patchStore(serviceName);
    }
}
