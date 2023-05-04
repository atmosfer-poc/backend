package com.atmosferpoc.accountservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.User;

import java.util.Optional;

public interface UserService extends BaseEntityService<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> find(String username, String password);

    void checkDefaultUsers();

    Optional<User> findActive(String username, String password);

    void activate(String token);

    void passwordReset(String email);

    User checkPwdResetToken(String token);

    void confirmPwdReset(String token, String password);
}
