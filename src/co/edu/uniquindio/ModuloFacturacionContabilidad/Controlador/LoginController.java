package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginController {

    @FXML
    private GridPane loginPane;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void loginButtonClicked(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Validar que el correo sea válido
        if (!isValidEmail(email)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de inicio de sesión");
            alert.setHeaderText("Correo electrónico no válido");
            alert.setContentText("Ingrese un correo electrónico válido para iniciar sesión.");
            alert.showAndWait();
            return;
        }

        // Verificar las credenciales del usuario
        if (isValidUser(email, password)) {
            // Iniciar sesión correctamente
            // Aquí puedes cambiar esta acción por la que necesites
            System.out.println("Iniciando sesión con el correo electrónico: " + email);
        } else {
            // Credenciales inválidas
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de inicio de sesión");
            alert.setHeaderText("Credenciales incorrectas");
            alert.setContentText("El correo electrónico o la contraseña son incorrectos. Vuelve a intentarlo.");
            alert.showAndWait();
        }
    }

    private boolean isValidEmail(String email) {
        // Aquí puedes agregar tu propia validación de correo electrónico
        // Este ejemplo solo verifica que el correo tenga un formato válido
        return email.matches("^\\S+@\\S+\\.\\S+$");
    }

    private boolean isValidUser(String email, String password) {
        // Aquí puedes agregar tu propia validación de usuario y contraseña
        // Este ejemplo solo verifica que el correo y la contraseña sean iguales
        return true;//email.equals(password);
    }

}
