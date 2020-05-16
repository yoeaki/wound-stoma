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
