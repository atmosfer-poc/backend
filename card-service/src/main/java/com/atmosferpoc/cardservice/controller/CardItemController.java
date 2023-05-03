package com.atmosferpoc.cardservice.controller;

import com.atmosferpoc.core.controller.AbstractEntityController;
import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.CardItem;
import com.atmosferpoc.shared.model.dto.CardItemDto;
import com.atmosferpoc.shared.model.resource.CardItemResource;

public class CardItemController extends AbstractEntityController<CardItemDto, CardItem, CardItemResource, Long> {


    @Override
    protected BaseEntityService<CardItem, Long> getService() {
        return null;
    }

    @Override
    protected BaseConverter<CardItemDto, CardItem, CardItemResource> getConverter() {
        return null;
    }
}
