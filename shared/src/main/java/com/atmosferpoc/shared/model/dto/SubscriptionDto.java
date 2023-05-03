package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.model.type.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class SubscriptionDto extends BaseEntityDto {
    @NotNull
    @Valid
    private TenantInfo tenantInfo;

    @NotNull
    private Long packageId;

    @NotNull
    private Long licenceCount;


    private BigDecimal price;

    @NotNull
    private Long paymentMethodId;

    private String resellerName;

    private Date endDate;

    private Boolean isCommitment;

    private Boolean isPackageChange;

    @Override
    public void validate() {
        super.validate();
        tenantInfo.validate();

        if (licenceCount<=0){
            throw new GeneralException(ErrorStatusCode.LICENCE_COUNT_VALIDATION);
        }
        PaymentMethodType.fromDisplayValue(paymentMethodId);
    }
}
