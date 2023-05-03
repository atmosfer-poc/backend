package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.type.LanguageType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class EulaText extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private LanguageType language;

    @ManyToOne(fetch = FetchType.LAZY)
    private Eula eula;

    private String fileFullPath;

    @Override
    public <T extends BaseEntity> void update(T entity) {
        throw new UnsupportedOperationException();
    }
}
