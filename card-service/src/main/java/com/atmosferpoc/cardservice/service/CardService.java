package com.atmosferpoc.cardservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.Card;
import com.atmosferpoc.shared.model.dto.CardGetParamsDto;

import java.util.List;

public interface CardService extends BaseEntityService<Card, Long> {

    Card saveCard(Card toEntity);

    List<Card> getCards(CardGetParamsDto dto);
}
