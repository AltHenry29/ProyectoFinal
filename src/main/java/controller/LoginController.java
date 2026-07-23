package controller;

import app.Main;
import dao.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;

import java.io.IOException;

public class LoginController {
    @FXML
    protected TextField user;
    @FXML
    protected PasswordField pass;

    @FXML
    public void Confirmar(ActionEvent actionEvent) throws IOException, NoSuchFieldException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.login(
                user.getText(),
                pass.getText()
        );

        if(usuario == null){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Login");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario o contraseña incorrectos.");
            alerta.showAndWait();
            return;

        }

        FXMLLoader loader;
        switch(usuario.getRol()){
            case "Administrador":
                loader = new FXMLLoader(
                        Main.class.getResource("/view/administrador.fxml"));
                break;

            case "Bibliotecario":
                loader = new FXMLLoader(
                        Main.class.getResource("/view/empleado.fxml"));
                break;

            default:
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Rol no permitido.");
                alerta.show();
                return;

        }

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Biblioteca");
        stage.show();
        Stage actual = (Stage)user.getScene().getWindow();
        actual.close();

    }

    public void sal(ActionEvent actionEvent) {
        Stage cerr = (Stage)this.user.getScene().getWindow();
        cerr.close();
    }
}
