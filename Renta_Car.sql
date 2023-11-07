create schema renta_car;
create user 'usuario'@'%' identified by '123456';

grant all privileges on renta_car.* to 'usuario'@'%';
flush privileges;

USE renta_car;

CREATE TABLE usuarios (
    usuario_id INT PRIMARY KEY,
    nombre VARCHAR(50),
    correo VARCHAR(50) UNIQUE,
    contrasenha VARCHAR(50),
    fecha_nacimiento DATE,
    direccion VARCHAR(50),
    telefono VARCHAR(50),
    ciudad VARCHAR(50),
    pais VARCHAR(50),
    foto_perfil VARCHAR(50),
    tipo_licencia VARCHAR(50)
);

CREATE TABLE Socio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    fecha_afiliacion DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

CREATE TABLE Vehiculo (
    vehiculo_id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    tipo_vehiculo VARCHAR(50) NOT NULL,
    disponible BOOLEAN,
    anio INT NOT NULL,
    placa VARCHAR(50) NOT NULL,
    trasmicion VARCHAR(50) NOT NULL,
    ruta_imagen VARCHAR(255)
);

CREATE TABLE Reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    vehiculo_id INT,
    fecha_reservaInicio DATE NOT NULL,
    fecha_reservaFinal DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (vehiculo_id) REFERENCES Vehiculo(vehiculo_id)
);

CREATE TABLE UbicacionOficina (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

CREATE TABLE ContenidoSoporte (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT
);