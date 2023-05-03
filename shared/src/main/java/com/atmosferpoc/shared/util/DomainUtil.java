package com.atmosferpoc.shared.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DomainUtil {
    // TODO: bkocoglu bunun doğruluğunu teyit edip tüm domain setleme işlemlerinde kullanılmalı.
    public String emailToDomain(String email) {
        String[] split = email.split("@");

        if (split.length == 2) {
            return split[1];
        }

        return null;
    }
}
