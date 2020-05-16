--start
drop table if exists cas_case;
create table cas_case (
	id bigint not null auto_increment ,
	patient_id bigint comment '病人id',
	doctor_id bigint comment '医生id',
	see_time datetime comment '就诊时间',
	disase_id bigint comment '病因id',
	diagnosis varchar(255) comment '诊断',
	recommendation varchar(255) comment '建议',
	case_pic varchar(255) comment '病图',
	primary key (id)
);
--end
