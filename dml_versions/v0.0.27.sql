insert into system_parameters (id, created_by, created_date, created_via, enable, is_deleted, last_modified_by,
                               last_modified_date, last_modified_via, transaction_id, description, key, value)
values (12, 0, now(), 'SYSTEM', true, false, null, null, null, 0, '', 'LDAP_DOMAIN_CHECK', 'true');

update security_configuration set matcher='/portal-service/v1/sso/token-validate' where matcher='/portal-service/v1/sso/token-validate/**';