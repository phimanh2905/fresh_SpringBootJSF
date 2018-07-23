DROP DATABASE IF EXISTS ebflight;
Create database ebflight;
use ebflight;

create table AIRLINE(
	AID int auto_increment primary key,
    A_NAME NVARCHAR(50) not null,
    A_NOTE NVARCHAR(255)  null
);
INSERT INTO AIRLINE(A_NAME,A_NOTE) VALUES ('VNAIRLINE',''),('VIETJET','');

create table FLIGHT_SCHEDULES(
	FID int auto_increment primary key,
    F_FROM VARCHAR(100) NOT NULL,
    F_TO   VARCHAR(100) NOT NULL,
	ARRIVAL_TIME int NOT NULL,
    DEPARTURE_TIME DATETIME NOT NULL,
    ORTHER_DETAILS NVARCHAR(255) NULL,
    AIRLINE_CODE INT NOT NULL,
    FOREIGN KEY (AIRLINE_CODE) REFERENCES AIRLINE(AID)
);
INSERT INTO FLIGHT_SCHEDULES(F_FROM,F_TO,ARRIVAL_TIME,DEPARTURE_TIME,ORTHER_DETAILS,AIRLINE_CODE) values
	('Hà nội','Trung Quốc',90,'2018/07/12 15:00:00','',1),
    ('Hà nội','HCM',200,'2018/07/12 10:00:00','',2);
CREATE TABLE CUSTOMER(
	CID int auto_increment primary key,
    C_NAME NVARCHAR(50) not null,
    PHONE VARCHAR(15) not null,
    EMAIL VARCHAR(100) null
);
insert into CUSTOMER(C_NAME,PHONE) values ('Xam thien','0123456789'),('Xam Link','0987654321');
CREATE TABLE PAYMNET_METHOD(
	PID int auto_increment primary key,
    P_NAME NVARCHAR(50) not null
);
insert into PAYMNET_METHOD(P_NAME) values ('Paypal'),('Payoner'),('Visa master Card');
CREATE TABLE RESERVATION_STATUS(
	RSID int auto_increment primary key,
    RS_NAME VARCHAR(50) not null
);
insert into RESERVATION_STATUS(RS_NAME) values ('Đã thanh toán'),('Chưa thanh toán');
 CREATE TABLE RESERVATION(
	RID int auto_increment primary key,
    CID INT NOT NULL,
    DATE_OF_RESERVATION DATETIME NOT NULL,
    FID int NOT NULL,
    PID int NOT NULL,
    RSID int NOT NULL,
    FOREIGN KEY (CID) REFERENCES CUSTOMER(CID),
    FOREIGN KEY (FID) REFERENCES FLIGHT_SCHEDULES(FID),
    FOREIGN KEY (PID) REFERENCES PAYMNET_METHOD(PID),
    FOREIGN KEY (RSID) REFERENCES RESERVATION_STATUS(RSID)
 );
 
 insert into RESERVATION(CID,DATE_OF_RESERVATION,FID,PID,RSID) values 
	(1,'2018/07/10 15:00:00',1,2,1),
    (2,'2018/07/09 10:00:00',2,1,2);
    
    
    
    
    
    
    
    