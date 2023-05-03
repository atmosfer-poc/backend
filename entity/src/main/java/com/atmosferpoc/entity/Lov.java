package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.type.LovType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class Lov extends BaseEntity {
    @Column(columnDefinition="TEXT")
    private String displayName;

    private String term;

    @Enumerated(EnumType.STRING)
    private LovType type;

    @ManyToOne
    private Lov parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Lov> children;

    @Override
    public <T extends BaseEntity> void update(T entity) {
        throw new UnsupportedOperationException();
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
