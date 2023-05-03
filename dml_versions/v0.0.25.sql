insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (5, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'BLOCKED');

update security_configuration set id = 50 where matcher = '/subscription-service/v2/api-docs';

update security_configuration set id = 60 where matcher = '/subscription-service/v1/**';

update security_configuration set required_roles = 'ADMIN,TENANT_MANAGER' where matcher='/subscription-service/v1/**';

update security_configuration set required_roles = 'ADMIN,TENANT_MANAGER' where matcher='/account-service/v1/**';

update security_configuration set id = 70 where matcher = '/portal-service/v2/api-docs';
update security_configuration set id = 71 where matcher = '/portal-service/ws**';
update security_configuration set id = 72 where matcher = '/portal-service/ws/**';
update security_configuration set id = 73 where matcher = '/portal-service/v1/lovs/translations';
update security_configuration set id = 74 where matcher = '/portal-service/v1/lovs';
update security_configuration set id = 75 where matcher = '/portal-service/v1/parameters';
update security_configuration set id = 76 where matcher = '/portal-service/v1/sso/token-validate/**';

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher, required_roles)
VALUES (77, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/portal-service/v1/accounts**', 'ADMIN,TENANT_MANAGER');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher, required_roles)
VALUES (78, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/portal-service/v1/ldap**', 'ADMIN,TENANT_MANAGER');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher, required_roles)
VALUES (79, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/portal-service/v1/subscriptions**', 'ADMIN,TENANT_MANAGER');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher, required_roles)
VALUES (80, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/portal-service/v1/user/activities**', 'ADMIN,TENANT_MANAGER');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher, required_roles)
VALUES (81, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/portal-service/v1/users**', 'ADMIN,TENANT_MANAGER');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher, required_roles)
VALUES (82, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/portal-service/v1/yaani-mail**', 'ADMIN,TENANT_MANAGER');
