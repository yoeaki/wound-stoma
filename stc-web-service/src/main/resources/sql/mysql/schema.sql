--start
drop table if exists adm_admin;
create table adm_admin (
	id bigint not null auto_increment comment 'id',
	username varchar(20) comment '用户名',
	real_name varchar(30) comment '真实名字',
	password varchar(255) comment '密码',
	sex varchar(10) comment '性别',
	age varchar(20) comment '年龄',
	phone varchar(20) comment '电话',
	address varchar(20) comment '地址',
	role int comment '角色',
	primary key (id)
);
--end
--start
drop table if exists cas_case;
create table cas_case (
	id bigint not null auto_increment comment 'id',
	patient_id bigint comment '病人id',
	doctor_id bigint comment '医生id',
	see_time datetime comment '就诊时间',
	disase_id bigint comment '病因id',
	diagnosis varchar(255) comment '诊断',
	recommendation varchar(255) comment '建议',
	case_pic varchar(255) comment '病图',
	primary key (id)
);
--end
--start
drop table if exists dis_disease;
create table dis_disease (
	id bigint not null auto_increment comment '疾病id',
	disease_name varchar(20) comment '疾病名称',
	primary key (id)
);
--end
--start
drop table if exists doc_doctor;
create table doc_doctor (
	id bigint not null auto_increment comment 'id',
	username varchar(20) comment '用户名',
	real_name varchar(20) comment '真实姓名',
	password varchar(255) comment '密码',
	sex varchar(10) comment '性别',
	age varchar(20) comment '年龄',
	phone varchar(20) comment '电话',
	address varchar(20) comment '地址',
	role int comment '角色',
	primary key (id)
);
--end
--start
drop table if exists pat_patient;
create table pat_patient (
	id bigint not null auto_increment comment 'id',
	username varchar(20) comment '用户名',
	real_name varchar(20) comment '真实姓名',
	identity_number varchar(20) comment '身份证号',
	password varchar(255) comment '密码',
	sex varchar(10) comment '性别',
	age varchar(20) comment '年龄',
	phone varchar(20) comment '电话',
	address varchar(20) comment '地址',
	role int comment '角色',
	primary key (id)
);
--end
--start
drop table if exists pat_reservation;
create table pat_reservation (
	id bigint not null auto_increment comment 'id',
	patient_id bigint comment '用户id',
	doctor_id bigint comment '医生id',
	reservation_time datetime comment '预约时间',
	remarks varchar(255) comment '备注信息',
	schedule varchar(1) comment '预约进度',
	primary key (id)
);
--end
