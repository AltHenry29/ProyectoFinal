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
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    anio INT,
    isbn VARCHAR(30),
    genero VARCHAR(50)
);


INSERT INTO usuarios
(nombre,apellido,usuario,password,rol)VALUES
('Administrador','Sistema','admin','12345','Administrador'),
('Herny','Toanto','Hank','2909','Bibliotecario');


INSERT INTO libros
(titulo,autor,anio,isbn,genero)VALUES
('Cien años de soledad','Gabriel García Márquez',1967,'9780307474728','Novela'),
('1984','George Orwell',1949,'9780451524935','Ciencia Ficción'),
('El Principito','Antoine de Saint-Exupéry',1943,'9780156012195','Infantil');