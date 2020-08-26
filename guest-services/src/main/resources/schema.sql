create table Guest(
id bigint auto_increment primary key,
first_name varchar(64),
last_name varchar(64),
email_address varchar(64),
address varchar(64),
country varchar(32),
state varchar(12),
phone_number varchar(24)
);