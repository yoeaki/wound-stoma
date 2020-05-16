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
