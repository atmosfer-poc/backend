package com.atmosferpoc.cardservice.service.impl;

import com.atmosferpoc.cardservice.service.CardItemService;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.CardItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardItemServiceImpl extends AbstractEntityService<CardItem, Long> implements CardItemService {
    @Override
    public BaseJpaRepository<CardItem, Long> getJpaRepository() {
        return null;
    }
}
