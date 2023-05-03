package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.core.model.type.AccountStatusType;
import com.atmosferpoc.core.model.type.AccountType;
import com.atmosferpoc.shared.model.dto.TenantInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AccountResource extends BaseEntityResource {

    private TenantInfo tenantInfo;
    private Long userId;
    private Long authenticationMethodId;
    private String companyName;
    private Long dbsCustomerId;
    private List<AccountChannelResource> platforms;
    private String name;
    private String lastName;
    private String mail;
    private String msisdn;
    private String authenticationFactor;
    private String freeTextAddress;
    private String cityId;
    private String districtId;
    private AccountType type;
    private String hostName;
    private AccountStatusType status;
    private PasswordSecurityResource passwordSecurity;
}
