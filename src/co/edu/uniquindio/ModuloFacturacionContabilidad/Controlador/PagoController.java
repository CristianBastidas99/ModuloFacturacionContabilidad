package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Transaccion;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class PagoController implements Initializable {

    @FXML private TableView<Pago> pagoTable;
    @FXML private TableColumn<Pago, Integer> idPagoColumn;
    @FXML private TableColumn<Pago, LocalDate> fechaColumn;
    @FXML private TableColumn<Pago, Double> montoColumn;
    @FXML private TableColumn<Pago, String> estadoColumn;
    @FXML private TableColumn<Pago, MetodoPago> metodoPagoColumn;
    @FXML private TableColumn<Pago, Integer> idFacturaColumn;
    @FXML private TableColumn<Pago, Integer> idTransaccionColumn;

    @FXML private DatePicker fechaPicker;
    @FXML private TextField montoField;
    @FXML private ComboBox<String> estadoComboBox;
    @FXML private ComboBox<MetodoPago> metodoPagoComboBox;
    @FXML private TextField idFacturaField;
    @FXML private TextField idTransaccionField;

    private EcenariosController ecenariosController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar columnas de la tabla de pagos
        idPagoColumn.setCellValueFactory(new PropertyValueFactory<>("id_pago"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        montoColumn.setCellValueFactory(new PropertyValueFactory<>("monto"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
        metodoPagoColumn.setCellValueFactory(new PropertyValueFactory<>("metodoPago"));
        idFacturaColumn.setCellValueFactory(cellData -> {
            Factura factura = cellData.getValue().getFactura();
            Integer idFactura = (factura != null) ? factura.getId_factura() : null;
            return new SimpleObjectProperty<>(idFactura);
        });
        idTransaccionColumn.setCellValueFactory(cellData -> {
            Transaccion transaccion = cellData.getValue().getTransaccion();
            Integer idTransaccion = (transaccion != null) ? transaccion.getId_transaccion() : null;
            return new SimpleObjectProperty<>(idTransaccion);
        });

        // Configurar opciones del ComboBox de estados
        ObservableList<String> estados = FXCollections.observableArrayList(
                "Pendiente", "Autorizado", "Rechazado", "Procesando", "Completado", "Cancelado");
        estadoComboBox.setItems(estados);

        // Configurar opciones del ComboBox de métodos de pago
        ObservableList<MetodoPago> metodosPago = FXCollections.observableArrayList(
                MetodoPago.TARJETA_DE_CRÉDITO, MetodoPago.TARJETA_DE_DÉBITO, MetodoPago.PAYPAL,
                MetodoPago.TRANSFERENCIA_BANCARIA, MetodoPago.BITCOIN, MetodoPago.APPLE_PAY,
                MetodoPago.GOOGLE_PAY, MetodoPago.AMAZON_PAY, MetodoPago.GIROPAY, MetodoPago.KLARNA);
        metodoPagoComboBox.setItems(metodosPago);

        restringirCeldas();

        // Asignar un listener a la tabla de Pago para actualizar el formulario del Pago
        pagoTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarPago(newValue));

    }

    private void mostrarPago(Pago pago) {
        if (pago != null) {
            ecenariosController.setPagoSeleccionado(pago);
            fechaPicker.setValue(pago.getFecha());
            montoField.setText(Double.toString(pago.getMonto()));
            estadoComboBox.setValue(pago.getEstado());
            metodoPagoComboBox.setValue(pago.getMetodoPago());
            idFacturaField.setText(pago.getFactura() != null ? Integer.toString(pago.getFactura().getId_factura()) : "");
            idTransaccionField.setText(pago.getTransaccion() != null ? Integer.toString(pago.getTransaccion().getId_transaccion()) : "");
        }
    }

    private void restringirCeldas () {

        // Restringir formato decimal en el campo de monto
        String decimalRegex = "\\d*([.]\\d{0,2})?";
        UnaryOperator<TextFormatter.Change> filterMonto = change -> {
            String newText = change.getControlNewText();
            if (newText.matches(decimalRegex)) {
                return change;
            }
            return null;
        };
        TextFormatter<String> formatterMonto = new TextFormatter<>(filterMonto);
        montoField.setTextFormatter(formatterMonto);

        // Restringir formato numérico en el campo de ID de factura
        UnaryOperator<TextFormatter.Change> filterId = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        };
        TextFormatter<String> formatterIdFactura = new TextFormatter<>(filterId);
        idFacturaField.setTextFormatter(formatterIdFactura);

        // Restringir formato numérico en el campo de ID de transacción
        TextFormatter<String> formatterIdTransaccion = new TextFormatter<>(filterId);
        idTransaccionField.setTextFormatter(formatterIdTransaccion);
    }


    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub

        this.ecenariosController = ecenariosController;

        // Crear la lista observable y agregar los objetos Factura
        pagoTable.getItems().clear();
        ObservableList<Pago> listaPagos = FXCollections.observableArrayList();
        List<Pago> listaPagosBase = this.ecenariosController.getProyectoSeleccionado().getPagos();
        listaPagos.addAll(listaPagosBase);
        pagoTable.setItems(listaPagos);

        Pago pago = this.ecenariosController.getPagoSeleccionado();
        if(pago != null){
            pagoTable.getSelectionModel().select(listaPagos.indexOf(pago));
            mostrarPago(pago);
        }
    }

    public void limpiarPago(ActionEvent actionEvent) {
    }

    public void crearPago(ActionEvent actionEvent) {
    }

    public void editarPago(ActionEvent actionEvent) {
    }

    public void eliminarPago(ActionEvent actionEvent) {
    }

    public void volver(ActionEvent actionEvent) {
    }


}
