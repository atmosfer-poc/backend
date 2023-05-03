package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SubscriptionItemResource extends BaseEntityResource {
    private Long id;
    private Long sardisSubscriptionId;
    private Long paymentMethodId;
    private String createdDate;
    private String endDate;
    private Boolean isCommitment;
    private String suspendDate;
    private BigDecimal price;
    private Long status;
    private Long licenceCount;
    private Long packageId;
    private String packageName;
    private String resellerName;
    private Boolean isPackageChange;
    private Long usedLicenceCount;
}
