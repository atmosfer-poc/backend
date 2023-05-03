update account_status set name='SUSPEND' where id=2;

insert into account_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (3, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'DEACTIVE');

insert into account_status (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (4, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'DELETED');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (12, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/account-service/v1/scheduler-trigger/**');
