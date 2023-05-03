package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.IBaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LdapConnectionDto implements IBaseDto {

    @NotBlank
    private String url;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @Override
    public void validate() {
        if (!url.matches("ldap://(.*)|ldaps://(.*)")) {
            throw new GeneralException(ErrorStatusCode.LDAP_MUST_BE_STARTS_WITH_PROTOCOL);
        }
    }
}
