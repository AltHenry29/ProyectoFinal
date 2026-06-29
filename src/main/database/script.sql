CREATE DATABASE Biblioteca;

USE Biblioteca;

CREATE TABLE usuarios(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50),
apellido VARCHAR(50),
usuario VARCHAR(30) UNIQUE,
password VARCHAR(100),
rol VARCHAR(20)
);


CREATE TABLE libros(
id INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(120),
autor VARCHAR(80),
editorial VARCHAR(80),
anio INT,
categoria INT,
stock INT,
FOREIGN KEY(categoria)
REFERENCES categorias(id)
);


INSERT INTO usuarios
(nombre,apellido,usuario,password,rol)VALUES
('Administrador','Sistema','admin','12345','Administrador'),
('Luis','Perez','luis','123','Bibliotecario');


INSERT INTO libros
(titulo,autor,editorial,anio,categoria,stock)VALUES
('Java Desde Cero','AlvaMajo','Pearson',2024,1,8),
('MySQL Avanzado','Profe','McGraw Hill',2023,2,5),
('Álgebra Lineal','Pitagoras','McGraw Hill',2022,3,12);