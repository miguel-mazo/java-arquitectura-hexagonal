create table reserva (
 id int(11) not null auto_increment,
 nombre_persona varchar(100) not null,
 fecha_reserva varchar(20) not null,
 valor_alquiler int(3) not null,
 primary key (id)
);

insert into reserva(id, nombre_persona, fecha_reserva, valor_alquiler) values(1,'primera reserva','01/01/1111', 100);
insert into reserva(id, nombre_persona, fecha_reserva, valor_alquiler) values(2,'segunda reserva','02/02/2222', 100);