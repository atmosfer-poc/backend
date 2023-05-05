package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AdvertisementDto extends BaseEntityDto {
    private String title;
    private String content;
    private MultipartFile image;

    @JsonIgnore
    private String filePath;

    @Override
    public void validate() {
        super.validate();
    }
}
