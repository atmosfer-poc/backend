package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum SubscriptionStatusType {
    DEACTIVE(0L, 2L),
    ACTIVE(1L, 1L),
    SUSPEND(2L, 4L),
    GRACE_PERIOD(3L, 3L);

    private final Long displayValue;
    private final Long databaseId;

    SubscriptionStatusType(Long displayValue, Long databaseId) {
        this.displayValue = displayValue;
        this.databaseId = databaseId;
    }

    public static SubscriptionStatusType fromDisplayValue(Long id) {
        for (SubscriptionStatusType value : SubscriptionStatusType.values()) {
            if (value.displayValue.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_SUBSCRIPTION_STATUS);
    }

    public static SubscriptionStatusType fromDatabaseId(Long id) {
        for (SubscriptionStatusType value : SubscriptionStatusType.values()) {
            if (value.databaseId.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_SUBSCRIPTION_STATUS_DB);
    }
}
