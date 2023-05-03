package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum AuthenticationFactorType {

    TWO_FA("2FA"), ONE_FA("1FA");

    private final String value;

    AuthenticationFactorType(String value) {
        this.value = value;
    }

    public static AuthenticationFactorType fromValue(String authenticationFactor) {
        for (AuthenticationFactorType value : AuthenticationFactorType.values()) {
            if (value.value.equals(authenticationFactor)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_AUTHENTICATION_FACTOR);
    }
}
