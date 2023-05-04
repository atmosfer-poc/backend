package com.atmosferpoc.core.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HeaderNameConstants {
    public static final String TRANSACTION_ID = "x-transaction-id";
    public static final String TRANSACTION_TIME = "x-transaction-time";
    public static final String TRANSACTION_DURATION = "x-transaction-duration";

    public static final String AUTHENTICATED_USER_ID = "x-authenticated-user-id";
    public static final String AUTHENTICATED_USER_ROLE = "x-authenticated-user-role";
    public static final String IS_AUTHENTICATED = "x-is-authenticated";
    public static final String IS_MOBIL = "x-is-mobile";
}
