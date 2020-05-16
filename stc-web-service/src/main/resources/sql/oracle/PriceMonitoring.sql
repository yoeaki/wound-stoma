--start
drop table product_price_monitoring;
create table product_price_monitoring (
	recid bigint not null,
	title varchar(30),
	classify_id bigint
);
alter table product_price_monitoring add constraint product_price_monitoring_pk PRIMARY KEY(recid);
drop sequence seq_product_price_monitoring_id;
create sequence seq_product_price_monitoring_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column product_price_monitoring.recid is 'id';
comment on column product_price_monitoring.title is '标题';
comment on column product_price_monitoring.classify_id is '分类id';
--end
