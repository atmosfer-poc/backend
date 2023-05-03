---- Security Configuration

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (8, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/portal-service/api/v1/parameters');

