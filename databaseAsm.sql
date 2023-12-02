
Use Hankook2
Go

Insert into userss
(
admin,
birthDay,
email,
fullName,
idUs,
passWord
)
values
(1,'2000-09-01','trung2894@gmail.com','Nguyen Thanh Trung','admin','123'),
(0,'2002-09-09','trungntpc05132@fpt.edu.vn','Do Tan Tai','kh123','123')
GO

Insert into tyres
(
idTyre,
nameTyre
)
values('T01','Electric Vehicle'),
('T02','Passenger Car'),
('T03','SUV/4WD'),
('T04','VAN/Light Truck'),
('T05','Truck & Bus'),
('T06','Truck & Bus'),
('T07','Competition Tyres'),
('T08','Summer')
GO

Insert into products
(
active,
buys,
description,
idPro,
prodName
)
values
(1,0,'EVolutionised to perform and last','SP01','iON evo AS SUV'),
(1,0,'EVolutionised to perform and last','SP02','iON evo AS'),
(1,0,'Optimum driving control and a comfortable ride','SP03','ventus Prime4'),
(1,0,'Performance tyre chosen by premium car makers','SP04','ventus S1 evo3')
GO

Insert into RelProductTyre
(
dateLog,
id_prods,
id_tyre
)
values
('2023-12-02','SP01','T01'),
('2023-12-02','SP02','T01'),
('2023-12-02','SP02','T02'),
('2023-12-02','SP03','T02'),
('2023-12-02','SP04','T02')
GO
select * from tyres
select * from products
select * from RelProductTyre