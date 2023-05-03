package com.atmosferpoc.shared.util;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;


@UtilityClass
public class FieldValidationUtil {
    private static final String EMAIL_REGEX_PATTERN = "[_\\-a-zA-Z0-9\\.\\+]+@[a-zA-Z0-9](\\.?[\\-a-zA-Z0-9]*[a-zA-Z0-9])*";
    private static final String HOSTNAME_PATTERN = "^[a-z0-9_-]*$";
    private static final Pattern CHARACTER_WHITELIST_PATTERN = Pattern.compile("^[a-zA-Z0-9_ğĞçÇşŞüÜöÖıİ+: / @\\.,&\\(\\)\\-]*$", Pattern.CASE_INSENSITIVE);
    private static final Pattern TURKISH_MSISDN_PATTERN = Pattern.compile("^((905))\\d{9}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateTCKN(String tckn) {

        if (tckn == null || tckn.length() != 11) {
            return false;
        }
        char[] tcknArray = tckn.toCharArray();
        int sum1 = Character.getNumericValue(tcknArray[0]) +
                Character.getNumericValue(tcknArray[2]) +
                Character.getNumericValue(tcknArray[4]) +
                Character.getNumericValue(tcknArray[6]) +
                Character.getNumericValue(tcknArray[8]);
        int sum2 = Character.getNumericValue(tcknArray[1]) +
                Character.getNumericValue(tcknArray[3]) +
                Character.getNumericValue(tcknArray[5]) +
                Character.getNumericValue(tcknArray[7]);
        int total = (7 * sum1 - sum2) % 10;
        if (total < 0) {
            total += 10;
        }
        return Character.getNumericValue(tcknArray[9]) == total &&
                Character.getNumericValue(tcknArray[10]) == ((sum1 + sum2 + total) % 10);

    }

    public static boolean validateTaxIdentificationNumber(String vkn) {
        int tmp;
        var sum = 0;
        if (vkn != null && vkn.length() == 10 && isInt(vkn)) {
            int lastDigit = Character.getNumericValue(vkn.charAt(9));
            for (var i = 0; i < 9; i++) {
                int digit = Character.getNumericValue(vkn.charAt(i));
                tmp = (digit + 10 - (i + 1)) % 10;
                sum = (int) (tmp == 9 ? sum + tmp : sum + ((tmp * (Math.pow(2, 10 - (i + 1)))) % 9));
            }
            return lastDigit == (10 - (sum % 10)) % 10;
        }
        return false;

    }

    public static boolean validateMsisdn(String id) {
        return TURKISH_MSISDN_PATTERN.matcher(id).matches();
    }

    public static boolean validateEmail(String email) {
        return Pattern.compile(EMAIL_REGEX_PATTERN)
                .matcher(email)
                .matches();
    }

    public static boolean isCrmCustomerId(String id) {
        return isInt(id);
    }

    public static boolean validateId(String id) {
        return isInt(id);
    }

    private static boolean isInt(String s) {
        if (s != null && s.length() != 0) {
            for (var a = 0; a < s.length(); a++) {
                if (a == 0 && s.charAt(a) == '-') continue;
                if (!Character.isDigit(s.charAt(a))) return false;
            }
        }
        return true;
    }

    public static void validateHostname(String hostName) {
        boolean isValid = Pattern.compile(HOSTNAME_PATTERN)
                .matcher(hostName)
                .matches();

        if (!isValid) {
            throw new GeneralException(ErrorStatusCode.HOSTNAME_INVALID_PATTERN);
        }
    }

    public static void validate(String value) {
        boolean isValid = CHARACTER_WHITELIST_PATTERN.matcher(value).matches();

        if (!isValid) {
            throw new GeneralException(ErrorStatusCode.INVALID_PATTERN, value);
        }
    }
}
