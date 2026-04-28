-- Crear base de datos
CREATE DATABASE parqueadero;

-- Usar base de datos (PostgreSQL)
\c parqueadero;

-- Tabla tipo_vehiculo (por si no existe)
CREATE TABLE IF NOT EXISTS tipo_vehiculo (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50)
);

-- Insertar datos iniciales
INSERT INTO tipo_vehiculo (nombre) VALUES ('Carro');
INSERT INTO tipo_vehiculo (nombre) VALUES ('Moto');
INSERT INTO tipo_vehiculo (nombre) VALUES ('Bicicleta');