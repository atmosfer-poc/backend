package com.atmosferpoc.core.model.type;

import lombok.Getter;

@Getter
public enum SystemParameterKeyType {
    ACCOUNT_STATUS_SUSPEND_DAY_LIMIT("30"),
    ACCOUNT_STATUS_DEACTIVE_DAY_LIMIT("120"),
    DBS_CUSTOMER_ID_REQUIRED_WHEN_CREATE_ACCOUNT("false"),
    WAIT_EVENT_CALLBACK("false"),
    EXCEL_IMPORT_THREAD_COUNT("5"),
    EULA_CHECK_MOCK("true"),
    IS_SEND_MAIL("false"),
    YAANI_CHECK_DISTRIBUTION("false"),
    ENC_KEY_SECOND_PART(""),
    LDAP_CONNECTION_MOCK("true"),
    YAANI_MAIL_TOKEN("");

    private final String defaultValue;

    SystemParameterKeyType(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}