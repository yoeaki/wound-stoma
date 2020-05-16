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
