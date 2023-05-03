package com.atmosferpoc.accountservice.repository;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.Token;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends BaseJpaRepository<Token, Long> {
    boolean existsByAccessTokenAndEnableIsTrue(String accessToken);

    Optional<Token> findTopByAccessTokenAndEnableIsTrueOrderByCreatedDateDesc(String accessToken);

    Optional<Token> findByUserIdAndEnableIsTrue(Long userId);

    default Optional<Token> getActiveToken(Long userId) {
        return findByUserIdAndEnableIsTrue(userId);
    }

    List<Token> getAllByEnableIsTrueAndUserId(Long userId);
}
