--start
drop table if exists admin_user;
create table admin_user (
	id bigint not null auto_increment ,
	username varchar(255) comment '登录账号',
	password varchar(255) comment '密码',
	primary key (id)
);
--end
