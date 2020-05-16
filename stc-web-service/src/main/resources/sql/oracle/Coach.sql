--start
drop table coach_coach;
create table coach_coach (
	id bigint not null,
	username varchar(20),
	password varchar(255),
	sex varchar(1),
	phone varchar(20),
	email varchar(50),
	address varchar(20),
	school_id bigint,
	price varchar(20),
	role int
);
alter table coach_coach add constraint coach_coach_pk PRIMARY KEY(id);
drop sequence seq_coach_coach_id;
create sequence seq_coach_coach_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
-- Add comments to the columns
comment on column coach_coach.id is 'id';
comment on column coach_coach.username is 'username';
comment on column coach_coach.password is 'password';
comment on column coach_coach.sex is 'sex';
comment on column coach_coach.phone is 'phone';
comment on column coach_coach.email is 'email';
comment on column coach_coach.address is 'address';
comment on column coach_coach.school_id is 'school_id';
comment on column coach_coach.price is 'price';
comment on column coach_coach.role is '角色';
--end
