--start
drop table if exists coach_car;
create table coach_car (
	id bigint not null auto_increment ,
	name varchar(20) comment 'name',
	number varchar(30) comment 'number',
	coach_id bigint comment 'coach_id',
	primary key (id)
);
--end
