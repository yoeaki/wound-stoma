--start
drop table student_student;
create table student_student (
	id bigint not null,
	username varchar(20),
	password varchar(255),
	sex varchar(1),
	phone varchar(20),
	email varchar(50),
	address varchar(20),
	coach_id bigint,
	role int
);
alter table student_student add constraint student_student_pk PRIMARY KEY(id);
drop sequence seq_student_student_id;
create sequence seq_student_student_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column student_student.id is 'id';
comment on column student_student.username is 'username';
comment on column student_student.password is 'password';
comment on column student_student.sex is 'sex';
comment on column student_student.phone is 'phone';
comment on column student_student.email is 'email';
comment on column student_student.address is 'address';
comment on column student_student.coach_id is 'coach_id';
comment on column student_student.role is '角色';
--end
