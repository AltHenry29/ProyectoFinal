package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import db.Conexion;
import org.bson.Document;
import com.mongodb.client.model.Filters;

public class UsuarioDAO {

    public boolean login(String usuario, String password) {

        Conexion conexion = new Conexion();
        MongoDatabase db = conexion.getDatabase();

        MongoCollection<Document> coleccion =
                db.getCollection("usuarios");

        Document doc = coleccion.find(
                Filters.and(
                        Filters.eq("usuario", usuario),
                        Filters.eq("password", password)
                )
        ).first();

        return doc != null;
    }
}