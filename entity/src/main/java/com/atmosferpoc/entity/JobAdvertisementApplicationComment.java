package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.shared.model.type.ApplicationAction;
import com.atmosferpoc.shared.model.type.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
public class JobAdvertisementApplicationComment extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private JobAdvertisementApplication application;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Enumerated(EnumType.STRING)
    private ApplicationAction action;

    @Override
    public <T extends BaseEntity> void update(T entity) {
    }
}
