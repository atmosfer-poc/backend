package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.model.type.AccountIdType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
public class SubscriptionGetParamsDto extends BaseEntityDto {
    private List<Long> statusList = new ArrayList<>();
    private Long accountId;
    private AccountIdType idType;
    private String idValue;
    private Long crmCustomerId;

    @Override
    public void validate() {
        if (Objects.isNull(statusList) && Objects.isNull(accountId) && Objects.isNull(crmCustomerId) && (Objects.isNull(idType) || Objects.isNull(idValue))) {
            throw new GeneralException(ErrorStatusCode.SUBSCRIPTION_GET_VALIDATION);
        }
    }
}
