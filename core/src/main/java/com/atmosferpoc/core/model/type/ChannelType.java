package com.atmosferpoc.core.model.type;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum ChannelType {
    DBS(1L),
    YAANIMAIL(2L),
    BIPMEET(3L),
    LIFEBOXBUSINESS(4L),
    SUITE(5L),
    SSO(6L),
    ALL(7L);

    private final Long id;

    ChannelType(Long id) {
        this.id = id;
    }

    public static ChannelType fromId(Long id) {
        for (ChannelType value : ChannelType.values()) {
            if (value.id.equals(id)) {
                return value;
            }
        }

        throw new GeneralException(ErrorStatusCode.UNSUPPORTED_CHANNEL_TYPE);
    }

    public static List<ChannelType> getPlatforms() {
        List<ChannelType> platforms = new ArrayList<>();

        platforms.add(ChannelType.BIPMEET);
        platforms.add(ChannelType.LIFEBOXBUSINESS);
        platforms.add(ChannelType.SUITE);
        platforms.add(ChannelType.YAANIMAIL);

        return platforms;
    }
}
