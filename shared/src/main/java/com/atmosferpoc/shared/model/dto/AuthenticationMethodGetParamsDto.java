package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.IBaseDto;
import com.atmosferpoc.core.model.type.AccountIdType;
import com.atmosferpoc.core.model.type.AuthenticationMethodStatusType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Getter
@Setter
@ToString
public class AuthenticationMethodGetParamsDto implements IBaseDto {
    private AccountIdType idType;
    private String idValue;
    private Long accountId;
    private Long crmCustomerId;
    private String ncst;
    private Long id;
    private String status;

    @Override
    public void validate() {
        if (Objects.isNull(id) && Objects.isNull(crmCustomerId) && (Objects.isNull(idType) || Objects.isNull(idValue)) && Objects.isNull(accountId)) {
            throw new GeneralException(ErrorStatusCode.ACCOUNT_GET_VALIDATION);
        }
    }

    public String getStatus() {
        if (StringUtils.isBlank(status)) {
            return String.valueOf(AuthenticationMethodStatusType.ACTIVE.getDisplayValue());
        } else {
            return status;
        }
    }
}
