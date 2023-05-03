package com.atmosferpoc.apidocumentation.store;

import java.util.Optional;

public interface ServiceInitializationStore {
    Optional<String> pullService();

    void patchStore();

    void patchStore(String serviceName);

    boolean isPresent();
}
