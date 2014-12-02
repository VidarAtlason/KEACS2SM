DROP DATABASE  sunshineresort;
CREATE DATABASE sunshineresort;
use sunshineresort;

Create table equipment(
id int primary key auto_increment,
name varchar(65)
)ENGINE=InnoDB;
create table cottagetype(
id int primary key auto_increment,
name varchar(65),
beds int(11),
price decimal(5,2)
)ENGINE=InnoDB;
create table equipment_cottagetype(
id int primary key auto_increment,
equipment_id int(11),
cottagetype_id int(11),
constraint equipcottage_equipment
foreign key (equipment_id) references equipment(id),
constraint equipcottage_cottagetype
foreign key (cottagetype_id) references cottagetype(id)
)ENGINE=InnoDB;
create table zip(
zipCode int(4) primary key,
city varchar(75)
)ENGINE=InnoDB;

create table country(
id int(4) primary key,
short_name varchar(100),
long_name varchar(150),
calling_code int(4),
iso3 varchar(3)
)ENGINE=InnoDB;

create table customer(
id int primary key auto_increment,
fName varchar(85),
lName varchar(85),
email varchar(155),
phoneNo int(11),
address varchar(75),
addressNo varchar(5),
zip int(4) not null,
country int(4) not null,
gender bit(1),
birthdate date,
constraint customer_zip
foreign key (zip) references zip(zipCode),
constraint customer_country
foreign key (country) references country(id)
)ENGINE=InnoDB;


create table company(
id int primary key auto_increment,
cvr int(8),
email varchar(155),
name varchar(155),
contactName varchar(155),
phoneNo int(11),
faxNo int(11),
address varchar(75),
addressNo varchar(5),
zip int(4),
country int(4),
constraint company_zip
foreign key (zip) references zip(zipCode),
constraint company_country
foreign key (country) references country(id)
)ENGINE=InnoDB;

create table cottage(
id int primary key auto_increment,
name varchar(45),
address varchar(100),
addressNo varchar(10),
zip int(4),
cottagetype int(11),
constraint cottage_zip
foreign key(zip) references zip(zipCode),
constraint cottage_cottagetype
foreign key (cottagetype) references cottagetype(id)
)ENGINE=InnoDB;

create table reservation(
id int primary key auto_increment,
reserveDate datetime,
weekFrom int(2),
weekTo int(2),
yearFrom int(4),
yearTo int(4),
paid bit(1),
price decimal(6,2),
customer int,
company int,
cottage int,
constraint reservation_customer
foreign key (customer) references customer(id),
constraint reservation_company
foreign key (company) references company(id),
constraint reservation_cottage
foreign key (cottage) references cottage(id)
)ENGINE=InnoDB;

create table rate(
id int(11) primary key,
rate int(3)
)ENGINE=InnoDB;

