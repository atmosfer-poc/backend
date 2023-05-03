package com.atmosferpoc.apigatewayservice.repository;

import com.atmosferpoc.entity.SecurityConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityConfigurationRepository extends JpaRepository<SecurityConfiguration, Long> {
    List<SecurityConfiguration> findAllByIsDeletedIsFalseAndEnableIsTrueAndMatcherContainingOrderByCreatedDateDesc(String path);

    default List<SecurityConfiguration> findByPath(String path) {
        return findAllByIsDeletedIsFalseAndEnableIsTrueAndMatcherContainingOrderByCreatedDateDesc(path);
    }
}
