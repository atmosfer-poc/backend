package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.type.RoleType;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class SecurityConfiguration extends BaseEntity {
    private String matcher;

    private boolean requireBasicAuthentication;

    private boolean requireBearerAuthentication;

    private String requiredRoles;

    public List<RoleType> splitRequiredRoles() {
        if (StringUtils.isBlank(requiredRoles)) {
            return Collections.emptyList();
        }

        return List.of(requiredRoles.split(",")).stream().map(RoleType::valueOf).collect(Collectors.toList());
    }

    @Override
    public <T extends BaseEntity> void update(T entity) {
        throw new UnsupportedOperationException();
    }
}
