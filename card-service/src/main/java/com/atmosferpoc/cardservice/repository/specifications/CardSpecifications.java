package com.atmosferpoc.cardservice.repository.specifications;

import com.atmosferpoc.core.entity.BaseEntity_;
import com.atmosferpoc.entity.Card;
import com.atmosferpoc.entity.Card_;
import com.atmosferpoc.shared.model.dto.CardGetParamsDto;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

@UtilityClass
public class CardSpecifications {
    public static Specification<Card> prepareSpecifications(CardGetParamsDto dto) {
        return Specification
                .where(userId(Optional.ofNullable(dto.getUserId())));
    }

    private static Specification<Card> userId(Optional<Long> id) {
        return ((root, query, criteriaBuilder) -> {
            if (id.isEmpty()) {
                return null;
            }

            return criteriaBuilder.equal(root.get(Card_.USER).get(BaseEntity_.ID), id.get());
        });
    }
}
