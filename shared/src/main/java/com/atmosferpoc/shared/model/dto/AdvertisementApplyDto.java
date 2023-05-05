package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AdvertisementApplyDto extends BaseEntityDto {
    private String tckn;
    private String name;
    private String surname;
    private MultipartFile cv;
    private String city;
    private String phoneNumber;
    private String workType;

    @Override
    public void validate() {
        super.validate();
    }
}
