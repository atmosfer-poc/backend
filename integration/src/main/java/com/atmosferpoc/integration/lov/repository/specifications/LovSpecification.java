package com.atmosferpoc.integration.lov.repository.specifications;

import java.util.Objects;

import com.atmosferpoc.entity.Lov_;
import org.springframework.data.jpa.domain.Specification;

import com.atmosferpoc.core.model.type.LovType;
import com.atmosferpoc.entity.Lov;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LovSpecification {
	public static Specification<Lov> type(LovType type) {
        return (
            (root, query, criteriaBuilder) -> {
                if (Objects.isNull(type)) {
                    return null;
                } else {
                    return criteriaBuilder.equal(root.get(Lov_.type), type);
                }
            }
        );
    }

    public static Specification<Lov> parent(Long parentId) {
        return (
            (root, query, criteriaBuilder) -> {
                if (Objects.isNull(parentId)) {
                    return null;
                } else {
                    return criteriaBuilder.equal(root.get("parent"), parentId);
                }
            }
        );
    }
}
