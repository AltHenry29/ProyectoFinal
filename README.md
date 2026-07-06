# Aplicacion para Biblioteca con JavaFX y MySQL

Este proyecto consiste en desarrollar una aplicación de escritorio utilizando **JavaFX** y **MySQL** para realizar las operaciones básicas de un CRUD (Crear, Leer, Actualizar y Eliminar) sobre una tabla de libros.

---

# Requisitos Iniciales

Antes de comenzar, asegúrese de tener instalado:

- Java JDK 17 o superior
- IntelliJ IDEA (o cualquier IDE compatible con JavaFX)
- MySQL Server
- MySQL Workbench (opcional)
- JavaFX SDK

---

# Paso 1. Crear la Base de Datos

Abrir MySQL Workbench (o cualquier cliente MySQL) y ejecutar el siguiente script.

```sql
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    anio INT NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    genero VARCHAR(50) NOT NULL
);

INSERT INTO libros (titulo, autor, anio, isbn, genero) VALUES
('Cien años de soledad','Gabriel García Márquez',1967,'9780307474728','Novela'),
('1984','George Orwell',1949,'9780451524935','Ciencia Ficción'),
('El Principito','Antoine de Saint-Exupéry',1943,'9780156012195','Infantil');
```

---

# Paso 2. Crear el Proyecto

Crearemos un nuevo proyecto JavaFX desde IntelliJ IDEA.

La estructura del proyecto es:

```
src
 └── main
      ├── java
      │    ├── app
      │    |   └── Main.java
      │    |
      │    ├── com.example.proyectofinal
      │    |   ├── HelloAplication.java
      │    |   └── HelloController.java
      │    |
      │    ├── controller
      │    |   ├── DashboardController.java
      │    |   ├── LoginController.java
      │    |   └── RecursoController.java
      │    |
      │    ├── dao
      │    |   ├── ICRUD.java
      │    |   ├── RecursoDAO.java
      │    |   └── UsuarioDAO.java
      │    |
      │    ├── db
      │    |   └── Conexion.java
      │    |
      │    ├── model
      │    |   ├── Biblioteca.java
      │    |   ├── Persona.java
      │    |   └── Usuario.java
      │    |
      │    └── module-info.java
      │
      └── resources
            ├── com.example.proyectofinal
            |   └── hello-view.fxml
            |
            ├── css
            |   └── estilos.css
            |
            └── view
                ├── dashboard.fxml
                ├── login.fxml
                └── recurso.fxml

```
---
# Esto se ha realizado hasta ahora con los los java implementados y clases abstractas e interfaces.

