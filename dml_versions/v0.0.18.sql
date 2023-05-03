insert into system_parameters (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                               last_modified_date, last_modified_via, transaction_id, description, key, value)
values (5, 0, now(), 'SYSTEM', true, false, null, null, null, 0, '', 'EXCEL_IMPORT_THREAD_COUNT', '5');

insert into system_parameters (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                               last_modified_date, last_modified_via, transaction_id, description, key, value)
values (6, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'Portal service user-eula latest check', 'EULA_CHECK_MOCK', 'false');

insert into eula (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, end_date, start_date, status)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, '01.01.2100', '01.01.2000', 'ACTIVE');

insert into eula_text (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, file_full_path, language, eula_id)
VALUES (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, '/data01/files/eula/v1.html', 'TR', 1);

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (13, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/portal-service/ws**');

insert into security_configuration (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, require_basic_authentication, require_bearer_authentication, matcher)
VALUES (14, 0, now(), 'SYSTEM', true, false, null, null, null, null, false, false, '/portal-service/ws/**');
