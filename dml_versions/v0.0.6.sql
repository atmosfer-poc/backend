insert into payment_method (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by, last_modified_date, last_modified_via, transaction_id, name)
VALUES (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'DBS');

update package set name = 'İşteSuit Basic' where id=1;

insert into package (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                     last_modified_date, last_modified_via, transaction_id, description, name, price, priority,
                     sardis_id)
values (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'Test', 'İşteSuit Premium', 10, 1, 1);