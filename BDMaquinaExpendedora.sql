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