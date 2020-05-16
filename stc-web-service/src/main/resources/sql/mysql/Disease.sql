--start
drop table if exists dis_disease;
create table dis_disease (
	id bigint not null auto_increment comment '疾病id',
	disease_name varchar(20) comment '疾病名称',
	primary key (id)
);
--end
