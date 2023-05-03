package com.atmosferpoc.shared.endpoints;

import com.atmosferpoc.shared.endpoints.base.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountEndpoints extends BaseEndpoints {
    public static final String ACCOUNTS = BASE + "/accounts";
    public static final String SCHEDULER_TRIGGER = BASE + "/scheduler-trigger";
    public static final String SCHEDULER_TRIGGER_ACCOUNT_STATUS = "/account-status";
    public static final String USERS = BASE + "/users";
    public static final String USER_SEARCH =  "/search";
    public static final String TEST = BASE + "/test";
    public static final String TEST_MAIL = "/mail/{email}";
    public static final String TEST_DOMAIN_UPDATE = "/domain-update";
    public static final String HEALTH = BASE + "/health";
    public static final String AUTH_FACTOR = "/authentication-factor";
    public static final String ASYNC_PROCESS = "/async-processes";
}
