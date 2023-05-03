package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum AuthenticationMethodStatusType {
    ACTIVE(1L, 1L),
    PASSIVE(0L,2L);

    private final Long displayValue;
    private final Long databaseId;


    AuthenticationMethodStatusType(Long displayValue, Long databaseId) {
        this.displayValue = displayValue;
        this.databaseId = databaseId;
    }

    public static AuthenticationMethodStatusType fromDisplayValue(Long id) {
        for (AuthenticationMethodStatusType value : AuthenticationMethodStatusType.values()) {
            if (value.displayValue.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_AUTHENTICATION_METHOD_STATUS);
    }

    public static AuthenticationMethodStatusType fromDatabaseId(Long id) {
        for (AuthenticationMethodStatusType value : AuthenticationMethodStatusType.values()) {
            if (value.databaseId.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_AUTHENTICATION_METHOD_STATUS_DB);
    }
}
