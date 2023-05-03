package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.model.type.AuthenticationMethodType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
public class AuthenticationMethodDto extends BaseEntityDto {
    private TenantInfo tenantInfo;

    @NotBlank
    private String url;

    @NotNull
    private AuthenticationMethodType type;

    @NotBlank
    private String userName;

    @ToString.Exclude
    private String password;

    @NotBlank
    private String ldapSearchBase;

    @NotBlank
    private String ldapSearchQuery;

    @ToString.Exclude
    @NotBlank
    private String ldapPasswordAttribute;

    private Long status;

    private String groupSearchBaseDN;

    private String groupSearchFilter;

    private String groupExclusionList;

    private String userLDAPGroupAttributes;

    private boolean isMigration;

    @NotBlank
    private String ssoSearchQuery;

    @Override
    public void validate() {
        super.validate();

        if (Objects.isNull(tenantInfo)) {
            throw new GeneralException(ErrorStatusCode.INVALID_TENANT);
        }
        tenantInfo.validate();
    }
}
