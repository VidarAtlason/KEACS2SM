DROP DATABASE  sunshineresort;
CREATE DATABASE sunshineresort;
use sunshineresort;

Create table equipment(
id int primary key auto_increment,
name varchar(65) NOT NULL
)ENGINE=InnoDB;
create table cottagetype(
id int primary key auto_increment,
name varchar(65)NOT NULL,
beds int(11)NOT NULL,
price decimal(5,2)NOT NULL
)ENGINE=InnoDB;
create table equipment_cottagetype(
id int primary key auto_increment,
equipment_fk int(11)NOT NULL,
cottagetype_fk int(11)NOT NULL,
constraint equipcottage_equipment
foreign key (equipment_fk) references equipment(id),
constraint equipcottage_cottagetype
foreign key (cottagetype_fk) references cottagetype(id)
)ENGINE=InnoDB;
create table zip(
zipCode int(4) primary key,
city varchar(75)NOT NULL
)ENGINE=InnoDB;

create table country(
id int(4) primary key,
short_name varchar(100)NOT NULL,
long_name varchar(150)NOT NULL,
calling_code int(4)NOT NULL,
iso3 varchar(3)NOT NULL
)ENGINE=InnoDB;

create table privatecustomer(
id int primary key auto_increment,
fName varchar(85)NOT NULL,
lName varchar(85)NOT NULL,
email varchar(155)NOT NULL,
phoneNo int(11)NOT NULL,
street varchar(75)NOT NULL,
houseNumber varchar(5)NOT NULL,
zip_fk int(4) not null,
country_fk int(4) not null,
gender bit(1) NOT NULL,
birthdate date NOT NULL,
constraint _zip
foreign key (zip_fk) references zip(zipCode),
constraint _country
foreign key (country_fk) references country(id)
)ENGINE=InnoDB;

create table company(
id int primary key auto_increment,
cvr int(8)NOT NULL,
email varchar(155)NOT NULL,
name varchar(155)NOT NULL,
contactName varchar(155)NOT NULL,
phoneNo int(11)NOT NULL,
faxNo int(11),
street varchar(75)NOT NULL,
houseNumber varchar(5)NOT NULL,
zip_fk int(4)NOT NULL,
country_fk int(4)NOT NULL,
constraint company_zip
foreign key (zip_fk) references zip(zipCode),
constraint company_country
foreign key (country_fk) references country(id)
)ENGINE=InnoDB;

create table cottage(
id int primary key auto_increment,
name varchar(45)NOT NULL,
street varchar(100)NOT NULL,
houseNumber varchar(10)NOT NULL,
zip_fk int(4)NOT NULL,
cottagetype_fk int(11)NOT NULL,
constraint cottage_zip
foreign key(zip_fk) references zip(zipCode),
constraint cottage_cottagetype
foreign key (cottagetype_fk) references cottagetype(id)
)ENGINE=InnoDB;

create table reservation(
id int primary key auto_increment,
reserveDate datetime NOT NULL,
weekFrom int(2)NOT NULL,
weekTo int(2)NOT NULL,
yearFrom int(4)NOT NULL,
yearTo int(4)NOT NULL,
paid bit(1)NOT NULL,
price decimal(6,2)NOT NULL,
privatecustomer_fk int,
company_fk int,
cottage_fk int NOT NULL,
constraint reservation_
foreign key (privatecustomer_fk) references privatecustomer(id),
constraint reservation_company
foreign key (company_fk) references company(id),
constraint reservation_cottage
foreign key (cottage_fk) references cottage(id)
)ENGINE=InnoDB;

create table rate(
id int(11) primary key,
rate int(3)NOT NULL
)ENGINE=InnoDB;

CREATE TABLE users(
username varchar(60) primary key,
password varchar(126)NOT NULL
)ENGINE=InnoDB;
