package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.shared.model.type.JobAdvertisementStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class JobAdvertisements extends BaseEntity {
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String image;

    @Enumerated(EnumType.STRING)
    private JobAdvertisementStatus status = JobAdvertisementStatus.OPEN;

    @Override
    public <T extends BaseEntity> void update(T entity) {

    }
}
