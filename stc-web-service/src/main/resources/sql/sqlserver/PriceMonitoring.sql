--start
if exists (select 1
            from  sysobjects
           where  id = object_id('product_price_monitoring')
            and   type = 'U')
   drop table product_price_monitoring
go
create table product_price_monitoring (
	recid bigint not null IDENTITY(1,1)  ,
	title   varchar(30) ,
	classify_id   bigint ,
	primary key (recid)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'product_price_monitoring', @level2type=N'COLUMN',@level2name=N'recid';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'标题' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'product_price_monitoring', @level2type=N'COLUMN',@level2name=N'title';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'分类id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'product_price_monitoring', @level2type=N'COLUMN',@level2name=N'classify_id';
--end
