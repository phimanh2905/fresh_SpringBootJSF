Create database less1;
use less1;

create table  TAC_GIA(
	ID int auto_increment primary key,
    NAME nvarchar(50) not null,
    PHONE varchar(20) not null
);
Insert into TAC_GIA(NAME,PHONE) values ('Xam thien','123456789');
create table SACH(
	ID int auto_increment primary key,
    NAME nvarchar(50) not null,
    AUTHOR_ID int not null,
    QUANTITY int not null,
    FOREIGN KEY (AUTHOR_ID) REFERENCES TAC_GIA(ID)
);

insert into SACH (NAME,AUTHOR_ID,QUANTITY) values ('Truyen tho Duong',1,51);
