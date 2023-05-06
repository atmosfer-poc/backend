package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.shared.model.type.JobAdvertisementStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JobAdvertisementApplication> applications = new ArrayList<>();

    @Override
    public <T extends BaseEntity> void update(T entity) {
        var advertisements = (JobAdvertisements) entity;

        if (!Objects.isNull(advertisements.getStatus())) {
            status = advertisements.getStatus();
        }
    }
}
