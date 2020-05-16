--start
drop table if exists admin_announcement;
create table admin_announcement (
	id bigint not null auto_increment ,
	admin_id bigint comment 'admin_id',
	content varchar(255) comment '公告内容',
	ann_time datetime comment '发布时间',
	name varchar(20) comment '发布人',
	primary key (id)
);
--end
