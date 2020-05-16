--start
if exists (select 1
            from  sysobjects
           where  id = object_id('ep2_install_list')
            and   type = 'U')
   drop table ep2_install_list
go
create table ep2_install_list (
	id bigint not null IDENTITY(1,1)  ,
	employee_no   varchar(40) ,
	first_login   datetime ,
	app_name   varchar(40) ,
	name   varchar(60) ,
	region   varchar(60) ,
	branch   varchar(60) ,
	department   varchar(60) ,
	type   varchar(20) ,
	status   varchar(20) ,
	sync_date   datetime ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'employee_no';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'首次登录时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'first_login';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'应用' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'app_name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'姓名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'name';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'区域' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'region';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'分厂' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'branch';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'department';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工类型' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'type';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'状态' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'status';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'同步时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ep2_install_list', @level2type=N'COLUMN',@level2name=N'sync_date';
--end
