--start
drop table if exists student_student;
create table student_student (
	id bigint not null auto_increment ,
	username varchar(20) comment 'username',
	password varchar(255) comment 'password',
	sex varchar(1) comment 'sex',
	phone varchar(20) comment 'phone',
	email varchar(50) comment 'email',
	address varchar(20) comment 'address',
	coach_id bigint comment 'coach_id',
	role int comment '角色',
	primary key (id)
);
--end
