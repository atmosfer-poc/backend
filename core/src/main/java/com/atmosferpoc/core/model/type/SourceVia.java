package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

@Getter
public enum SourceVia {
    BIP_MEET(3L),
    YAANI_MAIL(2L),
    LIFE_BOX(4L),
    SUIT(5L),
    DBS(1L),
    SYSTEM(0L),
    SSO(6L);

    private final Long id;

    SourceVia(Long id) {
        this.id = id;
    }

    public static SourceVia fromId(Long id) {
        for (SourceVia value : SourceVia.values()) {
            if (value.id.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_SOURCE_VIA);
    }
}
