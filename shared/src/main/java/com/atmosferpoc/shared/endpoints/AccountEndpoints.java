package com.atmosferpoc.shared.endpoints;

import com.atmosferpoc.shared.endpoints.base.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountEndpoints extends BaseEndpoints {
    public static final String ACCOUNTS = BASE + "/accounts";
    public static final String SCHEDULER_TRIGGER = BASE + "/scheduler-trigger";
    public static final String SCHEDULER_TRIGGER_ACCOUNT_STATUS = "/account-status";
    public static final String USERS = BASE + "/users";
    public static final String USER_ACTIVATE =  "/activate/{token}";
    public static final String USER_PWD_RESET =  "/password-reset";
    public static final String USER_PWD_RESET_CHECK_TOKEN =  "/password-reset/check-token/{token}";
    public static final String USER_PWD_RESET_CONFIRM =  "/password-reset/confirm/{token}";
    public static final String TEST = BASE + "/test";
    public static final String TEST_MAIL = "/mail/{email}";
    public static final String TEST_DOMAIN_UPDATE = "/domain-update";
    public static final String HEALTH = BASE + "/health";
    public static final String AUTH_FACTOR = "/authentication-factor";
    public static final String ASYNC_PROCESS = "/async-processes";
}
