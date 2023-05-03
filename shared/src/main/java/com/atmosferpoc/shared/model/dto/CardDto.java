package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CardDto extends BaseEntityDto {

    private Long userId;
    private List<CardItemDto> cardItems;

    @Override
    public void validate() {
        super.validate();
    }
}
