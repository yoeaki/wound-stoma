--start
drop table if exists product_price_monitoring;
create table product_price_monitoring (
	recid bigint not null auto_increment ,
	title varchar(30) comment '标题',
	classify_id bigint comment '分类id',
	primary key (recid)
);
--end
