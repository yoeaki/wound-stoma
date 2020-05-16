--start
drop table if exists ep2_install_list;
create table ep2_install_list (
	id bigint not null auto_increment comment 'id',
	employee_no varchar(40) comment '员工号',
	first_login datetime comment '首次登录时间',
	app_name varchar(40) comment '应用',
	name varchar(60) comment '姓名',
	region varchar(60) comment '区域',
	branch varchar(60) comment '分厂',
	department varchar(60) comment '部门',
	type varchar(20) comment '员工类型',
	status varchar(20) comment '状态',
	sync_date datetime comment '同步时间',
	primary key (id)
);
--end
