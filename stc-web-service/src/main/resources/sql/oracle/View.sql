--start
drop table coach_view;
create table coach_view (
	id bigint not null,
	ann_id bigint,
	coach_id bigint,
	view varchar(1)
);
alter table coach_view add constraint coach_view_pk PRIMARY KEY(id);
drop sequence seq_coach_view_id;
create sequence seq_coach_view_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column coach_view.id is 'id';
comment on column coach_view.ann_id is '公告id';
comment on column coach_view.coach_id is '教练id';
comment on column coach_view.view is '检查';
--end
