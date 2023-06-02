drop database if exists BDMaquinaExpendedora;
create database BDMaquinaExpendedora;
use BDMaquinaExpendedora;

drop table if exists maquinas;
create table maquinas (
	idMaquina int not null auto_increment,
    numSerie varchar(60) not null,
    saldo decimal(5,2),
		constraint pk_id primary key (idMaquina)
);

drop table if exists productos;
create table productos (
	idProducto int not null auto_increment,
    nombre varchar(60) not null,
    precio decimal(3,2),
    stock int default 0,
    idMaquina int,
		constraint pk_id primary key (idProducto),
        constraint fk_productos_maquina foreign key (idMaquina) references maquinas(idMaquina)
			on delete cascade
);

drop table if exists ventas;
create table ventas (
	idVenta int not null auto_increment,
    idProducto int not null,
    fecha date,
    importe decimal (5,2),
    tipoPago enum('Efectivo', 'Tarjeta'),
		constraint pk_id primary key (idVenta),
        constraint fk_ventas_productos foreign key (idProducto) references productos(idProducto)
);

insert into maquinas
(idMaquina, numSerie, saldo)
values
(1000, '223-113-311',55.60),
(2000,'111-111-111',111.25),
(3000,'333-333-333',666.66);

insert into productos
(idProducto, nombre, precio, stock, idMaquina)
values
(1,'Agua Aquarel',0.60,25,1000),
(2,'Agua Bezoya',0.60,30,1000),
(3,'Cocacola',1.00,20,1000),
(4,'Cocacola zero',1.50,15,1000),
(5,'Nestea Limón',1.50,20,1000),
(6,'Nestea Maracuya',1.50,20,1000),
(7,'Monster Mango',1.80,10,1000),
(8,'Monster',1.60,10,1000),
(9,'Agua Aquarel',0.60,25,2000),
(10,'Agua Bezoya',0.60,30,2000),
(11,'Expreso',1.20,20,2000),
(12,'Capuccino',1.40,10,2000),
(13,'Kit-kat',1.50,30,2000),
(14,'Twix',1.00,40,2000),
(15,'Haribo ositos',2.50,20,3000),
(16,'Choco-bons',2.70,15,3000),
(17,'Galletas Oreo',2.50,25,3000),
(18,'Doritos',1.50,20,3000),
(19,'Lays Campesinas',1.50,15,3000),
(20,'Chocolate Milka',2.10,10,3000),
(21,'Chocolate Milka blanco',2.10,10,3000);

use BDMaquinaExpendedora;
select * from productos;