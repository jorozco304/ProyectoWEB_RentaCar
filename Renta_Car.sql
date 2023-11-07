create schema renta_car;
create
user 'usuario'@'%' identified by '123456';

grant all privileges on renta_car.* to
'usuario'@'%';
flush
privileges;

USE
renta_car;

CREATE TABLE categoria
(
    categoria_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre       VARCHAR(255)
);
CREATE TABLE usuario
(
    usuario_id       INT PRIMARY KEY,
    nombre           VARCHAR(100),
    correo           VARCHAR(50) UNIQUE,
    contrasenha      VARCHAR(50),
    fecha_nacimiento DATE,
    direccion        VARCHAR(150),
    telefono         VARCHAR(10),
    ciudad           VARCHAR(50),
    pais             VARCHAR(50),
    foto_perfil      VARCHAR(1080),
    tipo_licencia    VARCHAR(2)
);

CREATE TABLE socio
(
    socio_id         INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id       INT,
    fecha_afiliacion DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id)
);

CREATE TABLE auto
(
    auto_id   INT AUTO_INCREMENT PRIMARY KEY,
    marca         VARCHAR(50) NOT NULL,
    modelo        VARCHAR(50) NOT NULL,
    tipo_vehiculo VARCHAR(50) NOT NULL,
    disponible    BOOLEAN,
    anio          INT         NOT NULL,
    placa         VARCHAR(50) NOT NULL,
    trasmicion    VARCHAR(50) NOT NULL,
    ruta_imagen   VARCHAR(1080),
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(categoria_id)
);

CREATE TABLE reserva
(
    reserva_id                  INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id          INT,
    auto_id         INT,
    fecha_reservaInicio DATE NOT NULL,
    fecha_reservaFinal  DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id),
    FOREIGN KEY (auto_id) REFERENCES auto (auto_id)
);

CREATE TABLE ubicacion_oficina
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    nombre    VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    url VARCHAR(1080) NOT NULL
);

CREATE TABLE contenido_soporte
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    titulo      VARCHAR(255) NOT NULL,
    descripcion TEXT
);