package db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Conexion {

    String URI =
            "mongodb+srv://dplxlv:12345@cluster0.qlhz9h3.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    MongoClient cliente =
            MongoClients.create(URI);

    public MongoDatabase getDatabase() {
        return cliente.getDatabase("Biblioteca");
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        System.out.println(conexion.getDatabase().getName());
    }
}