--start
drop table if exists admin_verify;
create table admin_verify (
	id bigint not null auto_increment ,
	coach_id bigint comment 'coach',
	registime datetime comment '注册时间',
	status varchar(1) comment 'status',
	primary key (id)
);
--end
