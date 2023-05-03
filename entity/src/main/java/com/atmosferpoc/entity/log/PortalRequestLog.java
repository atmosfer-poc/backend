package com.atmosferpoc.entity.log;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class PortalRequestLog extends BaseWebLog {
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

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
