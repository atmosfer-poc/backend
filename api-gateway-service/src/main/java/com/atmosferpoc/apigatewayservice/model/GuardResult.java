package com.atmosferpoc.apigatewayservice.model;

import com.atmosferpoc.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
@Builder
public class GuardResult {
    private boolean allowContinue;
    private boolean authenticated;
    private boolean forbidden;
    private Optional<User> user;

    public static GuardResult permitAll() {
        return GuardResult
                .builder()
                .authenticated(false)
                .allowContinue(true)
                .forbidden(false)
                .build();
    }

    public static GuardResult unauthorized() {
        return GuardResult
                .builder()
                .authenticated(false)
                .forbidden(false)
                .allowContinue(false)
                .build();
    }

    public static GuardResult forbidden() {
        return GuardResult
                .builder()
                .authenticated(false)
                .allowContinue(false)
                .forbidden(true)
                .build();
    }
}
