package model;

public abstract class Usuario extends Persona {

    private String usuario;
    private String password;
    private String rol;

    public Usuario(int id, String nombre, String apellido,
                   String usuario, String password, String rol) {

        super(id, nombre, apellido);

        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }
}