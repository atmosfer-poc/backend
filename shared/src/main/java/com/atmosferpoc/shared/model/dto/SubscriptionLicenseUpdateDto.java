package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SubscriptionLicenseUpdateDto extends BaseEntityDto {
    private TenantInfo tenantInfo;
    private Long packageId;
    private Long subscriptionId;
    private Long licenceCount;
    private BigDecimal price;
    private Long paymentMethodId;

    @Override
    public void validate() {
        super.validate();

        tenantInfo.validate();
    }
}
