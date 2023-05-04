package com.atmosferpoc.accountservice.repository;

import com.atmosferpoc.core.model.type.UserStatusType;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.User;

import java.util.Optional;

public interface UserRepository extends BaseJpaRepository<User, Long> {
    Optional<User> findTopByEmail(String email);
    Optional<User> findTopByEmailAndStatusName(String email, UserStatusType status);
    Optional<User> findTopByIdAndStatusName(Long userId, UserStatusType status);
    boolean existsByEmail(String email);

    Optional<User> findTopByEmailAndPassword(String email, String password);
    Optional<User> findTopByEmailAndPasswordAndStatusName(String email, String password, UserStatusType status);
}
