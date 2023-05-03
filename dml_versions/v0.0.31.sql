insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher, required_roles)
VALUES (84, 0, now(), 'SYSTEM', true, false, null, null, null, null, true, true, '/account-service/v1/accounts/authentication-factor', 'ADMIN,TENANT_MANAGER');

update system_parameters set value = '1' where key='EXCEL_IMPORT_THREAD_COUNT';
