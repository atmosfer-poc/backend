package com.atmosferpoc.productservice.repository.specifications;

import com.atmosferpoc.entity.Product;
import com.atmosferpoc.entity.Product_;
import com.atmosferpoc.shared.model.dto.ProductGetParamsDto;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

@UtilityClass
public class ProductSpecifications {

    public static Specification<Product> prepareSpecifications(ProductGetParamsDto dto) {
        return Specification
                .where(name(Optional.ofNullable(dto.getName())));
    }

    private static Specification<Product> name(Optional<String> name) {
        return ((root, query, criteriaBuilder) -> {
            if (name.isEmpty()) {
                return null;
            }

            return criteriaBuilder.equal(root.get(Product_.NAME), name.get());
        });
    }

}
