--start
drop table pat_reservation;
create table pat_reservation (
	id bigint not null,
	patient_id bigint,
	doctor_id bigint,
	reservation_time datetime,
	remarks varchar(255),
	schedule varchar(1)
);
alter table pat_reservation add constraint pat_reservation_pk PRIMARY KEY(id);
drop sequence seq_pat_reservation_id;
create sequence seq_pat_reservation_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column pat_reservation.id is 'id';
comment on column pat_reservation.patient_id is '用户id';
comment on column pat_reservation.doctor_id is '医生id';
comment on column pat_reservation.reservation_time is '预约时间';
comment on column pat_reservation.remarks is '备注信息';
comment on column pat_reservation.schedule is '预约进度';
--end
