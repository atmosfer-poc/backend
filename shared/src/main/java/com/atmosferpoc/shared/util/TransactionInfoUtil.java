package com.atmosferpoc.shared.util;

import lombok.experimental.UtilityClass;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class TransactionInfoUtil {
    static final String ALPHA_NUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final String NUMERIC = "0123456789";
    static SecureRandom rnd = new SecureRandom();

    public static String generateTransactionDate(String format) {
        var formatter = new SimpleDateFormat(format);

        return formatter.format(new Date());
    }
    
    public static String generateAlphaNumericTransactionId(String prefix, int length) {
        String trxId = generateAlphaNumericTransactionId(length - prefix.length());
        
        return prefix.concat(trxId);
    }
    
    public static String generateNumericTransactionId(String prefix, int length) {
        String trxId = generateNumericTransactionId(length - prefix.length());
        
        return prefix.concat(trxId);
    }

    public static String generateAlphaNumericTransactionId(int length) {
        var sb = new StringBuilder(length);
        for(var i = 0; i < length; i++)
            sb.append(ALPHA_NUMERIC.charAt(rnd.nextInt(ALPHA_NUMERIC.length())));
        return sb.toString();
    }

    public static String generateNumericTransactionId(int length) {
        var sb = new StringBuilder(length);
        for(var i = 0; i < length; i++)
            sb.append(NUMERIC.charAt(rnd.nextInt(NUMERIC.length())));
        return sb.toString();
    }
}