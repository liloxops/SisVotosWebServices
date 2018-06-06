/*drop database bd_votacion;*/

create database bd_votacion;

use bd_votacion;

create table tipo_usuario(
	id int auto_increment,
    descripcion varchar(50),
    primary key(id)
);

insert into tipo_usuario value(null,'admin');
insert into tipo_usuario value(null,'votante');

create table persona(
	rut varchar(12),
    nombre varchar(50),
    apellido varchar(50),
    direccion varchar(60),
    edad int,
    id_usuario int,
    primary key(rut),
    foreign key(id_usuario) references tipo_usuario(id)
);

insert into persona value('18256365-7','miky','woodz','santa amelia queen of desire',24,2);

create table partido(
	id int auto_increment,
    descripcion varchar(50),
    primary key(id)
);

insert into partido value(null,'Renovación Nacional');

create table candidato(
	id int auto_increment,
    rut varchar(12),
    nombre varchar(50),
    id_partido int,
    primary key(id),
    foreign key(id_partido) references partido(id)
);

insert into candidato value(null,'8258963-4','Sebastian Piñera',1);

create table voto(
	id int auto_increment,
    fecha_voto datetime,
    id_persona varchar(12),
    id_candidato int,
    primary key(id),
    foreign key(id_persona) references persona(rut),
    foreign key(id_candidato) references candidato(id)
);

insert into voto value(null,now(),'18256365-7',1);