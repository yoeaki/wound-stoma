--start
drop table admin_announcement;
create table admin_announcement (
	id bigint not null,
	admin_id bigint,
	content varchar(255),
	ann_time datetime,
	name varchar(20)
);
alter table admin_announcement add constraint admin_announcement_pk PRIMARY KEY(id);
drop sequence seq_admin_announcement_id;
create sequence seq_admin_announcement_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column admin_announcement.id is 'id';
comment on column admin_announcement.admin_id is 'admin_id';
comment on column admin_announcement.content is '公告内容';
comment on column admin_announcement.ann_time is '发布时间';
comment on column admin_announcement.name is '发布人';
--end
