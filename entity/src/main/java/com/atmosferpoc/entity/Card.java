package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Card extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "card", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CardItem> cardItems = new ArrayList<>();


    @Override
    public <T extends BaseEntity> void update(T entity) {

    }
}
