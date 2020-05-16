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
