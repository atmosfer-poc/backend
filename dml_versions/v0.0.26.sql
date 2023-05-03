update security_configuration set id = 83 where id=82;

update security_configuration set id = 82 where id=81;

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher, required_roles)
VALUES (81, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/portal-service/v1/users/profile-photo', 'ADMIN,TENANT_MANAGER,USER');