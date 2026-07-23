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

public class AdministradorController {

    @FXML
    private TextField txtBuscar;

    @FXML
    private TableView<Libro> tablaLibros;

    @FXML
    private TableColumn<Libro,Integer> colId;

    @FXML
    private TableColumn<Libro,String> colTitulo;

    @FXML
    private TableColumn<Libro,String> colAutor;

    @FXML
    private TableColumn<Libro,String> colISBN;

    @FXML
    private TableColumn<Libro,Integer> colAnio;

    @FXML
    private TableColumn<Libro,String> colGenero;

    private final LibroDAO dao = new LibroDAO();

    @FXML
    public void initialize(){
        System.out.println("Administrador iniciado");
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

        tablaLibros.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        cargarTabla();

    }

    private void cargarTabla() {

        ObservableList<Libro> lista = dao.listar();

        System.out.println("Cantidad de libros: " + lista.size());

        tablaLibros.setItems(lista);

        System.out.println("Items en TableView: " + tablaLibros.getItems().size());

        for (Libro l : tablaLibros.getItems()) {
            System.out.println(
                    l.getId() + " - " +
                            l.getTitulo() + " - " +
                            l.getAutor()
            );
        }

        tablaLibros.refresh();

    }

    @FXML
    private void buscarLibro() {

        try {

            int id = Integer.parseInt(txtBuscar.getText());

            Libro libro = dao.buscar(id);

            if (libro != null) {

                tablaLibros.getItems().clear();

                tablaLibros.getItems().add(libro);

            } else {

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);

                alerta.setTitle("Búsqueda");

                alerta.setHeaderText(null);

                alerta.setContentText("No se encontró el libro.");

                alerta.showAndWait();

            }

        } catch (NumberFormatException e) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setTitle("Error");

            alerta.setHeaderText(null);

            alerta.setContentText("Ingrese un ID válido.");

            alerta.showAndWait();

        }

    }

    @FXML
    private void abrirEmpleado() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/empleado.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Registro libros");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.showAndWait();
        cargarTabla();

        Stage cerr = (Stage)this.txtBuscar.getScene().getWindow();
        cerr.close();
    }

    @FXML
    private void actualizar(){

        tablaLibros.setItems(dao.listar());

    }

    @FXML
    private void editar() throws IOException {

        Libro libro = tablaLibros.getSelectionModel().getSelectedItem();

        if(libro == null){

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("Seleccione un libro.");
            alerta.show();
            return;

        }

        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/view/empleado.fxml"));

        Scene scene = new Scene(loader.load());

        EmpleadoController controller = loader.getController();

        controller.cargarLibro(libro);

        Stage stage = new Stage();
        stage.setTitle("Editar Libro");
        stage.setScene(scene);
        stage.show();

        Stage actual = (Stage) txtBuscar.getScene().getWindow();
        actual.close();
    }

    @FXML
    private void eliminar(){

        Libro libro = tablaLibros.getSelectionModel().getSelectedItem();

        if (libro == null) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setContentText("Seleccione un libro.");

            alerta.showAndWait();

            return;

        }

        dao.eliminar(libro.getId());

        cargarTabla();

    }

    @FXML
    private void cerrarSesion(){
        Stage cerr = (Stage)this.txtBuscar.getScene().getWindow();
        cerr.close();
    }

}