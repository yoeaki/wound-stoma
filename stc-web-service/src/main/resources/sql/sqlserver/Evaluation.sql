--start
if exists (select 1
            from  sysobjects
           where  id = object_id('student_evaluation')
            and   type = 'U')
   drop table student_evaluation
go
create table student_evaluation (
	id bigint not null IDENTITY(1,1)  ,
	student_id   bigint ,
	coach_id   bigint ,
	eva_time   datetime ,
	eva_content   varchar(255) ,
	primary key (id)
);

-- Add comments to the columns
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'学员id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'student_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'coach_id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'coach_id';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'评价时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'eva_time';
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'评价内容' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'student_evaluation', @level2type=N'COLUMN',@level2name=N'eva_content';
--end
