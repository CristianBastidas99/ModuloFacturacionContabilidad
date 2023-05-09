package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Impuesto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Item;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;


public class FacturaController implements Initializable {

    @FXML private TableView<Factura> facturaTable;
    @FXML private TableColumn<Factura, Integer> idFacturaColumn;
    @FXML private TableColumn<Factura, LocalDate> fechaColumn;
    @FXML private TableColumn<Factura, Double> totalColumn;
    @FXML private TableColumn<Factura, Integer> idOrdenDeCompraColumn;
    @FXML private TableColumn<Factura, Integer> idPagoColumn;
    @FXML private TableColumn<Factura, Integer> idClienteColumn;


    @FXML private DatePicker fechaField;
    @FXML private TextField totalField;
    @FXML private TextField ordenDeCompraField;
    @FXML private TextField pagoField;
    @FXML private TextField clienteField;


    @FXML private TableView<DetalleFactura> detalleFacturaTable;
    @FXML private TableColumn<DetalleFactura, Integer> idDetalleFacturaColumn;
    @FXML private TableColumn<DetalleFactura, Integer> cantidadColumn;
    @FXML private TableColumn<DetalleFactura, String> itemColumn;
    @FXML private TableColumn<DetalleFactura, Double> impuestoColumn;


    private EcenariosController ecenariosController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Configurar las columnas de la tabla de facturas
        idFacturaColumn.setCellValueFactory(new PropertyValueFactory<>("idFactura"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        idOrdenDeCompraColumn.setCellValueFactory(cellData -> cellData.getValue().getOrdenDeCompra().idOrdenDeCompraProperty().asObject());
        idPagoColumn.setCellValueFactory(cellData -> cellData.getValue().getPago().idPagoProperty().asObject());
        idClienteColumn.setCellValueFactory(cellData -> cellData.getValue().getCliente().idClienteProperty().asObject());


        // Configurar las columnas de la tabla de detalles de factura
        idDetalleFacturaColumn.setCellValueFactory(new PropertyValueFactory<>("idDetalleFactura"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        itemColumn.setCellValueFactory(cellData -> cellData.getValue().getItem().toStringProperty());
        impuestoColumn.setCellValueFactory(cellData -> cellData.getValue().getImpuesto().porcentajeProperty().asObject());

        restringirCeldas();

        // Asignar un listener a la tabla de órdenes de compra para actualizar el formulario de factura
        facturaTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarFactura(newValue));

    }

    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub

        this.ecenariosController = ecenariosController;

        // Crear la lista observable y agregar los objetos Factura
        facturaTable.getItems().clear();
        ObservableList<Factura> listaFacturas = FXCollections.observableArrayList();
        List<Factura> listaFacturasBase = this.ecenariosController.getProyectoSeleccionado().getFacturas();
        listaFacturas.addAll(listaFacturasBase);
        facturaTable.setItems(listaFacturas);

        Factura factura = this.ecenariosController.getFacturaSeleccionada();
        if(factura != null){
            facturaTable.getSelectionModel().select(listaFacturas.indexOf(factura));

            fechaField.setValue(factura.getFecha());
            totalField.setText(Double.toString(factura.getTotal()));
            ordenDeCompraField.setText(Integer.toString(factura.getOrdenDeCompra().getId_orden_compra()));
            pagoField.setText(Integer.toString(factura.getPago().getId_pago()));
            clienteField.setText(Integer.toString(factura.getCliente().getId_cliente()));

            // Cargar los items de la orden de compra en la tabla de items
            detalleFacturaTable.getItems().clear();
            ObservableList<DetalleFactura> listaDetalleFacturas = FXCollections.observableArrayList();
            listaDetalleFacturas.addAll(this.ecenariosController.getFacturaSeleccionada().getDetalleFacturas());
            detalleFacturaTable.getItems().addAll(listaDetalleFacturas);
        }

    }

    private void mostrarFactura(Factura factura) {
        if (factura != null) {
            ecenariosController.setFacturaSeleccionada(factura);
            fechaField.setValue(factura.getFecha());
            totalField.setText(Double.toString(factura.getTotal()));
            ordenDeCompraField.setText(Integer.toString(factura.getOrdenDeCompra().getId_orden_compra()));
            pagoField.setText(Integer.toString(factura.getPago().getId_pago()));
            clienteField.setText(Integer.toString(factura.getCliente().getId_cliente()));

            // Cargar los items de la orden de compra en la tabla de items
            detalleFacturaTable.getItems().clear();
            ObservableList<DetalleFactura> listaDetalleFacturas = FXCollections.observableArrayList();
            listaDetalleFacturas.addAll(this.ecenariosController.getFacturaSeleccionada().getDetalleFacturas());
            detalleFacturaTable.getItems().addAll(listaDetalleFacturas);

        }
    }

    public void restringirCeldas (){

        String decimalRegex = "\\d*([.]\\d{0,2})?";
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches(decimalRegex)) {
                return change;
            }
            return null;
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        totalField.setTextFormatter(formatter);

        UnaryOperator<TextFormatter.Change> filter2 = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        };
        TextFormatter<String> formatter2 = new TextFormatter<>(filter2);
        ordenDeCompraField.setTextFormatter(formatter2);

        TextFormatter<String> formatter3 = new TextFormatter<>(filter2);
        pagoField.setTextFormatter(formatter3);

        TextFormatter<String> formatter4 = new TextFormatter<>(filter2);
        clienteField.setTextFormatter(formatter4);

    }

    public void handleAgregarDetalleButton(ActionEvent actionEvent) {

        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<Factura> selectionModel = facturaTable.getSelectionModel();
        // Verificar si hay algún elemento seleccionado
        if (selectionModel.getSelectedItem() != null) {
            // Obtener el índice del elemento seleccionado
            ecenariosController.setFacturaSeleccionada(selectionModel.getSelectedItem());
            ecenariosController.cargarSDetalleFactura();
        } else {
            if(validarCampos()) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error en selección de Factura");
                alert.setHeaderText("¿Desea crear primero la Factura?");
                alert.setContentText("Presione OK para continuar o Cancelar para salir.");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    handleNuevaFacturaButtonAction(actionEvent);
                } else {
                    // Hacer otra cosa si el usuario presiona "Cancelar"
                }
            }
        }
    }

    private boolean validarCampos() {
        if(fechaField.getValue() == null || fechaField.getValue().isBefore(LocalDate.now())) {
            // Mostrar mensaje de error o alerta indicando que el campo fecha es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo fecha");
            alert.setHeaderText("El campo esta vacio o fecha menor a hoy");
            alert.setContentText("Debes colocar una fecha valida para continuar.");
            alert.showAndWait();
            return false;
        }
        if(totalField.getText().isEmpty()) {
            // Mostrar mensaje de error o alerta indicando que el campo total es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo total");
            alert.setHeaderText("El campo esta vacio");
            alert.setContentText("Debes colocar un valor para continuar.");
            alert.showAndWait();
            return false;
        }

        if(ordenDeCompraField.getText().isEmpty() || isInOrdenDeCompras(Integer.parseInt(ordenDeCompraField.getText())) == null) {
            // Mostrar mensaje de error o alerta indicando que el campo idProveedor es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo id OrdenDeCompra");
            alert.setHeaderText("El campo esta vacio o la OrdenDeCompra no existe");
            alert.setContentText("Debes colocar un valor valido para continuar.");
            alert.showAndWait();
            return false;
        }

        if(pagoField.getText().isEmpty() || isInPagos(Integer.parseInt(pagoField.getText())) == null) {
            // Mostrar mensaje de error o alerta indicando que el campo idProveedor es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo id Pago");
            alert.setHeaderText("El campo esta vacio o el pago no existe");
            alert.setContentText("Debes colocar un valor valido para continuar.");
            alert.showAndWait();
            return false;
        }

        if(clienteField.getText().isEmpty() || isInCLiente(Integer.parseInt(clienteField.getText())) == null) {
            // Mostrar mensaje de error o alerta indicando que el campo idProveedor es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo id CLiente");
            alert.setHeaderText("El campo esta vacio o el cliente no existe");
            alert.setContentText("Debes colocar un valor valido para continuar.");
            alert.showAndWait();
            return false;
        }

        // Validar los campos de la tabla, si es necesario
        return true;
    }

    private OrdenDeCompra isInOrdenDeCompras(int idOrdenDeCompra) {
        List<OrdenDeCompra> ordenDeCompras = ecenariosController.getProyectoSeleccionado().getOrdenDeCompras();
        for (OrdenDeCompra ordenDeCompra : ordenDeCompras) {
            if(ordenDeCompra.getId_orden_compra() == idOrdenDeCompra){
                return ordenDeCompra;
            }
        }
        return null;
    }

    private Pago isInPagos(int idPago) {
        List<Pago> pagos = ecenariosController.getProyectoSeleccionado().getPagos();
        for (Pago pago : pagos) {
            if(pago.getId_pago() == idPago){
                return pago;
            }
        }
        return null;
    }

    private Cliente isInCLiente(int idCliente) {
        List<Cliente> clientes = ecenariosController.getPrincipal().getClientes();
        for (Cliente cliente : clientes) {
            if(cliente.getId_cliente() == idCliente){
                return cliente;
            }
        }
        return null;
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
