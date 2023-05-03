package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum UserStatusType {
    ACTIVE(1L,"1"),
    DELETED(3L,"0"),
    DEACTIVE(2L,"2");

    private final Long id;
    private final String displayId;

    UserStatusType(Long id, String displayId) {
        this.id = id;
        this.displayId = displayId;
    }

    public static UserStatusType fromId(Long id) {
        for (UserStatusType value : UserStatusType.values()) {
            if (value.id.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_USER_STATUS);
    }

    public static UserStatusType fromDisplayId(String displayId) {
        for (UserStatusType value : UserStatusType.values()) {
            if (value.displayId.equals(displayId)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_USER_STATUS);
    }
}
