--start
drop table admin_verify;
create table admin_verify (
	id bigint not null,
	coach_id bigint,
	registime datetime,
	status varchar(1)
);
alter table admin_verify add constraint admin_verify_pk PRIMARY KEY(id);
drop sequence seq_admin_verify_id;
create sequence seq_admin_verify_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column admin_verify.id is 'id';
comment on column admin_verify.coach_id is 'coach';
comment on column admin_verify.registime is '注册时间';
comment on column admin_verify.status is 'status';
--end
