package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.shared.security.TokenType;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
@Getter
@Setter
public class Token extends BaseEntity {
    @Column(nullable = false)
    private String accessToken;

    private String ssoToken;

    private String sessionId;

    @Column(nullable = false)
    private String refreshToken;

    private Long userId;

    @Column(columnDefinition = "integer default 0")
    private int refreshCount;

    private Date accessTokenExpirationDate;

    @Override
    public <T extends BaseEntity> void update(T entity) {
        var token = (Token) entity;

        if (StringUtils.isNotBlank(token.getAccessToken())) {
            setAccessToken(token.getAccessToken());
        }

        setEnable(token.isEnable());

        setRefreshCount(token.getRefreshCount());
    }
}
