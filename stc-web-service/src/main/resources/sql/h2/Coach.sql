--start
drop table if exists coach_coach;
create table coach_coach (
	id bigint not null auto_increment ,
	username varchar(20) comment 'username',
	password varchar(255) comment 'password',
	sex varchar(1) comment 'sex',
	phone varchar(20) comment 'phone',
	email varchar(50) comment 'email',
	address varchar(20) comment 'address',
	school_id bigint comment 'school_id',
	price varchar(20) comment 'price',
	role int comment '角色',
	primary key (id)
);
--end
