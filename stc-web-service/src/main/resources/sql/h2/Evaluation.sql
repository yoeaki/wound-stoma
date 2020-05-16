--start
drop table if exists student_evaluation;
create table student_evaluation (
	id bigint not null auto_increment ,
	student_id bigint comment '学员id',
	coach_id bigint comment 'coach_id',
	eva_time datetime comment '评价时间',
	eva_content varchar(255) comment '评价内容',
	primary key (id)
);
--end
