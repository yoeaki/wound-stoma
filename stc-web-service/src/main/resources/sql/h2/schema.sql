--start
drop table if exists adm_admin;
create table adm_admin (
	id bigint not null auto_increment ,
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
drop table if exists admin_announcement;
create table admin_announcement (
	id bigint not null auto_increment ,
	admin_id bigint comment 'admin_id',
	content varchar(255) comment '公告内容',
	ann_time datetime comment '发布时间',
	name varchar(20) comment '发布人',
	primary key (id)
);
--end
--start
drop table if exists coach_car;
create table coach_car (
	id bigint not null auto_increment ,
	name varchar(20) comment 'name',
	number varchar(30) comment 'number',
	coach_id bigint comment 'coach_id',
	primary key (id)
);
--end
--start
drop table if exists cas_case;
create table cas_case (
	id bigint not null auto_increment ,
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
drop table if exists coach_coach;
create table coach_coach (
	id bigint not null auto_increment ,
	username varchar(20) comment 'username',
	password varchar(255) comment 'password',
	sex varchar(1) comment 'sex',
	phone varchar(20) comment 'phone',
	email varchar(50) comment 'email',
	address varchar(20) comment 'address',
	school_id bigint comment 'school_id',
	price varchar(20) comment 'price',
	role int comment '角色',
	primary key (id)
);
--end
--start
drop table if exists dis_disease;
create table dis_disease (
	id bigint not null auto_increment ,
	disease_name varchar(20) comment '疾病名称',
	primary key (id)
);
--end
--start
drop table if exists doc_doctor;
create table doc_doctor (
	id bigint not null auto_increment ,
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
drop table if exists student_evaluation;
create table student_evaluation (
	id bigint not null auto_increment ,
	student_id bigint comment '学员id',
	coach_id bigint comment 'coach_id',
	eva_time datetime comment '评价时间',
	eva_content varchar(255) comment '评价内容',
	primary key (id)
);
--end
--start
drop table if exists menus_menus;
create table menus_menus (
	id int not null auto_increment ,
	name varchar(20) comment 'name',
	pid int comment 'pid',
	order int comment 'order',
	primary key (id)
);
--end
--start
drop table if exists pat_patient;
create table pat_patient (
	id bigint not null auto_increment ,
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
drop table if exists product_price_monitoring;
create table product_price_monitoring (
	recid bigint not null auto_increment ,
	title varchar(30) comment '标题',
	classify_id bigint comment '分类id',
	primary key (recid)
);
--end
--start
drop table if exists pat_reservation;
create table pat_reservation (
	id bigint not null auto_increment ,
	patient_id bigint comment '用户id',
	doctor_id bigint comment '医生id',
	reservation_time datetime comment '预约时间',
	remarks varchar(255) comment '备注信息',
	schedule varchar(1) comment '预约进度',
	primary key (id)
);
--end
--start
drop table if exists student_student;
create table student_student (
	id bigint not null auto_increment ,
	username varchar(20) comment 'username',
	password varchar(255) comment 'password',
	sex varchar(1) comment 'sex',
	phone varchar(20) comment 'phone',
	email varchar(50) comment 'email',
	address varchar(20) comment 'address',
	coach_id bigint comment 'coach_id',
	role int comment '角色',
	primary key (id)
);
--end
--start
drop table if exists admin_user;
create table admin_user (
	id bigint not null auto_increment ,
	username varchar(255) comment '登录账号',
	password varchar(255) comment '密码',
	primary key (id)
);
--end
--start
drop table if exists admin_verify;
create table admin_verify (
	id bigint not null auto_increment ,
	coach_id bigint comment 'coach',
	registime datetime comment '注册时间',
	status varchar(1) comment 'status',
	primary key (id)
);
--end
--start
drop table if exists coach_view;
create table coach_view (
	id bigint not null auto_increment ,
	ann_id bigint comment '公告id',
	coach_id bigint comment '教练id',
	view varchar(1) comment '检查',
	primary key (id)
);
--end
