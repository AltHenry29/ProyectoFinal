module com.example.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires java.sql;

    opens app to javafx.fxml;
    exports app;

    exports controller;
    opens controller to javafx.fxml;
}