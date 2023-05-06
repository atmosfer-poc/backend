package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.model.type.UserStatusType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "poc_user")
public class User extends BaseEntity {
    private String name;

    private String surname;

    private String email;

    private String msisdn;

    @Column(length = 1000)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    private LocalDate dateOfBirth;

    @Override
    public <T extends BaseEntity> void update(T entity) {
        var user = (User) entity;

        if (Objects.nonNull(user.getName())) {
            name = user.getName();
        }

        if (Objects.nonNull(user.getSurname())) {
            surname = user.getSurname();
        }

        if (Objects.nonNull(user.getMsisdn())) {
            msisdn = user.getMsisdn();
        }

        if (Objects.nonNull(user.getRole())) {
            role = user.getRole();
        }

        if (Objects.nonNull(user.getEmail())) {
            email = user.getEmail();
        }

        if (Objects.nonNull(user.getPassword())) {
            password = user.getPassword();
        }

        if (Objects.nonNull(user.getStatus())) {
            UserStatus activeStatus = new UserStatus();
            activeStatus.setId(UserStatusType.ACTIVE.getId());
            activeStatus.setName(UserStatusType.ACTIVE);
            status = activeStatus;
        }
    }

    public static User defaultUser() {
        User user = new User();

        user.setName("Admin");
        user.setSurname("Admin");

        UserStatus userStatus = new UserStatus();
        userStatus.setName(UserStatusType.ACTIVE);
        userStatus.setId(UserStatusType.ACTIVE.getId());

        user.setStatus(userStatus);

        Role role = new Role();

        role.setId(RoleType.ADMIN.getId());
        role.setName(RoleType.ADMIN);

        user.setRole(role);

        user.setPassword("admin");
        user.setMsisdn("999999999999");
        user.setEmail("admin@admin.com");

        return user;
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
