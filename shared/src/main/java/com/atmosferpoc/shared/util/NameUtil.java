package com.atmosferpoc.shared.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class NameUtil {
    public static String fullName(String username, String surname) {
        var sb = new StringBuilder("");

        if (StringUtils.isNotBlank(username)) {
            sb.append(username).append(" ");
        }

        if (StringUtils.isNotBlank(surname)) {
            sb.append(surname);
        }

        return sb.toString();
    }
}
