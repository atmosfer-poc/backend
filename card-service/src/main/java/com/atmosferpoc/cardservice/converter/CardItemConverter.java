package com.atmosferpoc.cardservice.converter;

import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.entity.CardItem;
import com.atmosferpoc.shared.model.dto.CardItemDto;
import com.atmosferpoc.shared.model.resource.CardItemResource;

public class CardItemConverter implements BaseConverter<CardItemDto, CardItem, CardItemResource> {
    @Override
    public CardItemResource toResource(CardItem entity) {
        return null;
    }

    @Override
    public CardItem toEntity(CardItemDto dto) {

        return null;
    }
}
