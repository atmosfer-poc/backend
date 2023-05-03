package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.IBaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductGetParamsDto implements IBaseDto {
    private String name;

    @Override
    public void validate() {
    }
}
