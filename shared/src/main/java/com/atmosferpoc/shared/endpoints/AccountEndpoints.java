package com.atmosferpoc.shared.endpoints;

import com.atmosferpoc.shared.endpoints.base.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountEndpoints extends BaseEndpoints {
    public static final String USERS = BASE + "/users";
    public static final String USER_ACTIVATE =  "/activate/{token}";
    public static final String USER_PWD_RESET =  "/password-reset";
    public static final String USER_PWD_RESET_CHECK_TOKEN =  "/password-reset/check-token/{token}";
    public static final String USER_PWD_RESET_CONFIRM =  "/password-reset/confirm/{token}";
    public static final String HEALTH = BASE + "/health";
    public static final String EULA = BASE + "/eula";
}
