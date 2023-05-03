package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum RoleType {
    USER(1L),
    ADMIN(2L),
    BUSINESS(3L),
    TENANT_MANAGER(4L),
    BLOCKED(5L);

    private final Long id;

    RoleType(Long id) {
        this.id = id;
    }

    public static RoleType fromId(Long id) {
        for (RoleType value : RoleType.values()) {
            if (value.id.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_ROLE);
    }
}
