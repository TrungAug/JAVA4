CREATE DATABASE HanKookData
GO

USE HanKookData
GO

CREATE TABLE Product(
	id nchar(20) Primary key,
	product_name nvarchar(50) null,
	product_desctiption nvarchar(200) null,
	product_img nvarchar(100) null
)
GO

CREATE TABLE Users(
	username nchar(20) Primary key,
	fullname nvarchar(50) null,
	email nvarchar(100) null,
	addressUs nvarchar(100) null,
	birthday date,
	isAdmin bit
)
GO

CREATE TABLE TyreType (
	id nchar(20) Primary key,
	tyre_name nvarchar(50) null,
)
GO

CREATE TABLE TyreDetail (
	id int identity(1,1) Primary key,
	comments nvarchar(50) null,
	idProd nchar(20) not null,
	idType nchar(20) not null
	foreign key (idType) references TyreType(id) on delete no action on update cascade,
	foreign key (idProd) references Product(id) on delete no action on update cascade
)
GO



CREATE TABLE ImageProduct (
	id int identity(1,1) Primary key,
	src_image nvarchar(200) null,
	idProd nchar(20) not null
	foreign key (idProd) references Product(id) on delete no action on update cascade
)
GO

CREATE TABLE Favorite (
	id int identity(1,1) Primary key,
	idUser nchar(20) not null,
	idProd nchar(20) not null,
	dateFavorite date null
	foreign key (idProd) references Product(id) on delete no action on update cascade,
	foreign key (idUser) references Users(username) on delete no action on update cascade
)
GO

CREATE TABLE Share (
	id int identity(1,1) Primary key,
	idUser nchar(20) not null,
	idProd nchar(20) not null,
	dateShare date null
	foreign key (idProd) references Product(id) on delete no action on update cascade,
	foreign key (idUser) references Users(username) on delete no action on update cascade
)
GO



INSERT INTO Product
(
	id, -- nchar(20) Primary key,
	product_name, -- nvarchar(50) null,
	product_desctiption, -- nvarchar(200) null,
	product_img -- nvarchar(100) null
)VALUES('SP01', 'iON evo AS SUV', 'EVolutionised to perform and last',''),
('SP02', 'iON evo AS', 'EVolutionised to perform and last',''),
('SP03', 'Ventus Prime4', 'Optimum driving control and a comfortable ride',''),
('SP04', 'Ventus S1 evo3', 'Performance tyre chosen by premium car makers',''),
('SP05', 'Kinergy eco2', 'The smart choice for all-around performance','')
GO

INSERT INTO Users(
	username,-- nchar(20) Primary key,
	fullname,-- nvarchar(50) null,
	email,-- nvarchar(100) null,
	addressUs,-- nvarchar(100) null,
	birthday,-- date,
	isAdmin-- bit
)VALUES('trung2894',N'Nguyễn Thành Trung','trung2894@gmail.com',N'An Giang','19990801',1),
('davidau123',N'David','davidau2894@gmail.com',N'Autrialia','20000622',0),
('thuy88',N'Nguyễn Thị Thùy','thuy8894@gmail.com',N'Cần Thơ','19880308',1),
('thomas1245',N'Thomas','thomas1122@gmail.com',N'UK','19940115',0),
('mannhi189',N'Trương Mẫn Nhi','mynhan889@gmail.com',N'Cần Thơ','19990808',0)
GO



INSERT INTO TyreType (
	id,-- nchar(20) Primary key,
	tyre_name-- nvarchar(50) null,
)VALUES ('TYPE01','Electric Vehicle'),
('TYPE02','Passenger Car'),
('TYPE03','SUV/4WD'),
('TYPE04','VAN/Light Truck'),
('TYPE05','Truck & Bus'),
('TYPE06','Competition Tyres'),
('TYPE07','All Season'),
('TYPE08','Summer')
GO


INSERT INTO TyreDetail (

	--id int identity(1,1) Primary key,
	comments,-- nvarchar(50) null,
	idProd,-- nchar(20) not null,
	idType-- nchar(20) not null
	--foreign key (idType) references TyreType(id) on delete no action on update cascade
	--foreign key (idProd) references Product(id) on delete no action on update cascade
) VALUES ('','SP01','TYPE01'),
('','SP02','TYPE02'),
('','SP03','TYPE03'),
('','SP03','TYPE04'),
('','SP01','TYPE05')
GO

INSERT INTO ImageProduct (
	--id int identity(1,1) Primary key,
	src_image,-- nvarchar(200) null,
	idProd-- nchar(20) not null
	--foreign key (idProd) references Product(id) on delete no action on update cascade
)VALUES ('','SP01'),
('','SP01'),
('','SP01'),
('','SP02'),
('','SP02'),
('','SP03'),
('','SP04'),
('','SP04'),
('','SP04')
GO

INSERT INTO Favorite (
	--id int identity(1,1) Primary key,
	idUser,-- nchar(20) not null,
	idProd,-- nchar(20) not null,
	dateFavorite -- date null
	--foreign key (idProd) references Product(id) on delete no action on update cascade,
	--foreign key (idUser) references Users(username) on delete no action on update cascade
)VALUES ('davidau123','SP01','20231117'),
('davidau123','SP03','20231114'),
('davidau123','SP02','20231116'),
('mannhi189','SP01','20231114'),
('thomas1245','SP04','20231115'),
('thomas1245','SP01','20231110')
GO


INSERT INTO Share (
	--id int identity(1,1) Primary key,
	idUser,-- nchar(20) not null,
	idProd,-- nchar(20) not null,
	dateShare --date null
	--foreign key (idProd) references Product(id) on delete no action on update cascade,
	--foreign key (idUser) references Users(username) on delete no action on update cascade
)VALUES ('davidau123','SP01','20231117'),
('mannhi189','SP03','20230722'),
('davidau123','SP02','20230809'),
('mannhi189','SP01','20230913'),
('davidau123','SP04','20230409'),
('thomas1245','SP01','20230211')
GO