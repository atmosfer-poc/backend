package com.atmosferpoc.shared.constant;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class ApplicationConstants {
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_TEST = "test";

    public static final String GATEWAY_SERVICE_NAME = "gateway-service";
    public static final String DEFAULT_SWAGGER_URL = "/v2/api-docs";
    public static final List<String> EXCLUDE_SERVICE = Arrays.asList("eureka-server", GATEWAY_SERVICE_NAME, "api-documentation-service", "kafka-service", "migration-service");

    public static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";


    public static final String GENERAL_LOG_PATTERN = "Class : [%s] - Method : (%s) - Message : %s";
    public static final String ERROR_LOG_PATTERN = "Class : [%s] - Method : (%s) - Error : %s - Message : %s";

    public static final Long SYSTEM_VIA_STATIC_ID = 0L;

    public static final String LDAP_ATTRIBUTE_COMMON_NAME = "cn";
    public static final String LDAP_ATTRIBUTE_SURNAME = "sn";
    public static final String LDAP_ATTRIBUTE_UID = "uid";
    public static final String LDAP_ATTRIBUTE_GN = "gn";
    public static final String LDAP_ATTRIBUTE_GIVEN_NAME = "givenName";
}
