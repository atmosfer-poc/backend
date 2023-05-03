package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardItemDto extends BaseEntityDto {

    private Long productId;
    private int count;

    @Override
    public void validate() {
        super.validate();
    }
}
