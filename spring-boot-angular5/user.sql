create database testanglar5;
use testanglar5;

create table user(
	Id int auto_increment primary key,
    FirstName varchar(50) not null,
    LastName varchar(50) not null,
    Email varchar(50) not null
);
insert into user(FirstName,LastName,Email) values ('Xam','Thien','huyxxx@gmail.com'),('huy','huy','huyxxx@gmail.com');