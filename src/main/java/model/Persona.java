package model;

public abstract class Persona {
    protected int id;
    protected String nombre, apellido;

    public Persona(int id,String nombre,String apellido){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public abstract void mostrarDatos();

}
