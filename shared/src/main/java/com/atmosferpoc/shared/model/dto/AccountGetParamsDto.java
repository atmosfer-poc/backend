package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.IBaseDto;
import com.atmosferpoc.core.model.type.AccountIdType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountGetParamsDto implements IBaseDto {
    private AccountIdType idType;
    private String idValue;
    private Long crmCustomerId;
    private String ncst;
    private Long id;

    @Override
    public void validate() {
        if (Objects.isNull(id) && Objects.isNull(crmCustomerId) && (Objects.isNull(idType) || Objects.isNull(idValue))) {
            throw new GeneralException(ErrorStatusCode.ACCOUNT_GET_VALIDATION);
        }
    }
}
