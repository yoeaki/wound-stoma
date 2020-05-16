--start
drop table pat_patient;
create table pat_patient (
	id bigint not null,
	username varchar(20),
	real_name varchar(20),
	identity_number varchar(20),
	password varchar(255),
	sex varchar(10),
	age varchar(20),
	phone varchar(20),
	address varchar(20),
	role int
);
alter table pat_patient add constraint pat_patient_pk PRIMARY KEY(id);
drop sequence seq_pat_patient_id;
create sequence seq_pat_patient_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column pat_patient.id is 'id';
comment on column pat_patient.username is '用户名';
comment on column pat_patient.real_name is '真实姓名';
comment on column pat_patient.identity_number is '身份证号';
comment on column pat_patient.password is '密码';
comment on column pat_patient.sex is '性别';
comment on column pat_patient.age is '年龄';
comment on column pat_patient.phone is '电话';
comment on column pat_patient.address is '地址';
comment on column pat_patient.role is '角色';
--end
