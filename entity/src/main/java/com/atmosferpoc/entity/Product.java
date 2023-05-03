package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {
    private String name;
    private String description;
    private BigDecimal price;
    private String image;

    @Override
    public <T extends BaseEntity> void update(T entity) {

    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
