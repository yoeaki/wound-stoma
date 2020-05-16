--start
drop table student_evaluation;
create table student_evaluation (
	id bigint not null,
	student_id bigint,
	coach_id bigint,
	eva_time datetime,
	eva_content varchar(255)
);
alter table student_evaluation add constraint student_evaluation_pk PRIMARY KEY(id);
drop sequence seq_student_evaluation_id;
create sequence seq_student_evaluation_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column student_evaluation.id is 'id';
comment on column student_evaluation.student_id is '学员id';
comment on column student_evaluation.coach_id is 'coach_id';
comment on column student_evaluation.eva_time is '评价时间';
comment on column student_evaluation.eva_content is '评价内容';
--end
