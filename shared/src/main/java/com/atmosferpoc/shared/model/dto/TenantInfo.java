package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.model.type.AccountIdType;
import com.atmosferpoc.shared.util.FieldValidationUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class TenantInfo extends BaseEntityDto {
    private Long crmCustomerId;
    private String idValue;
    private AccountIdType idType;
    private String ncst;
    private Long id;

    @Override
    public void validate() {
        super.validate();

        if (Objects.nonNull(id)) {
            return;
        }

        if (Objects.nonNull(crmCustomerId)) {
            return;
        }

        if (Objects.nonNull(idType) && Objects.nonNull(idValue)) {
            if (idType.equals(AccountIdType.TCKN)) {
                if (!FieldValidationUtil.validateTCKN(idValue)) {
                    throw new GeneralException(ErrorStatusCode.TCKN_WRONG_FORMAT);
                }

                return;
            } else if (idType.equals(AccountIdType.VKN)) {
                if (!FieldValidationUtil.validateTaxIdentificationNumber(idValue)) {
                    throw new GeneralException(ErrorStatusCode.VKN_WRONG_FORMAT);
                }

                return;
            }
        }

        throw new GeneralException(ErrorStatusCode.ACCOUNT_GET_VALIDATION);
    }

}
