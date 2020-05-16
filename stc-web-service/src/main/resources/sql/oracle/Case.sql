--start
drop table cas_case;
create table cas_case (
	id bigint not null,
	patient_id bigint,
	doctor_id bigint,
	see_time datetime,
	disase_id bigint,
	diagnosis varchar(255),
	recommendation varchar(255),
	case_pic varchar(255)
);
alter table cas_case add constraint cas_case_pk PRIMARY KEY(id);
drop sequence seq_cas_case_id;
create sequence seq_cas_case_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column cas_case.id is 'id';
comment on column cas_case.patient_id is '病人id';
comment on column cas_case.doctor_id is '医生id';
comment on column cas_case.see_time is '就诊时间';
comment on column cas_case.disase_id is '病因id';
comment on column cas_case.diagnosis is '诊断';
comment on column cas_case.recommendation is '建议';
comment on column cas_case.case_pic is '病图';
--end
