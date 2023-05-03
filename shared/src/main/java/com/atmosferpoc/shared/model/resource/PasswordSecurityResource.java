package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PasswordSecurityResource  extends BaseEntityResource {

    private Integer level;
    private Integer period;
    private Integer periodLength;
    private boolean showChangePassword;
    private boolean showResetPassword;
    private boolean showAuthenticationFactor;

}
