package controller;

import app.Main;
import dao.LibroDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Libro;

import java.io.IOException;
import java.sql.SQLException;

public class EmpleadoController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtGenero;

    @FXML
    private TableView<Libro> tablaLibros;

    @FXML
    private TableColumn<Libro,Integer> colId;

    @FXML
    private TableColumn<Libro,String> colTitulo;

    @FXML
    private TableColumn<Libro,String> colAutor;

    @FXML
    private TableColumn<Libro,Integer> colAnio;

    @FXML
    private TableColumn<Libro,String> colISBN;

    @FXML
    private TableColumn<Libro,String> colGenero;

    private final LibroDAO dao = new LibroDAO();

    private boolean editando = false;

    @FXML
    public void initialize(){
        System.out.println(tablaLibros);
        colId.setCellValueFactory(data ->
                new javafx.beans.property.SimpleIntegerProperty(
                        data.getValue().getId()).asObject());

        colTitulo.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getTitulo()));

        colAutor.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getAutor()));

        colAnio.setCellValueFactory(data ->
                new javafx.beans.property.SimpleIntegerProperty(
                        data.getValue().getAnio()).asObject());

        colISBN.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getIsbn()));

        colGenero.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getGenero()));

        colId.setPrefWidth(60);
        colTitulo.setPrefWidth(180);
        colAutor.setPrefWidth(150);
        colISBN.setPrefWidth(120);
        colAnio.setPrefWidth(70);
        colGenero.setPrefWidth(120);
        actualizarTabla();

    }

    private void actualizarTabla(){
        tablaLibros.setItems(dao.listar());

    }

    public void cargarLibro(Libro libro){
        editando = true;

        txtId.setText(String.valueOf(libro.getId()));
        txtTitulo.setText(libro.getTitulo());
        txtAutor.setText(libro.getAutor());
        txtAnio.setText(String.valueOf(libro.getAnio()));
        txtISBN.setText(libro.getIsbn());
        txtGenero.setText(libro.getGenero());

    }

    @FXML
    private void guardar(){

        Libro libro = new Libro(

                Integer.parseInt(txtId.getText()),
                txtTitulo.getText(),
                txtAutor.getText(),
                Integer.parseInt(txtAnio.getText()),
                txtISBN.getText(),
                txtGenero.getText()

        );

        if(editando){

            dao.actualizar(libro);

        }else{

            dao.insertar(libro);

        }

        actualizarTabla();

        limpiar();

    }

    @FXML
    private void editar(){
        Libro libro = tablaLibros.getSelectionModel().getSelectedItem();

        if(libro == null){

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("Seleccione un libro.");
            alerta.show();
            return;

        }

        cargarLibro(libro);

        dao.actualizar(libro);
        actualizarTabla();
        limpiar();
    }

    @FXML
    private void eliminar(){
        dao.eliminar(Integer.parseInt(txtId.getText()));
        actualizarTabla();
        limpiar();
    }

    @FXML
    private void limpiar(){

        txtId.clear();
        txtTitulo.clear();
        txtAutor.clear();
        txtAnio.clear();
        txtISBN.clear();
        txtGenero.clear();

    }

    @FXML
    private void ex() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/administrador.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 500);
        Stage stage = new Stage();
        stage.setTitle("Administrador");
        stage.setScene(scene);
        stage.show();

        Stage exit = (Stage) this.txtAutor.getScene().getWindow();
        exit.close();
    }



}