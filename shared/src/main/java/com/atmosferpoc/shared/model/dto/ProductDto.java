package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.shared.util.PhotoHelper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
public class ProductDto extends BaseEntityDto {
    private String name;
    private String description;
    private BigDecimal price;
    private MultipartFile image;

    @Override
    public void validate() {

        if(Objects.nonNull(image)){
            if (!PhotoHelper.hasPhotoFormat(image)) {
                throw new GeneralException(ErrorStatusCode.PHOTO_FORMAT_ERROR);
            }
        }

        super.validate();
    }
}
