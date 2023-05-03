package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class LicenceUsageDto extends BaseEntityDto {

    private TenantInfo tenantInfo;
    private Long packageId;

    @Override
    public void validate() {
        super.validate();

        tenantInfo.validate();

        if(Objects.isNull(packageId)){
            throw new GeneralException(ErrorStatusCode.PACKAGE_ID_MUST_NOT_NULL);
        }
    }
}
