
insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'APPLIER');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ADMIN');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'HR');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'TECHNICAL');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (5, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'FINANCE');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (6, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'UNASSIGNED');

insert into user_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ACTIVE');

insert into user_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'PASSIVE');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, matcher, require_basic_authentication, require_bearer_authentication)
VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, null, '/account-service/v1/token', false, false);

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, matcher, require_basic_authentication, require_bearer_authentication)
VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, null, '/account-service/v1/token/logout', false, false);

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, matcher, require_basic_authentication, require_bearer_authentication)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, null, '/account-service/v1/users', false, false);

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, matcher, require_basic_authentication, require_bearer_authentication)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, null, '/account-service/v1/users/activate/**', false, false);

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, matcher, require_basic_authentication, require_bearer_authentication)
VALUES (5, 0, now(), 'SYSTEM', true, false, null, null, null, null, '/account-service/v1/users/password-reset', false, false);

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, matcher, require_basic_authentication, require_bearer_authentication)
VALUES (6, 0, now(), 'SYSTEM', true, false, null, null, null, null, '/account-service/v1/users/password-reset/check-token/**', false, false);

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, matcher, require_basic_authentication, require_bearer_authentication)
VALUES (7, 0, now(), 'SYSTEM', true, false, null, null, null, null, '/account-service/v1/users/password-reset/confirm/**', false, false);
