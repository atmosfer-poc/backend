insert into system_parameters (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                               last_modified_date, last_modified_via, transaction_id, description, key, value)
values (1, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'Suspend statusune çekildikten sonra x gün geçmişse deactive statusune alınması', 'ACCOUNT_STATUS_SUSPEND_DAY_LIMIT', '30');

insert into system_parameters (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                               last_modified_date, last_modified_via, transaction_id, description, key, value)
values (2, 0, now(), 'SYSTEM', true, false, null, null, null, 0, 'Deactive statusune çekildikten sonra x gün geçmişse deleted statusune alınması', 'ACCOUNT_STATUS_DEACTIVE_DAY_LIMIT', '120');