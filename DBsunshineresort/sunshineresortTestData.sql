USE sunshineresort;
insert into zip(zipCode,city) values (2400,"Norrebro"),(2450,"Copenhagen SV"),(3520,"Farum");
insert into country(id,short_name,long_name,calling_code,iso3) values (61,'Denmark', 'Kingdom of Denmark',45,'DNK');
insert into rate(id,rate) values (1,100),(2,100),(3,100),(4,100);
insert into cottagetype(name,beds,price) values ("Standard 4",4,1200),("Luxury 4",4,1800),("Standard 8",8,2000);
insert into equipment(name) values ("Microwave"),("Hot tub"),("Sauna");
insert into equipment_cottagetype(equipment_id,cottagetype_id) values (1,1),(1,2),(1,3),(2,2),(3,2);
insert into cottage(name,address,addressNo,zip,cottagetype) values ("Wonderbridge","Main street","12",2400,1),
("Strongbush","Franklin street","19",2450,2),("Birdsnest","Gammel Kongevej","2",2400,2);
insert into company (id,cvr,email,name,contactName,phoneNo,faxNo,address,addressNo,zip,country)
values (1,"10121519","contact@Farumgraphics.dk","Farum Graphics","Kate",50909080,50909081,"Kjærbovænge",8,3520,61);
insert into customer values 
(2,"Leonard","Euler","BobEuler@gmail.com",80707091,"Hope street","19",2400,61,0,"1977-10-29");
insert into reservation values
(1,"2014-11-20",1,3,2014,2014,1,1200,2,null,1),
(2,"2014-11-21",1,2,2014,2014,0,1800,2,null,2),
(3,"2014-11-21",1,4,2014,2014,0,7200,null,1,3);