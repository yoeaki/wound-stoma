--start
drop table if exists coach_view;
create table coach_view (
	id bigint not null auto_increment ,
	ann_id bigint comment '公告id',
	coach_id bigint comment '教练id',
	view varchar(1) comment '检查',
	primary key (id)
);
--end
