package com.atmosferpoc.apidocumentation.store.impl;

import com.atmosferpoc.apidocumentation.store.ServiceInitializationStore;
import com.atmosferpoc.shared.constant.ApplicationConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

@Component
@Slf4j
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequiredArgsConstructor
public class ServiceInitializationStoreImpl implements ServiceInitializationStore {
    private static Queue<String> SERVICES = new LinkedList<>();

    private final DiscoveryClient discoveryClient;

    private void pushService(String serviceName) {
        ServiceInitializationStoreImpl.SERVICES.add(serviceName);
    }

    @Override
    public Optional<String> pullService() {
        return Optional.ofNullable(SERVICES.poll());
    }

    @Override
    public void patchStore() {
       internalPatchStore(null);
    }

    @Override
    public void patchStore(String serviceName) {
        internalPatchStore(serviceName);
    }

    @Override
    public boolean isPresent() {
        return !SERVICES.isEmpty();
    }

    private void internalPatchStore(String service) {
        if (service != null && discoveryClient.getInstances(service) != null) {
            pushService(service);
        } else {
            for (String serviceName : discoveryClient.getServices()) {
                if (!ApplicationConstants.EXCLUDE_SERVICE.contains(serviceName)) {
                    log.info("{} added documentation queue.", serviceName);
                    pushService(serviceName);
                }
            }
        }


    }
}
