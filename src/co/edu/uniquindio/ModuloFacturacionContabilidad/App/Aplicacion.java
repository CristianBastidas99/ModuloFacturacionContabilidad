package co.edu.uniquindio.ModuloFacturacionContabilidad.App;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        AnchorPane root = loader.load();

        // Asociar el controlador con el archivo FXML
        LoginController controller = loader.getController();

        // Configurar la escena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inicio de sesión");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
