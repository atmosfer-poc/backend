package com.atmosferpoc.entity.log;

import com.atmosferpoc.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseWebLog extends BaseEntity {
    @Column(columnDefinition="TEXT")
    private String request;

    @Column(columnDefinition="TEXT")
    private String response;

    @Column(columnDefinition="TEXT")
    private String requestHeaders;

    @Column(columnDefinition="TEXT")
    private String responseHeaders;

    private Long duration;

    private String resultCode;

    private String path;

    private String client;

    @Enumerated(EnumType.STRING)
    private HttpMethod httpMethod;

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
