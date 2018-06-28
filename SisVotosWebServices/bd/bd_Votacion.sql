/*     drop database bd_votacion   */

create database bd_votacion;

use bd_votacion;

--Table---------------------------------

create table tipo_usuario(
	id int auto_increment,
    descripcion varchar(50),
    primary key(id)
);
create table persona(
    rut varchar(12) unique,
    nombre varchar(50),
    apellido varchar(50),
    direccion varchar(60),
    edad int,
    primary key(rut)
);
create table usuario(
    id int auto_increment,
    rut_Persona varchar(13) unique,
    fk_tipoUsuario int,
    contraseña varchar(50),
    foreign key (rut_Persona) references persona(rut),
    foreign key (fk_tipoUsuario) references tipo_usuario(id),
    primary key(id)   
);



create table partido(
	id int auto_increment,
    descripcion varchar(50),
    primary key(id)
);

create table candidato(
	id int auto_increment,
    rut varchar(12),
    nombre varchar(50),
    id_partido int,
    primary key(id),
    foreign key(id_partido) references partido(id)
);

create table voto(
    id int auto_increment,
    fecha_voto datetime,
    id_persona varchar(12),
    id_candidato int,
    foreign key(id_persona) references persona(rut),
    foreign key(id_candidato) references candidato(id),
    primary key(id)
);

-- Table ----------------------------------
-- Insert----------------------------------
insert into tipo_usuario value(null,'admin');
insert into tipo_usuario value(null,'Sufragante');

insert into persona value('11-1','Pedro','Ezpinoza','Granerino',20);
insert into persona value('11-2','Edu','Rubio','Sant Emili',21);
insert into persona value('11-3','Pato','Perez','Rancagua',29);
insert into persona value('11-4','Cristian','Estay','Rengo',29);
insert into persona value('11-5','miky','woodz','santa amelia queen of desire',23);

insert into usuario values(null, '11-1',1,md5('1234'));
insert into usuario values(null,'11-2',2,md5('1234'));
insert into usuario values(null,'11-3',2,md5('1234'));
insert into usuario values(null,'11-4',2,md5('1234')); -- Usuario persona
insert into usuario values(null,'11-5',2,md5('1234'));

insert into partido value(null,'Renovación Nacional');
insert into partido value(null,'Democracia Cristiana');

insert into candidato value(null,'8258963-4','Sebastian Piñera',1);
insert into candidato value(null,'8258963-4','Bachelett',2);

insert into voto value(null,now(),'11-5',1);
insert into voto value(null,now(),'11-4',1);
insert into voto value(null,now(),'11-3',1);
insert into voto value(null,now(),'11-2',2);
insert into voto value(null,now(),'11-1',2);

--Insert---------------------------------


--Select---------------------------------


select * from candidato;
select * from persona;
select * from partido;
select * from tipo_usuario;
select * from voto;
select * from usuario;
select * from tipo_usuario;


