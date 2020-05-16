--start
if exists (select 1
            from  sysobjects
           where  id = object_id('adm_admin')
            and   type = 'U')
   drop table adm_admin
go
create table adm_admin (
	id bigint not null IDENTITY(1,1)  ,
	username   varchar(20) ,
	real_name   varchar(30) ,
	password   varchar(255) ,
	sex   varchar(10) ,
	age   varchar(20) ,
	phone   varchar(20) ,
	address   varchar(20) ,
	role   int ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'username';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'真实名字' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'real_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'密码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'password';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'性别' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'sex';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'年龄' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'age';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'phone';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'address';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'adm_admin', @level2type=N'COLUMN',@level2name=N'role';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('admin_announcement')
            and   type = 'U')
   drop table admin_announcement
go
create table admin_announcement (
	id bigint not null IDENTITY(1,1)  ,
	admin_id   bigint ,
	content   varchar(255) ,
	ann_time   datetime ,
	name   varchar(20) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_announcement', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'admin_id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_announcement', @level2type=N'COLUMN',@level2name=N'admin_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'公告内容' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_announcement', @level2type=N'COLUMN',@level2name=N'content';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'发布时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_announcement', @level2type=N'COLUMN',@level2name=N'ann_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'发布人' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_announcement', @level2type=N'COLUMN',@level2name=N'name';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('coach_car')
            and   type = 'U')
   drop table coach_car
go
create table coach_car (
	id bigint not null IDENTITY(1,1)  ,
	name   varchar(20) ,
	number   varchar(30) ,
	coach_id   bigint ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_car', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'name' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_car', @level2type=N'COLUMN',@level2name=N'name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'number' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_car', @level2type=N'COLUMN',@level2name=N'number';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'coach_id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_car', @level2type=N'COLUMN',@level2name=N'coach_id';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('cas_case')
            and   type = 'U')
   drop table cas_case
go
create table cas_case (
	id bigint not null IDENTITY(1,1)  ,
	patient_id   bigint ,
	doctor_id   bigint ,
	see_time   datetime ,
	disase_id   bigint ,
	diagnosis   varchar(255) ,
	recommendation   varchar(255) ,
	case_pic   varchar(255) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'病人id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'patient_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'医生id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'doctor_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'就诊时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'see_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'病因id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'disase_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'诊断' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'diagnosis';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'建议' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'recommendation';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'病图' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'case_pic';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('coach_coach')
            and   type = 'U')
   drop table coach_coach
go
create table coach_coach (
	id bigint not null IDENTITY(1,1)  ,
	username   varchar(20) ,
	password   varchar(255) ,
	sex   varchar(1) ,
	phone   varchar(20) ,
	email   varchar(50) ,
	address   varchar(20) ,
	school_id   bigint ,
	price   varchar(20) ,
	role   int ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'username' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'username';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'password' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'password';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'sex' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'sex';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'phone' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'phone';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'email' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'email';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'address' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'address';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'school_id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'school_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'price' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'price';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_coach', @level2type=N'COLUMN',@level2name=N'role';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('dis_disease')
            and   type = 'U')
   drop table dis_disease
go
create table dis_disease (
	id bigint not null IDENTITY(1,1)  ,
	disease_name   varchar(20) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'疾病id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'dis_disease', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'疾病名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'dis_disease', @level2type=N'COLUMN',@level2name=N'disease_name';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('doc_doctor')
            and   type = 'U')
   drop table doc_doctor
go
create table doc_doctor (
	id bigint not null IDENTITY(1,1)  ,
	username   varchar(20) ,
	real_name   varchar(20) ,
	password   varchar(255) ,
	sex   varchar(10) ,
	age   varchar(20) ,
	phone   varchar(20) ,
	address   varchar(20) ,
	role   int ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'username';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'真实姓名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'real_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'密码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'password';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'性别' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'sex';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'年龄' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'age';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'phone';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'address';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'doc_doctor', @level2type=N'COLUMN',@level2name=N'role';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('student_evaluation')
            and   type = 'U')
   drop table student_evaluation
go
create table student_evaluation (
	id bigint not null IDENTITY(1,1)  ,
	student_id   bigint ,
	coach_id   bigint ,
	eva_time   datetime ,
	eva_content   varchar(255) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'学员id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'student_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'coach_id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'coach_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'评价时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'eva_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'评价内容' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'eva_content';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('menus_menus')
            and   type = 'U')
   drop table menus_menus
go
create table menus_menus (
	id int not null IDENTITY(1,1)  ,
	name   varchar(20) ,
	pid   int ,
	order   int ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'menus_menus', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'name' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'menus_menus', @level2type=N'COLUMN',@level2name=N'name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'pid' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'menus_menus', @level2type=N'COLUMN',@level2name=N'pid';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'order' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'menus_menus', @level2type=N'COLUMN',@level2name=N'order';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('pat_patient')
            and   type = 'U')
   drop table pat_patient
go
create table pat_patient (
	id bigint not null IDENTITY(1,1)  ,
	username   varchar(20) ,
	real_name   varchar(20) ,
	identity_number   varchar(20) ,
	password   varchar(255) ,
	sex   varchar(10) ,
	age   varchar(20) ,
	phone   varchar(20) ,
	address   varchar(20) ,
	role   int ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'username';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'真实姓名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'real_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'身份证号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'identity_number';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'密码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'password';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'性别' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'sex';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'年龄' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'age';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'phone';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'address';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_patient', @level2type=N'COLUMN',@level2name=N'role';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('product_price_monitoring')
            and   type = 'U')
   drop table product_price_monitoring
go
create table product_price_monitoring (
	recid bigint not null IDENTITY(1,1)  ,
	title   varchar(30) ,
	classify_id   bigint ,
	primary key (recid)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'product_price_monitoring', @level2type=N'COLUMN',@level2name=N'recid';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'标题' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'product_price_monitoring', @level2type=N'COLUMN',@level2name=N'title';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'分类id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'product_price_monitoring', @level2type=N'COLUMN',@level2name=N'classify_id';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('pat_reservation')
            and   type = 'U')
   drop table pat_reservation
go
create table pat_reservation (
	id bigint not null IDENTITY(1,1)  ,
	patient_id   bigint ,
	doctor_id   bigint ,
	reservation_time   datetime ,
	remarks   varchar(255) ,
	schedule   varchar(1) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'patient_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'医生id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'doctor_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'预约时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'reservation_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注信息' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'remarks';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'预约进度' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'schedule';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('student_student')
            and   type = 'U')
   drop table student_student
go
create table student_student (
	id bigint not null IDENTITY(1,1)  ,
	username   varchar(20) ,
	password   varchar(255) ,
	sex   varchar(1) ,
	phone   varchar(20) ,
	email   varchar(50) ,
	address   varchar(20) ,
	coach_id   bigint ,
	role   int ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'username' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'username';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'password' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'password';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'sex' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'sex';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'phone' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'phone';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'email' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'email';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'address' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'address';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'coach_id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'coach_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_student', @level2type=N'COLUMN',@level2name=N'role';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('admin_user')
            and   type = 'U')
   drop table admin_user
go
create table admin_user (
	id bigint not null IDENTITY(1,1)  ,
	username   varchar(255) ,
	password   varchar(255) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_user', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'登录账号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_user', @level2type=N'COLUMN',@level2name=N'username';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'密码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_user', @level2type=N'COLUMN',@level2name=N'password';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('admin_verify')
            and   type = 'U')
   drop table admin_verify
go
create table admin_verify (
	id bigint not null IDENTITY(1,1)  ,
	coach_id   bigint ,
	registime   datetime ,
	status   varchar(1) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_verify', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'coach' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_verify', @level2type=N'COLUMN',@level2name=N'coach_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'注册时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_verify', @level2type=N'COLUMN',@level2name=N'registime';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'status' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'admin_verify', @level2type=N'COLUMN',@level2name=N'status';
--end
--start
if exists (select 1
            from  sysobjects
           where  id = object_id('coach_view')
            and   type = 'U')
   drop table coach_view
go
create table coach_view (
	id bigint not null IDENTITY(1,1)  ,
	ann_id   bigint ,
	coach_id   bigint ,
	view   varchar(1) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_view', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'公告id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_view', @level2type=N'COLUMN',@level2name=N'ann_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'教练id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_view', @level2type=N'COLUMN',@level2name=N'coach_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'检查' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'coach_view', @level2type=N'COLUMN',@level2name=N'view';
--end
