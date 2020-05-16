--start
drop table ep2_install_list;
create table ep2_install_list (
	id bigint not null,
	employee_no varchar(40),
	first_login datetime,
	app_name varchar(40),
	name varchar(60),
	region varchar(60),
	branch varchar(60),
	department varchar(60),
	type varchar(20),
	status varchar(20),
	sync_date datetime
);
alter table ep2_install_list add constraint ep2_install_list_pk PRIMARY KEY(id);
drop sequence seq_ep2_install_list_id;
create sequence seq_ep2_install_list_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column ep2_install_list.id is 'id';
comment on column ep2_install_list.employee_no is '员工号';
comment on column ep2_install_list.first_login is '首次登录时间';
comment on column ep2_install_list.app_name is '应用';
comment on column ep2_install_list.name is '姓名';
comment on column ep2_install_list.region is '区域';
comment on column ep2_install_list.branch is '分厂';
comment on column ep2_install_list.department is '部门';
comment on column ep2_install_list.type is '员工类型';
comment on column ep2_install_list.status is '状态';
comment on column ep2_install_list.sync_date is '同步时间';
--end
