
drop table if exists product;
drop table if exists bank_user;

create table product (
	id bigserial,
	account text,
	balance float,
	type text
);

insert into product(account, balance, type)
values ('123', 40, 'счет'), ('123', 110, 'карта'), ('234', 0, 'счет');


create table bank_user (
	id bigserial,
	account text
);

insert into bank_user (account)
values ('123'), ('234'), ('678');
