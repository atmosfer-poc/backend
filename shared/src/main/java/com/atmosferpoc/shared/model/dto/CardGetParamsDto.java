package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.IBaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardGetParamsDto implements IBaseDto {
    private Long userId;

    @Override
    public void validate() {

    }
}
