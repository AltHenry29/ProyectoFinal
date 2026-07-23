package dao;

import db.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Libro;

import java.sql.*;

public class LibroDAO {

    public LibroDAO() {

    }

    // INSERTAR
    public void insertar(Libro libro) {

        String sql = "INSERT INTO libros(id,titulo,autor,anio,isbn,genero) VALUES(?,?,?,?,?,?)";

        try(Connection con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, libro.getId());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnio());
            ps.setString(5, libro.getIsbn());
            ps.setString(6, libro.getGenero());

            ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    // LISTAR
    public ObservableList<Libro> listar() {

        ObservableList<Libro> lista = FXCollections.observableArrayList();

        String sql = "SELECT * FROM libros";

        try(Connection con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                System.out.println(rs.getString("titulo"));

                Libro libro = new Libro(

                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anio"),
                        rs.getString("isbn"),
                        rs.getString("genero")

                );

                lista.add(libro);

            }

        } catch(SQLException e) {

            e.printStackTrace();

        }

        return lista;

    }

    // BUSCAR
    public Libro buscar(int id) {

        String sql = "SELECT * FROM libros WHERE id=?";

        try(Connection con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                return new Libro(

                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anio"),
                        rs.getString("isbn"),
                        rs.getString("genero")

                );

            }

        } catch(SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    // ACTUALIZAR
    public void actualizar(Libro libro) {

        String sql = "UPDATE libros SET titulo=?,autor=?,anio=?,isbn=?,genero=? WHERE id=?";

        try(Connection con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getIsbn());
            ps.setString(5, libro.getGenero());
            ps.setInt(6, libro.getId());

            ps.executeUpdate();

        } catch(SQLException e) {

            e.printStackTrace();

        }

    }

    // ELIMINAR
    public void eliminar(int id) {

        String sql = "DELETE FROM libros WHERE id=?";

        try(Connection con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1,id);

            ps.executeUpdate();

        } catch(SQLException e) {

            e.printStackTrace();

        }

    }

}