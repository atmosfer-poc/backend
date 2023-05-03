package com.atmosferpoc.shared.model.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionUserCountResource {
    private Long activeUserCount;
    private Long basicLicenceCount;
    private Long premiumLicenceCount;
}
