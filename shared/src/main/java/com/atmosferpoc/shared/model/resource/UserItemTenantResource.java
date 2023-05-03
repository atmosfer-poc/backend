package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.shared.model.dto.TenantInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserItemTenantResource extends UserItemResource{

    private TenantInfo tenantInfo;

}
