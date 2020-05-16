--start
drop table if exists adm_admin;
create table adm_admin (
	id bigint not null auto_increment ,
	username varchar(20) comment '用户名',
	real_name varchar(30) comment '真实名字',
	password varchar(255) comment '密码',
	sex varchar(10) comment '性别',
	age varchar(20) comment '年龄',
	phone varchar(20) comment '电话',
	address varchar(20) comment '地址',
	role int comment '角色',
	primary key (id)
);
--end
