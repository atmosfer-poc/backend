package com.atmosferpoc.accountservice.repository;

import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.entity.User;

import java.util.Optional;

public interface UserRepository extends BaseJpaRepository<User, Long> {
    Optional<User> findTopByEmail(String email);

    Optional<User> findTopByEmailAndPassword(String email, String password);
}
