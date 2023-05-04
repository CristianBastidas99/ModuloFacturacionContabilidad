package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Impuesto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.DetalleFactura;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class FacturaController implements Initializable {

    @FXML private TableView facturaTable;
    @FXML private TableColumn idFacturaColumn;
    @FXML private TableColumn fechaColumn;
    @FXML private TableColumn totalColumn;
    @FXML private TableColumn idOrdenDeCompraColumn;
    @FXML private TableColumn idPagoColumn;
    @FXML private TableColumn idClienteColumn;
    @FXML private TextField fechaField;
    @FXML private TextField totalField;
    @FXML private TextField ordenDeCompraField;
    @FXML private TextField pagoField;
    @FXML private TextField clienteField;
    @FXML private TableView detalleFacturaTable;
    @FXML private TableColumn idDetalleFacturaColumn;
    @FXML private TableColumn cantidadColumn;
    @FXML private TableColumn itemColumn;
    @FXML private TableColumn impuestoColumn;
    @FXML private Button agregarDetalleButton;
    @FXML private Button eliminarDetalleButton;
    @FXML private Button nuevaFacturaButton;
    @FXML private Button editarFacturaButton;
    @FXML private Button eliminarFacturaButton;
    @FXML private Button volverButton;

    private EcenariosController ecenariosController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Configurar las columnas de la tabla de facturas
        idFacturaColumn.setCellValueFactory(new PropertyValueFactory<>("idFactura"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        idOrdenDeCompraColumn.setCellValueFactory(new PropertyValueFactory<>("idOrdenCompra"));
        idPagoColumn.setCellValueFactory(new PropertyValueFactory<>("idPago"));
        idClienteColumn.setCellValueFactory(new PropertyValueFactory<>("idCliente"));

        // Configurar las columnas de la tabla de detalles de factura
        idDetalleFacturaColumn.setCellValueFactory(new PropertyValueFactory<>("idDetalleFactura"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        impuestoColumn.setCellValueFactory(new PropertyValueFactory<>("impuesto"));

    }

    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub

        this.ecenariosController = ecenariosController;
    }

    @FXML
    private void mostrarVentanaAdvertencia() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DetalleFactura.fxml"));
        Parent root = fxmlLoader.load();

        // Asociar el controlador con el archivo FXML
        //OrdenDeCompraController controller = loader.getController();
        //controller.init(this);

        // Obtén los datos ingresados por el usuario en los campos de texto
        TextField idDetalleFacturaField = (TextField) fxmlLoader.getNamespace().get("idDetalleFacturaField");
        double cantidad = Double.parseDouble(((TextField) fxmlLoader.getNamespace().get("cantidadField")).getText());
        ComboBox<Item> itemComboBox = (ComboBox<Item>) fxmlLoader.getNamespace().get("itemComboBox");
        Item item = itemComboBox.getValue();
        ComboBox<Impuesto> impuestoComboBox = (ComboBox<Impuesto>) fxmlLoader.getNamespace().get("impuestoComboBox");
        Impuesto impuesto = impuestoComboBox.getValue();

        // Crea un nuevo objeto DetalleFactura con los datos ingresados
        int idDetalleFactura = Integer.parseInt(idDetalleFacturaField.getText());
        DetalleFactura detalleFactura = new DetalleFactura(idDetalleFactura, cantidad, item, impuesto);

        // Crea una nueva ventana para mostrar el objeto creado
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleAgregarDetalleButton(ActionEvent actionEvent) {
    }

    public void handleEliminarDetalleButton(ActionEvent actionEvent) {
    }

    public void handleNuevaFacturaButtonAction(ActionEvent actionEvent) {
    }

    public void handleEditarFacturaButtonAction(ActionEvent actionEvent) {
    }

    public void handleEliminarFacturaButtonAction(ActionEvent actionEvent) {
    }

    public void handleVolverButtonAction(ActionEvent actionEvent) {
        ecenariosController.cargarDashboard();
    }
}
