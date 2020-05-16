--start
drop table adm_admin;
create table adm_admin (
	id bigint not null,
	username varchar(20),
	real_name varchar(30),
	password varchar(255),
	sex varchar(10),
	age varchar(20),
	phone varchar(20),
	address varchar(20),
	role int
);
alter table adm_admin add constraint adm_admin_pk PRIMARY KEY(id);
drop sequence seq_adm_admin_id;
create sequence seq_adm_admin_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column adm_admin.id is 'id';
comment on column adm_admin.username is '用户名';
comment on column adm_admin.real_name is '真实名字';
comment on column adm_admin.password is '密码';
comment on column adm_admin.sex is '性别';
comment on column adm_admin.age is '年龄';
comment on column adm_admin.phone is '电话';
comment on column adm_admin.address is '地址';
comment on column adm_admin.role is '角色';
--end
