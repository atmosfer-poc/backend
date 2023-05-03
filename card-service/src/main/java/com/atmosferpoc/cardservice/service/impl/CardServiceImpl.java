package com.atmosferpoc.cardservice.service.impl;

import com.atmosferpoc.cardservice.repository.specifications.CardSpecifications;
import com.atmosferpoc.cardservice.service.CardService;
import com.atmosferpoc.cardservice.repository.CardRepository;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.Card;
import com.atmosferpoc.shared.model.dto.CardGetParamsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl extends AbstractEntityService<Card, Long> implements CardService {
    private final CardRepository cardRepository;

    @Override
    public Card saveCard(Card toEntity) {
        var card = save(toEntity);
        return card;
    }

    @Override
    public List<Card> getCards(CardGetParamsDto dto) {
        return cardRepository.findAll(CardSpecifications.prepareSpecifications(dto));
    }


    @Override
    public BaseJpaRepository<Card, Long> getJpaRepository() {
        return cardRepository;
    }
}
