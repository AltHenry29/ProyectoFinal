package model;

public class Usuario extends Persona {

    private String usuario;
    private String password;
    private String rol;

    public Usuario(int id, String nombre, String apellido, String usuario, String password, String rol) {
        super(id, nombre, apellido);
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("===== DATOS DEL USUARIO =====");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Usuario: " + usuario);
        System.out.println("Rol: " + rol);
        System.out.println("=============================");
    }

    @Override
    public String toString() {

        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", rol='" + rol + '\'' +
                '}';

    }

}