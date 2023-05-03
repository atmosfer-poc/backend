package com.atmosferpoc.apidocumentation.service;

import com.atmosferpoc.apidocumentation.config.ServiceDefinitionsContext;
import com.atmosferpoc.apidocumentation.store.ServiceInitializationStore;
import com.atmosferpoc.core.exception.NotFoundException;
import com.atmosferpoc.shared.constant.ApplicationConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

import static com.atmosferpoc.shared.constant.ApplicationConstants.DEFAULT_SWAGGER_URL;
import static com.atmosferpoc.shared.constant.ApplicationConstants.GATEWAY_SERVICE_NAME;

@Component
@Slf4j
public class ServiceDescriptionUpdater {
    private final DiscoveryClient discoveryClient;
    private final RestTemplate template;
    private final ServiceDefinitionsContext definitionContext;
    private final ServiceInitializationStore serviceInitializationStore;
    private final Environment environment;

    public ServiceDescriptionUpdater(DiscoveryClient discoveryClient,
                                     ServiceDefinitionsContext definitionContext,
                                     ServiceInitializationStore serviceInitializationStore,
                                     Environment environment) {
        this.template = new RestTemplate();
        this.discoveryClient = discoveryClient;
        this.definitionContext = definitionContext;
        this.serviceInitializationStore = serviceInitializationStore;
        this.environment = environment;
    }

    @Scheduled(fixedDelayString = "${swagger.config.refresh-rate}")
    public void refreshSwaggerConfigurations() {
        while (serviceInitializationStore.isPresent()) {
            Optional<String> serviceNameOpt = serviceInitializationStore.pullService();
            if (serviceNameOpt.isPresent()) {
                String serviceName = serviceNameOpt.get();
                try {
                    log.info("{} service updating", serviceName);
                    if (discoveryClient.getServices().stream().anyMatch(service -> service.equals(serviceName))) {
                        log.info("{} is registered.", serviceName);
                        String targetSwaggerUrl = getSwaggerURL(serviceName);
                        // var jsonData = template.getForObject(targetSwaggerUrl, Object.class);

                        // definitionContext.addServiceDefinition(serviceName, (String) (((LinkedHashMap) jsonData).get("") == null ? getJSON(jsonData): ((LinkedHashMap) jsonData).get("")));
                    } else {
                        throw new NotFoundException("Servis bulunamadi !");
                    }
                } catch (Exception ex) {
                    log.error("Description updater error : {}", ex.getMessage());
                    serviceInitializationStore.patchStore(serviceName);
                }
            }
        }
    }

    private String getSwaggerURL(String targetServiceName) {
        if (environment.getActiveProfiles().length == 0
                || Arrays.stream(environment.getActiveProfiles()).anyMatch(profile -> profile.equals(ApplicationConstants.SPRING_PROFILE_DEVELOPMENT) || profile.equals(ApplicationConstants.SPRING_PROFILE_TEST))) {
            var gatewayUrl = discoveryClient.getInstances(GATEWAY_SERVICE_NAME).get(0).getUri().toString();
            return gatewayUrl + "/api/" + targetServiceName + DEFAULT_SWAGGER_URL;
        } else {
            var targetServicePort = discoveryClient.getInstances(targetServiceName).get(0).getUri().toString();
            return "http://" + targetServiceName + ":" + targetServicePort + "/" + DEFAULT_SWAGGER_URL;
        }
    }

    private String getJSON(Object jsonData) {
        try {
            return new ObjectMapper().writeValueAsString(jsonData);
        } catch (JsonProcessingException e) {
            log.error("Error : {} ", e.getMessage());
            return "";
        }
    }
}
