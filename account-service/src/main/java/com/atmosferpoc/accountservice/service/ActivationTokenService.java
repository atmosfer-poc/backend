package com.atmosferpoc.accountservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.ActivationToken;
import com.atmosferpoc.entity.User;

public interface ActivationTokenService extends BaseEntityService<ActivationToken, Long> {
    void sendActivationMail(User user);

    Long validate(String token);
}
