package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.shared.model.dto.TenantInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class AuthenticationMethodDetailResource {
    private TenantInfo tenantInfo;

    private List<AuthenticationMethodDetailItem> authenticationMethodList = new ArrayList<>();
}
