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
public class SubscriptionResourceList extends SubscriptionResource {
    private TenantInfo tenantInfo;
    private List<SubscriptionItemResource> subscriptionList = new ArrayList<>();
}
