--start
if exists (select 1
            from  sysobjects
           where  id = object_id('pat_reservation')
            and   type = 'U')
   drop table pat_reservation
go
create table pat_reservation (
	id bigint not null IDENTITY(1,1)  ,
	patient_id   bigint ,
	doctor_id   bigint ,
	reservation_time   datetime ,
	remarks   varchar(255) ,
	schedule   varchar(1) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'patient_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'医生id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'doctor_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'预约时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'reservation_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注信息' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'remarks';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'预约进度' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'pat_reservation', @level2type=N'COLUMN',@level2name=N'schedule';
--end
