--start
drop table menus_menus;
create table menus_menus (
	id int not null,
	name varchar(20),
	pid int,
	order int
);
alter table menus_menus add constraint menus_menus_pk PRIMARY KEY(id);
drop sequence seq_menus_menus_id;
create sequence seq_menus_menus_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column menus_menus.id is 'id';
comment on column menus_menus.name is 'name';
comment on column menus_menus.pid is 'pid';
comment on column menus_menus.order is 'order';
--end
