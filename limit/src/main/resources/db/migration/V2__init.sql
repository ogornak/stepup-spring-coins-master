
drop table if exists limit_setting;
drop table if exists user_limit;

create table limit_setting (
	id bigserial not null,
	value float not null
);

insert into limit_setting(value)
values (10000.00);

create table user_limit (
	id bigserial not null,
	user_id bigint not null,
	value float not null
);

insert into user_limit(user_id, value)
values (1, 10000.00), (2, 10000.00), (3, 10000.00), (4, 10000.00), (5, 10000.00);
