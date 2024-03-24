
drop table if exists product;

create table product (
	id bigserial,
	account text,
	balance float,
	type text,
	user_id int8
);

insert into product(account, balance, type, user_id)
values ('123', 40, 'счет', 1), ('123', 110, 'карта', 1), ('234', 0, 'счет', 2);
