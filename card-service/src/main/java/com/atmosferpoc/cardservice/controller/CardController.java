package com.atmosferpoc.cardservice.controller;

import com.atmosferpoc.cardservice.converter.CardConverter;
import com.atmosferpoc.cardservice.service.CardService;
import com.atmosferpoc.core.controller.AbstractEntityController;
import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.Card;
import com.atmosferpoc.shared.endpoints.CardEndpoints;
import com.atmosferpoc.shared.model.dto.CardDto;
import com.atmosferpoc.shared.model.resource.CardResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CardEndpoints.CARD)
@RequiredArgsConstructor
public class CardController extends AbstractEntityController<CardDto, Card, CardResource, Long> {
    private final CardService cardService;
    private final CardConverter cardConverter;

    @Override
    public CardResource save(CardDto dto) {
        var entity = cardService.saveCard(toEntity(dto));
        return toResource(entity);
    }

    @Override
    protected BaseEntityService<Card, Long> getService() {
        return cardService;
    }

    @Override
    protected BaseConverter<CardDto, Card, CardResource> getConverter() {
        return cardConverter;
    }
}
