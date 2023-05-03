---- Security Configuration

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (10, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/token');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (11, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/token/refresh');

update security_configuration set matcher = '/account-service/v1/**' where id=1;
update security_configuration set matcher = '/portal-service/v2/api-docs' where id=2;
update security_configuration set matcher = '/account-service/v2/api-docs' where id=3;
update security_configuration set matcher = '/subscription-service/v2/api-docs' where id=4;
update security_configuration set matcher = '/subscription-service/v1/**' where id=5;
update security_configuration set matcher = '/portal-service/v1/lovs/translations' where id=6;
update security_configuration set matcher = '/portal-service/v1/lovs' where id=7;
update security_configuration set matcher = '/portal-service/v1/parameters' where id=8;
update security_configuration set matcher = '/portal-service/v1/sso/token-validate/**' where id=9;

