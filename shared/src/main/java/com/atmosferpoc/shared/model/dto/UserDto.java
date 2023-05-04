package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.util.SecurityUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
public class UserDto extends BaseEntityDto {
    private String name;
    private String surname;

    @NotBlank
    private String email;

    private String msisdn;

    @ToString.Exclude
    private String password;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @Override
    public void validate() {
        super.validate();

        if (!SecurityUtil.sourceIsMobil()) {
            if (StringUtils.isEmpty(name)) {
                throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Name must be not null");
            }

            if (StringUtils.isEmpty(surname)) {
                throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Surname must be not null");
            }

            if (StringUtils.isEmpty(msisdn)) {
                throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Msisdn must be not null");
            }

            if (Objects.isNull(dateOfBirth)) {
                throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Date of birth must be not null");
            }
        }
    }
}
