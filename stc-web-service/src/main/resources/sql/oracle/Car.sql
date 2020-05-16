--start
drop table coach_car;
create table coach_car (
	id bigint not null,
	name varchar(20),
	number varchar(30),
	coach_id bigint
);
alter table coach_car add constraint coach_car_pk PRIMARY KEY(id);
drop sequence seq_coach_car_id;
create sequence seq_coach_car_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column coach_car.id is 'id';
comment on column coach_car.name is 'name';
comment on column coach_car.number is 'number';
comment on column coach_car.coach_id is 'coach_id';
--end
