package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.type.EulaStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Eula extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private EulaStatus status;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToMany(mappedBy = "eula", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EulaText> texts = new ArrayList<>();

    @Override
    public <T extends BaseEntity> void update(T entity) {
        var eula = (Eula) entity;

        if (Objects.nonNull(eula.getStatus())) {
            setStatus(eula.getStatus());
        }
    }
}
