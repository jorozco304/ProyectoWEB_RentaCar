/*Se crea la base de datos */
drop schema if exists rentacar;
drop user if exists usuario_rentacar;
CREATE SCHEMA rentacar ;

/*Se crea un usuario para la base de datos llamado "usuario_rentacar" y tiene la contraseña "Proyecto_Desarrollo."*/
create user 'usuario_rentacar'@'%' identified by 'Proyecto_Desarrollo.';

/*Se asignan los prvilegios sobr ela base de datos proyecto al usuario creado */
grant all privileges on rentacar.* to 'usuario_rentacar'@'%';
flush privileges;

/* Esta tabla contiene la categoría del modelo del carro*/
create table rentacar.categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/* Esta tabla contiene el modelo del carro*/
create table rentacar.modelo (
  id_modelo INT NOT NULL AUTO_INCREMENT,
  marca VARCHAR(30) NOT NULL,
  modelo VARCHAR(30) NOT NULL,
  color VARCHAR(30),
  anio VARCHAR(30),
  activo bool,
  PRIMARY KEY (id_modelo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/* Esta tabla contiene kas existencias de los carros para alquilar*/
create table rentacar.carro (
  id_carro INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  id_modelo INT NOT NULL,  
  detalle VARCHAR(1600) NOT NULL, 
  precio double,
  existencias int,  
  imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_carro),
  foreign key fk_carro_caregoria (id_categoria) references categoria(id_categoria),
  foreign key fk_carro_modelo (id_modelo) references modelo(id_modelo)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Esta tabla contiene a los usuarios creados en el sistema*/
CREATE TABLE rentacar.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(100) NULL,
  telefono VARCHAR(15) NULL,
  imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Esta tabla contiene las facturas creadas por cada alquiler de un carro*/
create table rentacar.factura (
  id_factura INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  fecha date,  
  total double,
  estado int,
  PRIMARY KEY (id_factura),
  foreign key fk_factura_usuario (id_usuario) references usuario(id_usuario)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Esta tabla contiene el alquiler del rentacar*/
create table rentacar.alquiler (
  id_alquiler INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  id_carro INT NOT NULL,
  precio double, 
  cantidad int,
  PRIMARY KEY (id_alquiler),
  foreign key fk_alquiler_factura (id_factura) references factura(id_factura),
  foreign key fk_alquiler_carro (id_carro) references carro(id_carro) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Esta tabla contiene el rol de usuario*/
create table rentacar.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Esta tabla contiene la membresias existentes para los clientes*/
create table rentacar.membresia (
  id_membresia INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_membresia),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Esta tabla contiene las sucursales del rentacar*/
create table rentacar.sucursal (
  id_sucursal INT NOT NULL AUTO_INCREMENT,
  ubicacion varchar(30),
  PRIMARY KEY (id_sucursal)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


/*Datos iniciales de las tablas */
INSERT INTO rentacar.usuario (id_usuario, username,password,nombre, apellidos, correo, telefono,imagen,activo) VALUES 
(1,'admin','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Admin', 'RentACar',    'adminrentacar@gmail.com',    '8897-5896', 'https://raymanpc.com/wiki/images/1/15/Admin.png',true),
(2,'usuario_prueba','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Usuario',  'RentACar', 'usuariorentacar@gmail.com', '2589-8897','https://i.pinimg.com/564x/57/ea/0b/57ea0b7cc7c6c8641ce18ff318aa7e2a.jpg',true),
(3,'empleado_prueba','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Empleado', 'RentACar', 'empleadorentacar@gmail.com', '8887-8936','https://i.pinimg.com/564x/84/f4/6e/84f46e37621065436ac7aca454e5b60f.jpg',true);

INSERT INTO rentacar.categoria (id_categoria,descripcion,imagen,activo) VALUES 
('1','Sedán', 'https://i.pinimg.com/564x/7f/c6/73/7fc673f1c275f2c669290083275413b4.jpg',   true), 
('2','4x4',  'https://i.pinimg.com/564x/cd/18/33/cd183313c5dbf9fbece6b018cf11e663.jpg',   true),
('3','Deportivo',  'https://i.pinimg.com/564x/97/28/50/972850144f6ac5cc068bf98685dd883b.jpg',   true),
('4','SUV','https://i.pinimg.com/564x/1b/9d/5e/1b9d5efa15e2e9c6d8a3a14d4e52d1e6.jpg',true);

INSERT INTO rentacar.modelo (id_modelo,marca,modelo,color,anio,activo) VALUES 
('1','Volkswagen', 'Jetta', 'Gris','2011', true), 
('2','Toyota', 'Cross', 'Negro','2022', true), 
('3','Ford', 'Mustang', 'Azul','2017', true),
('4','Nissan', 'Kicks', 'Naranja','2023', true), 
('5','Hyundai', 'Tucson', 'Gris','2015', true);

INSERT INTO rentacar.carro (id_carro,id_categoria,id_modelo,detalle,precio,existencias,imagen,activo) VALUES
(1,1,1,'Carro modelo 2011, de 4 puertas, manual, perfecto para paseos en la ciudad','75',3,'https://i.pinimg.com/564x/e2/46/d5/e246d56d0f06c4fffaad4b37e2e67439.jpg',true),
(2,2,2,'Este es un carro práctico para desplazarse por la ciudad, cómodo y ahorrativo','85',5,'https://i.pinimg.com/564x/9a/61/87/9a6187a060e8441dd7d48ede20af3d3e.jpg',true),
(3,2,4,'Carro ideal para paseos de montaña o playa','100',3,'https://i.pinimg.com/564x/d3/25/f6/d325f68728c170365208e5b7503d4cc4.jpg',true),
(4,3,3,'Carro deportivo especial para eventos','150',1,'https://i.pinimg.com/564x/48/96/29/48962902f5e7f0ab81bc8349cc09c3d0.jpg',true),
(5,4,5,'Carro pensado para atravesar grandes distancias con poco gasto en gasolina','70',2,'https://i.pinimg.com/564x/23/6d/86/236d86f679e71a1ef1f9604d3b551624.jpg',true);

INSERT INTO rentacar.factura (id_factura,id_usuario,fecha,total,estado) VALUES
(1,1,'2023-11-27',500,2),
(2,2,'2023-11-27',300,2),
(3,3,'2023-11-28',100,2),
(4,1,'2023-11-28',1000,1),
(5,2,'2023-11-29',600,1),
(6,3,'2023-11-30',500,1);

INSERT INTO rentacar.alquiler (id_alquiler,id_factura,id_carro,precio,cantidad) values
(1,1,1,500,1),
(2,2,2,300,1),
(3,3,5,100,1),
(4,4,3,1000,1),
(5,5,5,600,1),
(6,6,4,500,1);

insert into rentacar.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), 
 (2,'ROLE_EMPLEADO',1),
 (3,'ROLE_USER',1),
 (4,'ROLE_EMPLEADO',2), 
 (5,'ROLE_USER',2),
 (6,'ROLE_USER',3);
 
 insert into rentacar.membresia (id_membresia,nombre,id_usuario) values
 (1,'Oro',3), 
 (2,'Platino',2),
 (3,'Diamante',1);
 
 insert into rentacar.sucursal (id_sucursal,ubicacion) values
 (1,'Cartago'), 
 (2,'Alajuela'),
 (3,'San José');