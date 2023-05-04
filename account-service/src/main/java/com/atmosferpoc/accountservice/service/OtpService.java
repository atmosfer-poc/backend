package com.atmosferpoc.accountservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.Otp;
import com.atmosferpoc.entity.User;

public interface OtpService extends BaseEntityService<Otp, Long> {
    void send(User user);

    void validate(User user, String otpValue);
}
