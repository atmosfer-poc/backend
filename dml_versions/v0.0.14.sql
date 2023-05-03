alter table account drop constraint idcouple_index;

create index if not exists idcouple_index on account (id_type, id_value);