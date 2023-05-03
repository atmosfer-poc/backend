package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SubscriptionStatusUpdateDto extends BaseEntityDto {
    private TenantInfo tenantInfo;
    @NotNull
    private Long packageId;
    @NotNull
    private Long paymentMethodId;

    private Long subscriptionId;
    @NotNull
    private Long status;
    private BigDecimal withdrawalFee;

    @Override
    public void validate() {
        super.validate();

        tenantInfo.validate();
    }
}
