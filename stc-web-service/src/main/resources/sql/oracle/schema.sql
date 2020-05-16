--start
drop table adm_admin;
create table adm_admin (
	id bigint not null,
	username varchar(20),
	real_name varchar(30),
	password varchar(255),
	sex varchar(10),
	age varchar(20),
	phone varchar(20),
	address varchar(20),
	role int
);
alter table adm_admin add constraint adm_admin_pk PRIMARY KEY(id);
drop sequence seq_adm_admin_id;
create sequence seq_adm_admin_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column adm_admin.id is 'id';
comment on column adm_admin.username is '用户名';
comment on column adm_admin.real_name is '真实名字';
comment on column adm_admin.password is '密码';
comment on column adm_admin.sex is '性别';
comment on column adm_admin.age is '年龄';
comment on column adm_admin.phone is '电话';
comment on column adm_admin.address is '地址';
comment on column adm_admin.role is '角色';
--end
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
--start
drop table coach_car;
create table coach_car (
	id bigint not null,
	name varchar(20),
	number varchar(30),
	coach_id bigint
);
alter table coach_car add constraint coach_car_pk PRIMARY KEY(id);
drop sequence seq_coach_car_id;
create sequence seq_coach_car_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column coach_car.id is 'id';
comment on column coach_car.name is 'name';
comment on column coach_car.number is 'number';
comment on column coach_car.coach_id is 'coach_id';
--end
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
--start
drop table coach_coach;
create table coach_coach (
	id bigint not null,
	username varchar(20),
	password varchar(255),
	sex varchar(1),
	phone varchar(20),
	email varchar(50),
	address varchar(20),
	school_id bigint,
	price varchar(20),
	role int
);
alter table coach_coach add constraint coach_coach_pk PRIMARY KEY(id);
drop sequence seq_coach_coach_id;
create sequence seq_coach_coach_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column coach_coach.id is 'id';
comment on column coach_coach.username is 'username';
comment on column coach_coach.password is 'password';
comment on column coach_coach.sex is 'sex';
comment on column coach_coach.phone is 'phone';
comment on column coach_coach.email is 'email';
comment on column coach_coach.address is 'address';
comment on column coach_coach.school_id is 'school_id';
comment on column coach_coach.price is 'price';
comment on column coach_coach.role is '角色';
--end
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
--start
drop table student_evaluation;
create table student_evaluation (
	id bigint not null,
	student_id bigint,
	coach_id bigint,
	eva_time datetime,
	eva_content varchar(255)
);
alter table student_evaluation add constraint student_evaluation_pk PRIMARY KEY(id);
drop sequence seq_student_evaluation_id;
create sequence seq_student_evaluation_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column student_evaluation.id is 'id';
comment on column student_evaluation.student_id is '学员id';
comment on column student_evaluation.coach_id is 'coach_id';
comment on column student_evaluation.eva_time is '评价时间';
comment on column student_evaluation.eva_content is '评价内容';
--end
--start
drop table menus_menus;
create table menus_menus (
	id int not null,
	name varchar(20),
	pid int,
	order int
);
alter table menus_menus add constraint menus_menus_pk PRIMARY KEY(id);
drop sequence seq_menus_menus_id;
create sequence seq_menus_menus_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column menus_menus.id is 'id';
comment on column menus_menus.name is 'name';
comment on column menus_menus.pid is 'pid';
comment on column menus_menus.order is 'order';
--end
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
--start
drop table pat_reservation;
create table pat_reservation (
	id bigint not null,
	patient_id bigint,
	doctor_id bigint,
	reservation_time datetime,
	remarks varchar(255),
	schedule varchar(1)
);
alter table pat_reservation add constraint pat_reservation_pk PRIMARY KEY(id);
drop sequence seq_pat_reservation_id;
create sequence seq_pat_reservation_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column pat_reservation.id is 'id';
comment on column pat_reservation.patient_id is '用户id';
comment on column pat_reservation.doctor_id is '医生id';
comment on column pat_reservation.reservation_time is '预约时间';
comment on column pat_reservation.remarks is '备注信息';
comment on column pat_reservation.schedule is '预约进度';
--end
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
--start
drop table admin_user;
create table admin_user (
	id bigint not null,
	username varchar(255),
	password varchar(255)
);
alter table admin_user add constraint admin_user_pk PRIMARY KEY(id);
drop sequence seq_admin_user_id;
create sequence seq_admin_user_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column admin_user.id is 'id';
comment on column admin_user.username is '登录账号';
comment on column admin_user.password is '密码';
--end
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
