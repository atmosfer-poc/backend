package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum AccountStatusType {
    ACTIVE(1L, 1L),
    SUSPEND(2L, 2L),
    DEACTIVE(3L, 3L),
    DELETED(4L, 0L);

    private final Long databaseId;
    private final Long displayId;

    AccountStatusType(Long databaseId, Long displayId) {
        this.databaseId = databaseId;
        this.displayId = displayId;
    }

    public static AccountStatusType fromDatabaseId(Long id) {
        for (AccountStatusType value : AccountStatusType.values()) {
            if (value.databaseId.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_ACCOUNT_STATUS);
    }

    public static AccountStatusType fromDisplayId(Long id) {
        for (AccountStatusType value : AccountStatusType.values()) {
            if (value.displayId.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_ACCOUNT_STATUS);
    }
}
