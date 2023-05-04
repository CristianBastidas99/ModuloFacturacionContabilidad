package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Item;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Principal.*;
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
    private Factura facturaSeleccionada;
    private DetalleFactura detalleFacturaSeleccionado;
    private OrdenDeCompra ordenDeCompraSeleccionada;
    private Item itemSeleccionado;
    private Proveedor proveedorSeleccionado;

    public EcenariosController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.principal = new Principal();
        this.clienteSesion = null;
        this.proyectoSeleccionado = null;
        this.facturaSeleccionada = null;
        this.detalleFacturaSeleccionado = null;
        this.ordenDeCompraSeleccionada = null;
        this.itemSeleccionado = null;
        this.proveedorSeleccionado = null;
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

    public void cargarFactura() {
        try {

            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Factura.fxml"));
            AnchorPane root = loader.load();

            // Asociar el controlador con el archivo FXML
            FacturaController controller = loader.getController();
            controller.init(this);

            // Configurar la escena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Factura");
            primaryStage.show();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void cargarOrdenDeCompra(){
        try {

            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/OrdenDeCompra.fxml"));
            AnchorPane root = loader.load();

            // Asociar el controlador con el archivo FXML
            OrdenDeCompraController controller = loader.getController();
            controller.init(this);

            // Configurar la escena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Orden de Compra");
            primaryStage.show();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void cargarSeleccionarItem(){
        try {

            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SeleccionarItem.fxml"));
            AnchorPane root = loader.load();

            // Asociar el controlador con el archivo FXML
            SeleccionarItemController controller = loader.getController();
            controller.init(this);

            // Configurar la escena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Seleccionar Item");
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

    public Factura getFacturaSeleccionada() {
        return facturaSeleccionada;
    }

    public void setFacturaSeleccionada(Factura facturaSeleccionada) {
        this.facturaSeleccionada = facturaSeleccionada;
    }

    public DetalleFactura getDetalleFacturaSeleccionado() {
        return detalleFacturaSeleccionado;
    }

    public void setDetalleFacturaSeleccionado(DetalleFactura detalleFacturaSeleccionado) {
        this.detalleFacturaSeleccionado = detalleFacturaSeleccionado;
    }

    public OrdenDeCompra getOrdenDeCompraSeleccionada() {
        return ordenDeCompraSeleccionada;
    }

    public void setOrdenDeCompraSeleccionada(OrdenDeCompra ordenDeCompraSeleccionada) {
        this.ordenDeCompraSeleccionada = ordenDeCompraSeleccionada;
    }

    public Item getItemSeleccionado() {
        return itemSeleccionado;
    }

    public void setItemSeleccionado(Item itemSeleccionado) {
        this.itemSeleccionado = itemSeleccionado;
    }

    public Proveedor getProveedorSeleccionado() {
        return proveedorSeleccionado;
    }

    public void setProveedorSeleccionado(Proveedor proveedorSeleccionado) {
        this.proveedorSeleccionado = proveedorSeleccionado;
    }
}
