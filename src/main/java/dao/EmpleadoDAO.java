package dao;

import db.Conexion;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import model.Libro;
import model.Usuario;

import java.sql.*;
import java.util.*;

import static com.mongodb.client.model.Filters.eq;

public class EmpleadoDAO{

    public EmpleadoDAO(){

    }

    public void insertar(Usuario usuario){

        String sql=

                "INSERT INTO usuarios " +

                        "(id,nombre,apellido,numero,usuario,password,rol) " +

                        "VALUES (?,?,?,?,?,?,?)";

        try(Connection con=Conexion.getConnection()){

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,usuario.getId());

            ps.setString(2,usuario.getNombre());

            ps.setString(3,usuario.getApellido());

            ps.setString(5,usuario.getUsuario());

            ps.setString(6,usuario.getPassword());

            ps.setString(7,usuario.getRol());

            ps.executeUpdate();

        }catch(SQLException e){

            e.printStackTrace();

        }

    }

    public ObservableList<Usuario> listar(){

        ObservableList<Usuario> lista = FXCollections.observableArrayList(); {

        };

        String sql="SELECT * FROM usuarios";

        try(Connection con=Conexion.getConnection()){

            PreparedStatement ps=con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                Usuario u=new Usuario(

                        rs.getInt("id"),

                        rs.getString("nombre"),

                        rs.getString("apellido"),

                        rs.getString("usuario"),

                        rs.getString("password"),

                        rs.getString("rol")

                );

                lista.add(u);

            }

        }catch(SQLException e){

            e.printStackTrace();

        }

        return lista;

    }

    public void eliminar(int id){

        String sql="DELETE FROM usuarios WHERE id=?";

        try(Connection con=Conexion.getConnection()){

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

        }catch(SQLException e){

            e.printStackTrace();

        }

    }

    public Usuario buscar(int id) {

        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Usuario(

                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("usuario"),
                        rs.getString("password"),
                        rs.getString("rol")

                );

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    public void actualizar(Usuario usuario) {

        String sql = "UPDATE usuarios SET " +
                "nombre = ?, " +
                "apellido = ?, " +
                "numero = ?, " +
                "usuario = ?, " +
                "password = ?, " +
                "rol = ? " +
                "WHERE id = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getPassword());
            ps.setString(5, usuario.getRol());
            ps.setInt(6, usuario.getId());

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}