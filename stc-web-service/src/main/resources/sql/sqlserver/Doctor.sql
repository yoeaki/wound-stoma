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
