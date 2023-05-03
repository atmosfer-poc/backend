package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum PaymentMethodType {
    CREDIT_CARD(0L, 1L),
    DBS(10L, 2L);

    private final Long displayValue;
    private final Long databaseId;

    PaymentMethodType(Long displayValue, Long databaseId) {
        this.displayValue = displayValue;
        this.databaseId = databaseId;
    }


    public static PaymentMethodType fromDisplayValue(Long id) {
        for (PaymentMethodType value : PaymentMethodType.values()) {
            if (value.displayValue.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_PAYMENT_METHOD);
    }

    public static PaymentMethodType fromDatabaseId(Long id) {
        for (PaymentMethodType value : PaymentMethodType.values()) {
            if (value.databaseId.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_PAYMENT_METHOD_DB);
    }

}
