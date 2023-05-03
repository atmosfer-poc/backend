package com.atmosferpoc.core.entity;

import com.atmosferpoc.core.model.type.SourceVia;
import com.atmosferpoc.core.util.SecurityUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @CreatedDate
    @Column(nullable = false)
    protected Date createdDate;

    @LastModifiedDate
    protected Date lastModifiedDate;

    @Column(nullable = false)
    private Long createdBy;

    @Column
    private Long lastModifiedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SourceVia createdVia;

    @Enumerated(EnumType.STRING)
    private SourceVia lastModifiedVia;

    private boolean enable = true;

    private boolean isDeleted = false;

    private String transactionId;

    @PrePersist
    public void onCreate() {
        var calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 3);
        this.createdDate = calendar.getTime();
        this.lastModifiedDate = calendar.getTime();

        var authenticationInfo = SecurityUtil.getAuthenticationInfo();

        if (authenticationInfo.getLoggedUserId().isPresent()) {
            this.createdBy = authenticationInfo.getLoggedUserId().get();
        } else {
            this.createdBy = 0L;
        }

        if (authenticationInfo.getRequestedChannelId().isPresent()) {
            this.createdVia = SourceVia.fromId(authenticationInfo.getRequestedChannelId().get());
        } else {
            this.createdVia = SourceVia.SYSTEM;
        }

        this.transactionId = authenticationInfo.getTransactionId();
    }

    @PreUpdate
    public void onUpdate() {
        this.lastModifiedDate = new Date();

        var authenticationInfo = SecurityUtil.getAuthenticationInfo();

        if (authenticationInfo.getLoggedUserId().isPresent()) {
            this.lastModifiedBy = authenticationInfo.getLoggedUserId().get();
        } else {
            this.lastModifiedBy = 0L;
        }

        if (authenticationInfo.getRequestedChannelId().isPresent()) {
            this.lastModifiedVia = SourceVia.fromId(authenticationInfo.getRequestedChannelId().get());
        } else {
            this.lastModifiedVia = SourceVia.SYSTEM;
        }
    }

    public abstract <T extends BaseEntity> void update(T entity);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                '}';
    }
}
