package com.atmosferpoc.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 10000 - 20000 -> GENERAL CODES
 * 20000 - 30000 -> ACCOUNT CODES
 * 30000 - 40000 -> USER CODES
 * 40000 - 50000 -> AUTHENTICATION METHOD CODES
 * 50000 - 60000 -> SUBSCRIPTION CODES
 * 60000 - 70000 -> KAFKA CODES
 * 70000 - 80000 -> PORTAL CODES
 */
@AllArgsConstructor
@Getter
public enum ErrorStatusCode {
    UNEXPECTED_EXCEPTION(500, "%s", false, HttpStatus.INTERNAL_SERVER_ERROR),

    NOT_FOUND(10000, "Not Found", false, HttpStatus.NO_CONTENT),
    UNSUPPORTED_CHANNEL_TYPE(10001, "Unsupported channel type id.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_SOURCE_VIA(10002, "Unsupported source via.", false, HttpStatus.BAD_REQUEST),
    ERROR_KAFKA(10003, "Kafka error !", true, HttpStatus.INTERNAL_SERVER_ERROR),
    DB_ERROR(10004, "Db connection error !", true, HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_FIELD(10005, "Invalid Input !", true, HttpStatus.BAD_REQUEST),
    INVALID_TENANT(10006, "Invalid Tenant !", true, HttpStatus.BAD_REQUEST),
    TRX_ID_ALREADY_EXIST(10007, "Transaction id already exist !", true, HttpStatus.BAD_REQUEST),
    URL_NOT_VALID(10008, "Url must start with http or https", true, HttpStatus.INTERNAL_SERVER_ERROR),
    ACCOUNT_FORBIDDEN(10009, "Account Forbidden !", true, HttpStatus.BAD_REQUEST),
    REQUIRE_LOGGED_ACCOUNT_ID(10010, "Require logged account id !", true, HttpStatus.INTERNAL_SERVER_ERROR),

    SUBSCRIPTION_SARDIS_CREATE_ERROR(50000, "Sardis create subscription failed.", true, HttpStatus.INTERNAL_SERVER_ERROR),
    UNSUPPORTED_PACKAGE_ID(50001, "Unsupported package id.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_PAYMENT_METHOD(50002, "Unsupported payment method.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_PAYMENT_METHOD_DB(50003, "Unsupported payment method.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_SUBSCRIPTION_STATUS(50004, "Unsupported subscription status.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_SUBSCRIPTION_STATUS_DB(50005, "Unsupported subscription status.", false, HttpStatus.BAD_REQUEST),
    PACKAGE_ID_MUST_NOT_NULL(50006, "Package id cant be null !", false, HttpStatus.BAD_REQUEST),
    LICENCE_COUNT_VALIDATION(50007, "Licence Count must be greater than 0!", false, HttpStatus.BAD_REQUEST),
    SUBSCRIPTION_GET_VALIDATION(50008, "statusList or id or crmCustomer id or idType&idValue must be not null !", false, HttpStatus.BAD_REQUEST),
    SUBSCRIPTION_NOT_FOUND(50009, "Subscription not found.", false, HttpStatus.NO_CONTENT),
    SUBSCRIPTION_AVAILABLE_LICENCE(50010, "This Subscription dont have available licence!", false, HttpStatus.INTERNAL_SERVER_ERROR),
    SUBSCRIPTION_CREATE(50011, "This account already have this package you cant create !!", false, HttpStatus.INTERNAL_SERVER_ERROR),
    AVAILABLE_SUBSCRIPTION_NOT_FOUND(50011, "Available licence not found.", false, HttpStatus.BAD_REQUEST),
    PACKAGE_CHANGE_NOT_SUPPORTED(50012, "Package id change not supported", false, HttpStatus.BAD_REQUEST),
    PAYMENT_METHOD_CHANGE_NOT_SUPPORTED(50013, "Payment method change not supported", false, HttpStatus.BAD_REQUEST),
    CREATE_SUBSCRIPTION_NOT_SUPPORTED(50014, "Cant create subscription with this application user!!", false, HttpStatus.BAD_REQUEST),
    SUBSCRIPTION_NOT_SUPPORTED_FOR_ACCOUNT(50015, "This account cant have subscription!!", false, HttpStatus.BAD_REQUEST),
    SUBSCRIPTION_SAME_STATUS(50016, "Subscription status is same status!!", false, HttpStatus.BAD_REQUEST),
    SUBSCRIPTION_MULTIPLE_RESULT(50017, "Search criteria equals multiple result !", false, HttpStatus.BAD_REQUEST),

    ACCOUNT_MANAGER_NOT_FOUND(20000, "Account manager not found. Please contact system admin.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    ACCOUNT_ID_VALUE_ALREADY_EXIST(20002, "ID VALUE already Exist!", false, HttpStatus.BAD_REQUEST),
    ACCOUNT_NOT_FOUND(20001, "Account not found!", false, HttpStatus.NO_CONTENT),
    DSS_CRM_ERROR(20003, "DSS-CRM Error! ", true, HttpStatus.INTERNAL_SERVER_ERROR),
    CANT_CHANGE_EMAIL(20005, "Cant Change Email!!", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_AUTHENTICATION_FACTOR(20006, "Unsupported account authentication factor.", false, HttpStatus.BAD_REQUEST),
    HOSTNAME_MUST_NOT_NULL(20007, "Hostname must not be null!", false, HttpStatus.BAD_REQUEST),
    MAIL_WRONG_FORMAT(20008, "Mail format is not suitable.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_ACCOUNT_STATUS(20009, "Unsupported account status.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_ROLE(20010, "Unsupported role.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_AUTHENTICATION_METHOD_STATUS(20011, "Unsupported authentication method status.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_AUTHENTICATION_METHOD_STATUS_DB(20012, "Unsupported authentication method status.", false, HttpStatus.BAD_REQUEST),
    MSISDN_WRONG_FORMAT(20013, "Msisdn format should be 905555555555", false, HttpStatus.BAD_REQUEST),
    NAME_WRONG_FORMAT(20014, "Name format is not include any number or symbol", false, HttpStatus.BAD_REQUEST),
    LASTNAME_WRONG_FORMAT(20015, "Lastname format is not include any number or symbol", false, HttpStatus.BAD_REQUEST),
    ACCOUNT_GET_VALIDATION(20016, "id, crm customer id or idtype&idvalue must be not null !", false, HttpStatus.BAD_REQUEST),
    PASSWORD_LEVEL_VALIDATION(20017, "Password level cant be less than 3!", false, HttpStatus.BAD_REQUEST),
    TCKN_WRONG_FORMAT(20018, "Tckn invalid format", false, HttpStatus.BAD_REQUEST),
    VKN_WRONG_FORMAT(20019, "Vkn invalid format", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_USER_STATUS(20020, "Unsupported user status.", false, HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXIST(20004, "Email already Exist!", false, HttpStatus.BAD_REQUEST),
    ACCOUNT_LDAPUSERNAME_VALIDATION(20021, "ldapUserName must be not null !", false, HttpStatus.BAD_REQUEST),
    ACCOUNT_NOT_VALID(20022, "Invalid tenant info", false, HttpStatus.BAD_REQUEST),
    ACCOUNT_STATUS_NOT_ACCEPTED(20023, "Account status not accepted !", false, HttpStatus.BAD_REQUEST),
    USER_RELATED_ANOTHER_ACCOUNT(20024, "User exist another account", false, HttpStatus.BAD_REQUEST),
    ACCOUNT_CREATE_DBS_CUSTOMER_ID_REQUIRED(20025, "Dbs customer id must be not null.", false, HttpStatus.BAD_REQUEST),
    VKN_MISMATCH(20026, "Account Id Value mismatch!", false, HttpStatus.BAD_REQUEST),
    ACCOUNT_TWO_FA_NOT_ALLOWED(20027,"One factor authentication not allowed for this user.", false, HttpStatus.BAD_REQUEST),
    USER_ROLE_NOT_CHANGED(20028,"User role cannot be changed with this service..", false, HttpStatus.BAD_REQUEST),
    INVALID_USER_ACCOUNT(20029,"Invalid tenant info.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_PACKAGE_NAME(20030, "Unsupported package name.", false, HttpStatus.BAD_REQUEST),
    UNSUPPORTED_TENANT_MANAGER_CHANGE(20031, "Tenant manager change not allowed on this service.", false, HttpStatus.BAD_REQUEST),
    HOSTNAME_INVALID_PATTERN(20032, "Hostname pattern invalid", false, HttpStatus.BAD_REQUEST),
    INVALID_PATTERN(20032, "%s pattern invalid", false, HttpStatus.BAD_REQUEST),
    AUTHENTICATION_METHOD_NOT_DELETABLE(20033, "Auth method related users", false, HttpStatus.BAD_REQUEST),
    ACCOUNT_DONT_HAVE_AVAILABLE_DOMAIN(20034, "Account don't have available domain.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_ACCOUNT_DOMAIN_UNMATCHED(20035, "User and account domain must be equals.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    MSISDN_MUST_NOT_NULL(20036, "Msisdn cant be null !", false, HttpStatus.BAD_REQUEST),
    AUTHENTICATION_FACTOR_MUST_NOT_NULL(20037, "Authentication factor must not null", false, HttpStatus.BAD_REQUEST),

    EVENT_NOT_READABLE(30000, "Event not readable. Please contact system admin.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    DELETED_USER_NOT_UPDATED(30001, "Deleted user can not be updated.", false, HttpStatus.NO_CONTENT),
    YAANI_DISTRIBUTION_LIST(30002, "Invalid distribution list on yaani.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    YAANI_DOMAIN_CREATE_ERROR(30003, "Domain create process is failed !", false, HttpStatus.INTERNAL_SERVER_ERROR),
    YAANI_INVALID_FIELD_FOR_DOMAIN(30004, "Invalid field for domain.", false, HttpStatus.BAD_REQUEST),
    YAANI_USER_RELATED_DOMAIN(30005, "Users related this domain", false, HttpStatus.INTERNAL_SERVER_ERROR),

    FILE_FORMAT_ERROR(40000, "File format not supported !", false, HttpStatus.BAD_REQUEST),
    FILE_TOO_LARGE(40001, "File too large.", false, HttpStatus.BAD_REQUEST),
    FILE_READ_ERROR(40002, "File read error.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    FILE_EMPTY(40003, "File is empty.", false, HttpStatus.BAD_REQUEST),
    FILE_EXTENSION_REJECTED(40004, "File extension rejected.", false, HttpStatus.BAD_REQUEST),
    FILE_UPLOAD_ERROR(40005, "File upload error.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    EULA_ACTIVE_NOT_FOUND(40006, "Active eula not found.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    EULA_TR_NOT_FOUND(40007, "TR Active eula not found.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    EULA_READ_ERROR(40008, "Eula read error", false, HttpStatus.INTERNAL_SERVER_ERROR),
    LDAP_INVALID_CREDENTIALS(40009, "Invalid LDAP Credentials", false, HttpStatus.BAD_REQUEST),
    LDAP_UNKNOWN_ERROR(40010,"LDAP Authentication Failed",false,HttpStatus.INTERNAL_SERVER_ERROR),
    LDAP_MUST_BE_STARTS_WITH_PROTOCOL(40011,"Url must be starts with ldap://",false,HttpStatus.BAD_REQUEST),
    PHOTO_FORMAT_ERROR(40012, "Photo format not supported !", false, HttpStatus.BAD_REQUEST),

    USER_ACTIVITY_NOT_FOUND(70000, "Activity not found.", false, HttpStatus.NOT_FOUND),
    USER_ACTIVITY_NOT_DOWNLOADABLE(70001, "Activity not downloadable.", false, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_ACTIVITY_UNSUPPORTED_TYPE(70002, "Activity type not downloadable.", false, HttpStatus.INTERNAL_SERVER_ERROR),

    PRODUCT_NOT_FOUND(80001, "Product not found.", false, HttpStatus.NO_CONTENT),

    CARD_NOT_FOUND(90001, "Card not found.", false, HttpStatus.NO_CONTENT);

    private final int value;
    private final String description;
    private final boolean isRepeatable;
    private final HttpStatus httpStatus;

    public static ErrorStatusCode getByValue(int value) {
        for (ErrorStatusCode status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + value);
    }
}