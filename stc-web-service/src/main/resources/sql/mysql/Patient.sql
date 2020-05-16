--start
drop table if exists pat_patient;
create table pat_patient (
	id bigint not null auto_increment comment 'id',
	username varchar(20) comment '用户名',
	real_name varchar(20) comment '真实姓名',
	identity_number varchar(20) comment '身份证号',
	password varchar(255) comment '密码',
	sex varchar(10) comment '性别',
	age varchar(20) comment '年龄',
	phone varchar(20) comment '电话',
	address varchar(20) comment '地址',
	role int comment '角色',
	primary key (id)
);
--end
