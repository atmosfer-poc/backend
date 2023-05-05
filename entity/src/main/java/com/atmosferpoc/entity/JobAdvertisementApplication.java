package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.shared.model.type.ApplicationStatus;
import com.atmosferpoc.shared.model.type.JobAdvertisementStatus;
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
public class JobAdvertisementApplication extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private JobAdvertisements job;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private String name;
    private String surname;
    private String tckn;
    private String cvPath;
    private String city;
    private String phoneNumber;
    private String workType;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.PENDING_HR;

    @Override
    public <T extends BaseEntity> void update(T entity) {
        var application = (JobAdvertisementApplication) entity;

        if (Objects.nonNull(application.getStatus())) {
            status = application.getStatus();
        }
    }
}
