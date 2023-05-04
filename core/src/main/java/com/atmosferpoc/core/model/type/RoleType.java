package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum RoleType {
    APPLIER(1L),
    ADMIN(2L),
    HR(3L),
    TECHNICAL(4L),
    FINANCE(5L),
    UNASSIGNED(6L);

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
