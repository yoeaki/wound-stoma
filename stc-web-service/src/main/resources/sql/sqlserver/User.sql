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
