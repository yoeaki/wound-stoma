--start
drop table dis_disease;
create table dis_disease (
	id bigint not null,
	disease_name varchar(20)
);
alter table dis_disease add constraint dis_disease_pk PRIMARY KEY(id);
drop sequence seq_dis_disease_id;
create sequence seq_dis_disease_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column dis_disease.id is '疾病id';
comment on column dis_disease.disease_name is '疾病名称';
--end
