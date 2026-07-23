package dao;

import db.Conexion;
import model.Usuario;

import java.sql.*;

public class UsuarioDAO {

    public Usuario login(String usuario, String password){

        String sql = "SELECT * FROM usuarios WHERE usuario=? AND password=?";

        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Usuario(

                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("usuario"),
                        rs.getString("password"),
                        rs.getString("rol")

                );

            }

        }catch(SQLException e){

            e.printStackTrace();

        }

        return null;

    }

}