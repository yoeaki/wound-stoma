--start
drop table admin_user;
create table admin_user (
	id bigint not null,
	username varchar(255),
	password varchar(255)
);
alter table admin_user add constraint admin_user_pk PRIMARY KEY(id);
drop sequence seq_admin_user_id;
create sequence seq_admin_user_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column admin_user.id is 'id';
comment on column admin_user.username is '登录账号';
comment on column admin_user.password is '密码';
--end
