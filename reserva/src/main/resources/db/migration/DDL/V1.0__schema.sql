create table reserva (
 id int(11) not null auto_increment,
 nombre_persona varchar(100) not null,
 fecha_reserva varchar(20) not null,
 valor_alquiler int(3) not null,
 estado varchar(20) not null,
 primary key (id)
);