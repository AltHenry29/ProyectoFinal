package model;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private String isbn;
    private String genero;

    public Libro(int id, String titulo, String autor, int anio, String isbn, String genero) {
        this.id=id;
        this.titulo=titulo;
        this.autor=autor;
        this.anio=anio;
        this.isbn=isbn;
        this.genero=genero;
    }

    @Override
    public String toString() {
        return titulo;
    }
    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getAnio() {
        return anio;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getGenero() {
        return genero;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

}