---- Security Configuration

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/product-service/api/products/pageable');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/portal-service/v2/api-docs');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/account-service/v2/api-docs');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/subscription-service/v2/api-docs');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (5, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/subscription-service/api/**');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (6, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/portal-service/api/v1/lovs/translations');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (7, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/portal-service/api/v1/lovs');

----- Channel

insert into channel (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'DBS');

insert into channel (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'YAANI_MAIL');

insert into channel (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'BIP_MEET');

insert into channel (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'LIFE_BOX');

insert into channel (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (5, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'SUIT');

insert into channel (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (6, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'SSO');

insert into channel (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (7, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ALL');

----- Application User


insert into application_user (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, client_key, client_secret, name, channel_id)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'a75a0b98-25a6-44dc-aa54-f96ad7b94ce6', '35a2a1c9-7438-4be7-b56a-8c6966301559', 'DBS', 1);

insert into application_user (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, client_key, client_secret, name, channel_id)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'c1e9f300-0af3-4d5e-a14f-41fd814e2b6c', '1e896d9d-bb54-4bf6-b590-df6971422ceb', 'YAANI_MAIL', 2);

insert into application_user (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, client_key, client_secret, name, channel_id)
VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, 0, '77a142e0-7bc1-43ed-ad80-37685b6675c3', 'a330dd21-190d-44ed-9fbe-1b21df41fbf8', 'BIP_MEET', 3);

insert into application_user (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, client_key, client_secret, name, channel_id)
VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, 0, '9fca39b7-4757-4bbf-ae97-a464e06ca900', '1057b88e-2820-4656-bbca-d522820d2d74', 'LIFE_BOX', 4);


----- Subscription Status

insert into subscription_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ACTIVE');

insert into subscription_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'DEACTIVE');

insert into subscription_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'GRACE_PERIOD');

insert into subscription_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'SUSPEND');


------ Role

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'USER');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ADMIN');

insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'BUSINESS');


insert into role (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'TENANT_MANAGER');

------- Account Status

insert into account_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ACTIVE');

insert into account_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'PASSIVE');

------- User Status

insert into user_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ACTIVE');

insert into user_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'PASSIVE');

------- Payment Method

insert into payment_method (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'KREDI KARTI');

------- Package

insert into package (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                     last_modified_date, last_modified_via, transaction_id, description, name, price, priority,
                     sardis_id)
values (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'Test', 'Test Package', 10, 1, 1);

------- Authentication Method Status

insert into authentication_method_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'ACTIVE');

insert into authentication_method_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'PASSIVE');