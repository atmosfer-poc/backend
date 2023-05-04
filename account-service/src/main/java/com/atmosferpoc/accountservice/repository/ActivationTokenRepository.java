package com.atmosferpoc.accountservice.repository;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.ActivationToken;

import java.util.Optional;

public interface ActivationTokenRepository extends BaseJpaRepository<ActivationToken, Long> {
    Optional<ActivationToken> findTopByTokenOrderByCreatedDateDesc(String token);
}
