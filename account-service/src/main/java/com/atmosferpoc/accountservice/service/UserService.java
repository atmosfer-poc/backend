package com.atmosferpoc.accountservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.User;

import java.util.Optional;

public interface UserService extends BaseEntityService<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> find(String username, String password);

    void checkDefaultUsers();
}
