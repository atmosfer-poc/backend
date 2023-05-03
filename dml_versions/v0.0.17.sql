alter table kafka_event_log add column event_transaction_id varchar(255);

insert into system_parameters (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                               last_modified_date, last_modified_via, transaction_id, description, key, value)
values (4, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'Göndeilen eventler için platformlardan callback beklenip beklenmeme durumu', 'WAIT_EVENT_CALLBACK', 'true');

insert into application_user (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, client_key, client_secret, name, channel_id)
VALUES (5, 0, now(), 'SYSTEM', true, false, null, null, null, 0, '5329f713-00cc-43a5-8a9d-6e7c59d4ed07', '14112737-65ab-4b6f-84f1-6c8129913117', 'SSO', 6);
