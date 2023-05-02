package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Principal.Principal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EcenariosController {

    private Stage primaryStage;
    private Principal principal;
    private Cliente clienteSesion;
    private Proyecto proyectoSeleccionado;

    public EcenariosController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.principal = new Principal();
        this.clienteSesion = null;
        this.proyectoSeleccionado = null;
        cargarLogin();
    }

    public void cargarLogin() {
        try {

            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
            AnchorPane root = loader.load();

            // Asociar el controlador con el archivo FXML
            LoginController controller = loader.getController();
            controller.init(this);

            // Configurar la escena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Inicio de sesión");
            primaryStage.show();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void cargarSeleccionarProyecto() {
        try {

            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SeleccionarProyecto.fxml"));
            AnchorPane root = loader.load();

            // Asociar el controlador con el archivo FXML
            SeleccionarProyectoController controller = loader.getController();
            controller.init(this);

            // Configurar la escena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Seleccionar Proyecto");
            primaryStage.show();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void cargarDashboard() {
        try {

            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Dashboard .fxml"));
            BorderPane root = loader.load();

            // Asociar el controlador con el archivo FXML
            DashboardController controller = loader.getController();
            controller.init(this);

            // Configurar la escena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Dashboard");
            primaryStage.show();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public boolean isValidUser(String email, String password) {
        Cliente cliente = principal.isValidUser(email, password);
        if(!(cliente == null)){
            this.clienteSesion = cliente;
            return true;
        }
        return false;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public Cliente getClienteSesion() {
        return clienteSesion;
    }

    public void setClienteSesion(Cliente clienteSesion) {
        this.clienteSesion = clienteSesion;
    }

    public Proyecto getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }
}
