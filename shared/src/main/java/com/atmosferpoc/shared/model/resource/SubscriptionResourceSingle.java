package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.shared.model.dto.TenantInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SubscriptionResourceSingle extends SubscriptionResource {
    private TenantInfo tenantInfo;
    private Long subscriptionId;
    private Long sardisSubscriptionId;
    private Long licenceCount;
    private BigDecimal price;
    private Long status;
    private Long paymentMethodId;
    private String transactionId;
    private BigDecimal withdrawalFee;
    private Long packageId;
    private String packageName;
    private String resellerName;
    private String companyName;
    private String createdDate;
    private String endDate;
    private long usedLicenseCount;
    private String suspendDate;
    private Boolean isCommitment;
}
