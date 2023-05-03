package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.shared.model.dto.CardItemDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CardResource extends BaseEntityResource {
        private Long userId;
        private List<CardItemDto> cardItems;
}
