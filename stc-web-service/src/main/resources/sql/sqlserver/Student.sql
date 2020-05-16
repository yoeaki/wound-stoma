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
