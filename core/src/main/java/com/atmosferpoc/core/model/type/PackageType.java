package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum PackageType {
    BASIC(1L),
    PREMIUM(2L);

    private final Long id;

    PackageType(Long id) {
        this.id = id;
    }

    public static PackageType fromId(Long id) {
        for (PackageType value : PackageType.values()) {
            if (value.id.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_PACKAGE_ID);
    }
}
