package com.atmosferpoc.shared.endpoints;

import com.atmosferpoc.shared.endpoints.base.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GatewayEndpoints extends BaseEndpoints {
    public static final String TOKEN = "v1/token";
    public static final String LOGOUT = "logout";
    public static final String CURRENT_USER = "current-user";
    public static final String HEALTH = "api/v1/health";
}
