package com.atmosferpoc.cardservice.converter;

import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.entity.Card;
import com.atmosferpoc.entity.CardItem;
import com.atmosferpoc.entity.Product;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.shared.model.dto.CardDto;
import com.atmosferpoc.shared.model.dto.CardItemDto;
import com.atmosferpoc.shared.model.resource.CardResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardConverter implements BaseConverter<CardDto, Card, CardResource> {

    @Override
    public CardResource toResource(Card entity) {
        var resource = new CardResource();

        var userEntity = new User();
        userEntity.setId(entity.getUser().getId());
        resource.setUserId(userEntity.getId());

        List<CardItemDto> cardItemDtos = new ArrayList<>();
        var cardItems = entity.getCardItems();
        for (CardItem cardItem : cardItems) {
            var cardItemDto = new CardItemDto();

            var productEntity = new Product();
            productEntity.setId(cardItem.getProduct().getId());
            cardItemDto.setProductId(productEntity.getId());

            cardItemDto.setCount(cardItem.getCount());

            cardItemDtos.add(cardItemDto);
        }
        resource.setCardItems(cardItemDtos);

        return resource;
    }

    public CardResource toGetResource(List<Card> resources) {
        var resource = new CardResource();
        var entity = resources.get(0);

        var userEntity = new User();
        userEntity.setId(entity.getUser().getId());
        resource.setUserId(userEntity.getId());

        List<CardItemDto> cardItemDtos = new ArrayList<>();
        var cardItems = entity.getCardItems();
        for (CardItem cardItem : cardItems) {
            var cardItemDto = new CardItemDto();

            var productEntity = new Product();
            productEntity.setId(cardItem.getProduct().getId());
            cardItemDto.setProductId(productEntity.getId());

            cardItemDto.setCount(cardItem.getCount());

            cardItemDtos.add(cardItemDto);
        }
        resource.setCardItems(cardItemDtos);

        return resource;
    }

    @Override
    public Card toEntity(CardDto dto) {
        var entity = new Card();

        var userEntity = new User();
        userEntity.setId(dto.getUserId());
        entity.setUser(userEntity);

        List<CardItem> cardItems = new ArrayList<>();
        var cardItemDtos = dto.getCardItems();
        for (CardItemDto cardItemDto : cardItemDtos) {
            var cardItem = new CardItem();

            var productEntity = new Product();
            productEntity.setId(cardItemDto.getProductId());
            cardItem.setProduct(productEntity);

            cardItem.setCount(cardItemDto.getCount());

            cardItems.add(cardItem);
        }
        entity.setCardItems(cardItems);

        return entity;
    }
}
