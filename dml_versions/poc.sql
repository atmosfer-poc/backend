insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                                    last_modified_date, last_modified_via, transaction_id, require_basic_authentication,
                                    require_bearer_authentication, matcher)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false,
        '/product-service/v1/products/pageable');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                                    last_modified_date, last_modified_via, transaction_id, require_basic_authentication,
                                    require_bearer_authentication, matcher)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false,
        '/account-service/v1/users**');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'USER');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ADMIN');

insert into user_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ACTIVE');

insert into user_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'PASSIVE');

VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false,
        '/account-service/v1/token');

VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false,
        '/account-service/v1/token/logout');