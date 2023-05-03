package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class UserEula extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Eula eula;

    @Override
    public <T extends BaseEntity> void update(T entity) {
        throw new UnsupportedOperationException();
    }
}
