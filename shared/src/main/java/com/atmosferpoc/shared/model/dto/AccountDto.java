package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.model.type.AccountType;
import com.atmosferpoc.core.model.type.AuthenticationFactorType;
import com.atmosferpoc.core.model.type.ChannelType;
import com.atmosferpoc.core.util.SecurityUtil;
import com.atmosferpoc.shared.util.FieldValidationUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
@ToString
public class AccountDto extends BaseEntityDto {

    @NotNull
    @Valid
    private TenantInfo tenantInfo;

    @NotBlank
    private String companyName;

    private String name;

    private String lastName;

    @NotBlank
    @Email
    private String mail;

    private String msisdn;

    private String freeTextAddress;

    private String hostName;

    private Long dbsCustomerId;

    @NotNull
    private AccountType type;

    private Long status;

    @NotBlank
    private String authenticationFactor;

    private boolean isMigration;

    @Valid
    private AuthenticationMethodDto authenticationMethod;

    @Valid
    private PasswordSecurityDto passwordSecurity;

    private String ldapUserName;

    private String title;

    @Override
    public void validate() {
        super.validate();

        if(Objects.nonNull(authenticationFactor)){
            AuthenticationFactorType.fromValue(authenticationFactor);
        } else {
            throw new GeneralException(ErrorStatusCode.AUTHENTICATION_FACTOR_MUST_NOT_NULL);
        }

        if (Objects.nonNull(mail) && !FieldValidationUtil.validateEmail(mail)) {
            throw new GeneralException(ErrorStatusCode.MAIL_WRONG_FORMAT);
        }

        if (Objects.nonNull(msisdn) && !FieldValidationUtil.validateMsisdn(msisdn)) {
            throw new GeneralException(ErrorStatusCode.MSISDN_WRONG_FORMAT);
        }

        ChannelType channel = SecurityUtil.getChannel();

        if (Arrays.asList(ChannelType.SUITE, ChannelType.DBS).contains(channel) && StringUtils.isBlank(msisdn)) {
            throw new GeneralException(ErrorStatusCode.MSISDN_MUST_NOT_NULL);
        }

        if (Objects.nonNull(name)) {
            FieldValidationUtil.validate(name);
        }

        if (Objects.nonNull(lastName)) {
            FieldValidationUtil.validate(lastName);
        }

        if (Objects.nonNull(companyName)) {
            FieldValidationUtil.validate(companyName);
        }

        if (Objects.nonNull(hostName)) {
            FieldValidationUtil.validateHostname(hostName);
        }

        if(Objects.nonNull(tenantInfo)){
            tenantInfo.validate();
        } else {
            throw new GeneralException(ErrorStatusCode.INVALID_TENANT);
        }

        if (Objects.nonNull(authenticationMethod)) {
            authenticationMethod.setTenantInfo(tenantInfo);
            authenticationMethod.validate();
        }

        if (Objects.nonNull(passwordSecurity)) {
            passwordSecurity.validate();
        }

        if (StringUtils.isNotBlank(mail)) {
            mail = mail.toLowerCase(Locale.ROOT);
        }
    }
}
