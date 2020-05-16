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
