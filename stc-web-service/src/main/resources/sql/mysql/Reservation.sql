--start
drop table if exists pat_reservation;
create table pat_reservation (
	id bigint not null auto_increment comment 'id',
	patient_id bigint comment '用户id',
	doctor_id bigint comment '医生id',
	reservation_time datetime comment '预约时间',
	remarks varchar(255) comment '备注信息',
	schedule varchar(1) comment '预约进度',
	primary key (id)
);
--end
