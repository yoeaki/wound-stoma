--start
drop table if exists menus_menus;
create table menus_menus (
	id int not null auto_increment ,
	name varchar(20) comment 'name',
	pid int comment 'pid',
	order int comment 'order',
	primary key (id)
);
--end
