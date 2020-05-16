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
