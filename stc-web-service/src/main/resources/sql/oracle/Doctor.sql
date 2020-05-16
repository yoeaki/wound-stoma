--start
drop table doc_doctor;
create table doc_doctor (
	id bigint not null,
	username varchar(20),
	real_name varchar(20),
	password varchar(255),
	sex varchar(10),
	age varchar(20),
	phone varchar(20),
	address varchar(20),
	role int
);
alter table doc_doctor add constraint doc_doctor_pk PRIMARY KEY(id);
drop sequence seq_doc_doctor_id;
create sequence seq_doc_doctor_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column doc_doctor.id is 'id';
comment on column doc_doctor.username is '用户名';
comment on column doc_doctor.real_name is '真实姓名';
comment on column doc_doctor.password is '密码';
comment on column doc_doctor.sex is '性别';
comment on column doc_doctor.age is '年龄';
comment on column doc_doctor.phone is '电话';
comment on column doc_doctor.address is '地址';
comment on column doc_doctor.role is '角色';
--end
