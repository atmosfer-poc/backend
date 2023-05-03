update package set name = 'Basic' where id=1;
update package set name = 'Premium' where id=2;

insert into system_parameters (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                               last_modified_date, last_modified_via, transaction_id, description, key, value)
values (9, 0, now(), 'SYSTEM', true, false, null, null, null, 0, '', 'IS_SEND_MAIL', 'false');