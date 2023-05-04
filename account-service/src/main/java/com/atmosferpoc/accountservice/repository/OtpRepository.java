package com.atmosferpoc.accountservice.repository;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.Otp;

import java.util.Optional;

public interface OtpRepository extends BaseJpaRepository<Otp, Long> {
    Optional<Otp> findTopByUserIdAndValueOrderByCreatedDateDesc(Long userId, String otpValue);
}
