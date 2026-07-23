package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    protected static final String url = "jdbc:mysql://root:ZlsbPteGiLbZMGLVKLgVYTSXXBsCopDA@sakura.proxy.rlwy.net:34937/railway";

    protected static final String user = "root";

    protected static final String password = "ZlsbPteGiLbZMGLVKLgVYTSXXBsCopDA";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {

            System.out.println("Error de conexión");

            e.printStackTrace();

            return null;

        }

    }

}