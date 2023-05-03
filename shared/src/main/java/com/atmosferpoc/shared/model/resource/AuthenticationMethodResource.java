package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.shared.model.dto.TenantInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthenticationMethodResource extends BaseEntityResource {
    private Long id;
    private TenantInfo tenantInfo;
    private Long status;
}
