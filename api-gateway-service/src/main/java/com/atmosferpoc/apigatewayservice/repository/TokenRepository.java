package com.atmosferpoc.apigatewayservice.repository;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.Token;

import java.util.Optional;

public interface TokenRepository extends BaseJpaRepository<Token, Long> {
    boolean existsByAccessTokenAndEnableIsTrue(String accessToken);

    Optional<Token> findByUserIdAndEnableIsTrue(Long userId);
}
