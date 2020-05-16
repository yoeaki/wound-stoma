--start
if exists (select 1
            from  sysobjects
           where  id = object_id('cas_case')
            and   type = 'U')
   drop table cas_case
go
create table cas_case (
	id bigint not null IDENTITY(1,1)  ,
	patient_id   bigint ,
	doctor_id   bigint ,
	see_time   datetime ,
	disase_id   bigint ,
	diagnosis   varchar(255) ,
	recommendation   varchar(255) ,
	case_pic   varchar(255) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'病人id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'patient_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'医生id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'doctor_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'就诊时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'see_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'病因id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'disase_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'诊断' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'diagnosis';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'建议' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'recommendation';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'病图' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'cas_case', @level2type=N'COLUMN',@level2name=N'case_pic';
--end
