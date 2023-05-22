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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        // Limpiar selección y valores en la interfaz
        ecenariosController.setPagoSeleccionado(null);
        pagoTable.getSelectionModel().clearSelection();
        fechaPicker.setValue(null);
        montoField.setText("");
        estadoComboBox.setValue(null);
        metodoPagoComboBox.setValue(null);
        idFacturaField.setText("");
        idTransaccionField.setText("");

        // Mostrar mensaje de confirmación
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Se a limpiado la pantalla");
        alert2.setHeaderText("Con exito");
        alert2.showAndWait();
    }

    public void crearPago(ActionEvent actionEvent) {
        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<Pago> selectionModel = pagoTable.getSelectionModel();
        Pago pago = selectionModel.getSelectedItem();
        List<Pago> listaPagoBase = this.ecenariosController.getProyectoSeleccionado().getPagos();

        // Verificar si hay algún elemento seleccionado
        if (pago == null) {
            if(validarCampos()) {

                String ultimoIdPago = this.ecenariosController.getProyectoSeleccionado().getId_proyecto() + listaPagoBase.size() + "";
                int nuevoIdPago = Integer.parseInt(ultimoIdPago);

                Pago nuevoPago = new Pago();
                nuevoPago.setId_pago(nuevoIdPago);
                nuevoPago.setFecha(fechaPicker.getValue());
                nuevoPago.setMonto(Double.parseDouble(montoField.getText()));
                nuevoPago.setEstado(estadoComboBox.getValue());
                nuevoPago.setMetodoPago(metodoPagoComboBox.getValue());
                nuevoPago.setFactura(isInFacturas(Integer.parseInt(idFacturaField.getText())));
                nuevoPago.setTransaccion(isInTransacciones(Integer.parseInt(idTransaccionField.getText())));

                listaPagoBase.add(nuevoPago);

                String mensaje =  generarCuerpoCorreo(nuevoPago, ecenariosController.getClienteSesion().getNombre(), ecenariosController.getProyectoSeleccionado().getNombre());

                ecenariosController.getPrincipal().enviarConGMail(ecenariosController.getClienteSesion().getEmail(), "Nuevo Pago", mensaje);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Nuevo Pago");
                alert.setHeaderText("Pago creado con éxito");
                alert.setContentText("Se ha creado un nuevo pago.");
                alert.showAndWait();

                this.ecenariosController.cargarPago();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de Pago");
            alert.setHeaderText("Pago seleccionado");
            alert.setContentText("No puedes crear un Pago que ya existe, Tal vez quisieras editarlo");
            alert.showAndWait();
        }

    }

    public String generarCuerpoCorreo(Pago pago, String nombreUsuario, String nombreProyecto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime fechaCreacion = LocalDateTime.now();

        String mensaje = "Estimado " + nombreUsuario + ",\n\n";
        mensaje += "Se ha registrado un nuevo pago en el proyecto " + nombreProyecto + ".\n";
        mensaje += "Detalles del pago:\n";
        mensaje += "Fecha y hora de creación: " + fechaCreacion.format(formatter) + "\n";
        mensaje += "Monto: " + pago.getMonto() + "\n";
        mensaje += "Estado: " + pago.getEstado() + "\n";
        mensaje += "Método de pago: " + pago.getMetodoPago() + "\n";
        mensaje += "Factura: " + pago.getFactura().getId_factura() + "\n";
        mensaje += "Transacción: " + pago.getTransaccion().getId_transaccion() + "\n";
        mensaje += "\nPor favor, revise los detalles y realice las acciones correspondientes.\n";
        mensaje += "Gracias por su atención.\n\n";
        mensaje += "Atentamente,\n";
        mensaje += "Equipo de Proyecto";

        return mensaje;
    }


    private boolean validarCampos() {
        // Verificar si el campo fecha está vacío o es anterior a la fecha actual
        if (fechaPicker.getValue() == null || fechaPicker.getValue().isBefore(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo fecha");
            alert.setHeaderText("El campo está vacío o fecha menor a hoy");
            alert.setContentText("Debes colocar una fecha válida para continuar.");
            alert.showAndWait();
            return false;
        }

        // Verificar si el campo monto está vacío
        if (montoField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo monto");
            alert.setHeaderText("El campo está vacío");
            alert.setContentText("Debes colocar un valor para continuar.");
            alert.showAndWait();
            return false;
        }

        // Verificar si el ComboBox de estado está vacío
        if (estadoComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo estado");
            alert.setHeaderText("El campo está vacío");
            alert.setContentText("Debes seleccionar un estado válido.");
            alert.showAndWait();
            return false;
        }

        // Verificar si el ComboBox de método de pago está vacío
        if (metodoPagoComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo método de pago");
            alert.setHeaderText("El campo está vacío");
            alert.setContentText("Debes seleccionar un método de pago válido.");
            alert.showAndWait();
            return false;
        }

        // Verificar si el campo idFactura está vacío o la factura no existe
        if (idFacturaField.getText().isEmpty() || isInFacturas(Integer.parseInt(idFacturaField.getText())) == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo id Factura");
            alert.setHeaderText("El campo está vacío o la factura no existe");
            alert.setContentText("Debes colocar un valor válido para continuar.");
            alert.showAndWait();
            return false;
        }

        // Verificar si el campo idTransaccion está vacío o la transacción no existe
        if (idTransaccionField.getText().isEmpty() || isInTransacciones(Integer.parseInt(idTransaccionField.getText())) == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo id Transaccion");
            alert.setHeaderText("El campo está vacío o la transacción no existe");
            alert.setContentText("Debes colocar un valor válido para continuar.");
            alert.showAndWait();
            return false;
        }

        return true;
    }


    private Factura isInFacturas(int idFactura) {
        // Obtiene la lista de facturas del proyecto seleccionado
        List<Factura> facturas = ecenariosController.getProyectoSeleccionado().getFacturas();
        for (Factura factura : facturas) {
            // Verifica si el ID de la factura coincide
            if (factura.getId_factura() == idFactura) {
                return factura;
            }
        }
        return null;
    }

    private Transaccion isInTransacciones(int idTransaccion) {
        // Obtiene la lista de transacciones del proyecto seleccionado
        List<Transaccion> transacciones = ecenariosController.getProyectoSeleccionado().getTransaccions();
        for (Transaccion transaccion : transacciones) {
            // Verifica si el ID de la transacción coincide
            if (transaccion.getId_transaccion() == idTransaccion) {
                return transaccion;
            }
        }
        return null;
    }


    public void editarPago(ActionEvent actionEvent) {
    }

    public void eliminarPago(ActionEvent actionEvent) {
    }

    public void volver(ActionEvent actionEvent) {
        ecenariosController.setPagoSeleccionado(null);
        ecenariosController.cargarDashboard();
    }


}
