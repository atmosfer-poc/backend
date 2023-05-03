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
public class PasswordSecurityDto extends BaseEntityDto {

    private Integer level; // Şifre güvenlik seviyesi (1-Az, 2-Orta, 3-Çok Güvenli)
    private Integer period; // 1
    private Integer periodLength; // 3 ayda bir 5 ayda bir vs
    private boolean showChangePassword; // Admin yetkilerine sahip kullanıcıya şifre değiştirme işlemi izni verilsin mi?
    private boolean showResetPassword; // Admin yetkilerine sahip kullanıcıya şifremi unuttum işlemi izniverilsin mi?
    private boolean showAuthenticationFactor; // Admin yetkilerine sahip kullanıcıya 2 Faktörlü Doğrulama özelliğini açma kapama izni verilsin mi?

    @Override
    public void validate() {
        super.validate();

        if(Objects.isNull(level) || level<3){
            throw new GeneralException(ErrorStatusCode.PASSWORD_LEVEL_VALIDATION);
        }
    }
}
