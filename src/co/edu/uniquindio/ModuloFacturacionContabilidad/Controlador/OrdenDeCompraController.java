package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Item;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.TipoItem;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;
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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class OrdenDeCompraController implements Initializable {

    // OrdenDeCompra Table
    @FXML private TableView<OrdenDeCompra> tablaOrdenes;
    @FXML private TableColumn<OrdenDeCompra, Integer> colIdOrdenCompra;
    @FXML private TableColumn<OrdenDeCompra, LocalDate> colFecha;
    @FXML private TableColumn<OrdenDeCompra, Double> colTotal;
    @FXML private TableColumn<OrdenDeCompra, Integer> colIdProveedor;

    // OrdenDeCompra Info
    @FXML private DatePicker dpFecha;
    @FXML private TextField tfTotal;
    @FXML private TextField tfIdProveedor;

    // Item Table
    @FXML private TableView<Item> tablaItems;
    @FXML private TableColumn<Item, Integer> colIdItem;
    @FXML private TableColumn<Item, TipoItem> colTipo;
    @FXML private TableColumn<Item, String> colNombre;
    @FXML private TableColumn<Item, String> colDescripcion;
    @FXML private TableColumn<Item, Double> colCostoUnitario;

    // Controller properties
    private EcenariosController ecenariosController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializar la tabla de órdenes de compra
        colIdOrdenCompra.setCellValueFactory(new PropertyValueFactory<>("id_orden_compra"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colIdProveedor.setCellValueFactory(cellData -> cellData.getValue().getProveedor().idProveedorProperty().asObject());

        // Inicializar la tabla de items
        colIdItem.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colCostoUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));

        String decimalRegex = "\\d*([.]\\d{0,2})?";
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches(decimalRegex)) {
                return change;
            }
            return null;
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        tfTotal.setTextFormatter(formatter);

        UnaryOperator<TextFormatter.Change> filter2 = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        };
        TextFormatter<String> formatter2 = new TextFormatter<>(filter2);
        tfIdProveedor.setTextFormatter(formatter2);



        // Asignar un listener a la tabla de órdenes de compra para actualizar el formulario de factura
        tablaOrdenes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarItems(newValue));

    }

    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub

        this.ecenariosController = ecenariosController;

        // Crear la lista observable y agregar los objetos OrdenDeCompra
        tablaOrdenes.getItems().clear();
        ObservableList<OrdenDeCompra> listaOrdenesDeCompra = FXCollections.observableArrayList();
        List<OrdenDeCompra> listaOrdenesCompraBase = this.ecenariosController.getProyectoSeleccionado().getOrdenDeCompras();
        listaOrdenesDeCompra.addAll(listaOrdenesCompraBase);
        tablaOrdenes.setItems(listaOrdenesDeCompra);

        OrdenDeCompra ordenDeCompra = this.ecenariosController.getOrdenDeCompraSeleccionada();
        if(ordenDeCompra != null){
            tablaOrdenes.getSelectionModel().select(listaOrdenesCompraBase.indexOf(ordenDeCompra));

            dpFecha.setValue(ordenDeCompra.getFecha());
            tfTotal.setText(Double.toString(ordenDeCompra.getTotal()));
            tfIdProveedor.setText(Integer.toString(ordenDeCompra.getProveedor().getId_proveedor()));

            // Cargar los items de la orden de compra en la tabla de items
            tablaItems.getItems().clear();
            ObservableList<Item> listaItems = FXCollections.observableArrayList();
            listaItems.addAll(this.ecenariosController.getOrdenDeCompraSeleccionada().getItems());
            tablaItems.getItems().addAll(listaItems);
        }

    }

    private void mostrarItems(OrdenDeCompra ordenDeCompra) {
        if (ordenDeCompra != null) {
            ecenariosController.setOrdenDeCompraSeleccionada(ordenDeCompra);
            dpFecha.setValue(ordenDeCompra.getFecha());
            tfTotal.setText(Double.toString(ordenDeCompra.getTotal()));
            tfIdProveedor.setText(Integer.toString(ordenDeCompra.getProveedor().getId_proveedor()));

            // Cargar los items de la orden de compra en la tabla de items
            tablaItems.getItems().clear();
            ObservableList<Item> listaItems = FXCollections.observableArrayList();
            listaItems.addAll(this.ecenariosController.getOrdenDeCompraSeleccionada().getItems());
            tablaItems.getItems().addAll(listaItems);
        }
    }

    public void agregarItem(ActionEvent actionEvent) {

        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<OrdenDeCompra> selectionModel = tablaOrdenes.getSelectionModel();
        // Verificar si hay algún elemento seleccionado
        if (selectionModel.getSelectedItem() != null) {
            // Obtener el índice del elemento seleccionado
            ecenariosController.setOrdenDeCompraSeleccionada(selectionModel.getSelectedItem());
            ecenariosController.setProveedorSeleccionado(selectionModel.getSelectedItem().getProveedor());
            ecenariosController.cargarSeleccionarItem();
        } else {
            if(validarCampos()) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error en selección de ordenDeCompra");
                alert.setHeaderText("¿Desea crear primero la ordenDeCompra?");
                alert.setContentText("Presione OK para continuar o Cancelar para salir.");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    crearOrdenDeCompra(actionEvent);
                } else {
                    // Hacer otra cosa si el usuario presiona "Cancelar"
                }
            }
        }

    }

    public void quitarItem(ActionEvent actionEvent) {

        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<OrdenDeCompra> selectionModel = tablaOrdenes.getSelectionModel();
        TableView.TableViewSelectionModel<Item> itemsSelectionModel = tablaItems.getSelectionModel();
        OrdenDeCompra ordenDeCompra = selectionModel.getSelectedItem();
        Item item = itemsSelectionModel.getSelectedItem();

        // Verificar si hay algún elemento seleccionado
        if (ordenDeCompra != null) {
            if (item != null) {
                selectionModel.getSelectedItem().getItems().remove(itemsSelectionModel.getSelectedItem());

                // Crear la lista observable y agregar los objetos OrdenDeCompra
                tablaOrdenes.getItems().clear();
                ObservableList<OrdenDeCompra> listaOrdenesDeCompra = FXCollections.observableArrayList();
                List<OrdenDeCompra> listaOrdenesCompraBase = this.ecenariosController.getProyectoSeleccionado().getOrdenDeCompras();
                listaOrdenesDeCompra.addAll(listaOrdenesCompraBase);
                tablaOrdenes.setItems(listaOrdenesDeCompra);
                tablaOrdenes.getSelectionModel().select(listaOrdenesCompraBase.indexOf(ordenDeCompra));
                tablaOrdenes.refresh();

                mostrarItems(ordenDeCompra);
                tablaItems.refresh();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en selección de item");
                alert.setHeaderText("item no seleccionado");
                alert.setContentText("Debes seleccionar un item de la lista para continuar.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de OrdenDeCompra");
            alert.setHeaderText("OrdenDeCompra no seleccionado");
            alert.setContentText("Debes seleccionar un OrdenDeCompra de la lista para continuar.");
            alert.showAndWait();
        }
    }

    public void crearOrdenDeCompra(ActionEvent actionEvent) {

        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<OrdenDeCompra> selectionModel = tablaOrdenes.getSelectionModel();
        OrdenDeCompra ordenDeCompra = selectionModel.getSelectedItem();
        List<OrdenDeCompra> listaOrdenesCompraBase = this.ecenariosController.getProyectoSeleccionado().getOrdenDeCompras();

        // Verificar si hay algún elemento seleccionado
        if (ordenDeCompra == null) {
            if(validarCampos()) {

                int ultimoIdOrdenDeCompra = 0;
                if (!listaOrdenesCompraBase.isEmpty()) {
                    OrdenDeCompra ultimaOrdenDeCompra = listaOrdenesCompraBase.get(listaOrdenesCompraBase.size() - 1);
                    ultimoIdOrdenDeCompra = ultimaOrdenDeCompra.getId_orden_compra();
                }
                int nuevoIdOrdenDeCompra = ultimoIdOrdenDeCompra + 1;


                OrdenDeCompra nuevaOrdenDeCompra = new OrdenDeCompra();
                nuevaOrdenDeCompra.setId_orden_compra(nuevoIdOrdenDeCompra);
                nuevaOrdenDeCompra.setFecha(dpFecha.getValue());
                nuevaOrdenDeCompra.setTotal(Double.parseDouble(tfTotal.getText()));
                nuevaOrdenDeCompra.setProveedor(isInProveedores(Integer.parseInt(tfIdProveedor.getText())));
                this.ecenariosController.getProyectoSeleccionado().getOrdenDeCompras().add(nuevaOrdenDeCompra);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Se a creado OrdenDeCompra");
                alert.setHeaderText("Con exito");
                alert.showAndWait();

                this.ecenariosController.cargarOrdenDeCompra();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de OrdenDeCompra");
            alert.setHeaderText("OrdenDeCompra seleccionado");
            alert.setContentText("No puedes crear una OrdenDeCompra que ya existe, Tal vez quisieras editarla");
            alert.showAndWait();
        }
    }

    private boolean validarCampos() {
        if(dpFecha.getValue() == null || dpFecha.getValue().isBefore(LocalDate.now())) {
            // Mostrar mensaje de error o alerta indicando que el campo fecha es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo fecha");
            alert.setHeaderText("El campo esta vacio o fecha menor a hoy");
            alert.setContentText("Debes colocar una fecha valida para continuar.");
            alert.showAndWait();
            return false;
        }
        if(tfTotal.getText().isEmpty()) {
            // Mostrar mensaje de error o alerta indicando que el campo total es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo total");
            alert.setHeaderText("El campo esta vacio");
            alert.setContentText("Debes colocar un valor para continuar.");
            alert.showAndWait();
            return false;
        }
        
        if(tfIdProveedor.getText().isEmpty() || isInProveedores(Integer.parseInt(tfIdProveedor.getText())) == null) {
            // Mostrar mensaje de error o alerta indicando que el campo idProveedor es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo id proveedor");
            alert.setHeaderText("El campo esta vacio o el proveedor no existe");
            alert.setContentText("Debes colocar un valor valido para continuar.");
            alert.showAndWait();
            return false;
        }
        // Validar los campos de la tabla, si es necesario
        return true;
    }

    private Proveedor isInProveedores(int idProveedor) {
        List<Proveedor> proveedors = ecenariosController.getPrincipal().getProveedores();
        for (Proveedor proveedor : proveedors) {
            if(proveedor.getId_proveedor() == idProveedor){
                return proveedor;
            }
        }
        return null;
    }

    public void editarOrdenDeCompra(ActionEvent actionEvent) {
        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<OrdenDeCompra> selectionModel = tablaOrdenes.getSelectionModel();
        OrdenDeCompra ordenDeCompra = selectionModel.getSelectedItem();
        List<OrdenDeCompra> listaOrdenesCompraBase = this.ecenariosController.getProyectoSeleccionado().getOrdenDeCompras();

        // Verificar si hay algún elemento seleccionado
        if (ordenDeCompra != null) {
            if(validarCampos()) {

                ordenDeCompra.setFecha(dpFecha.getValue());
                ordenDeCompra.setTotal(Double.parseDouble(tfTotal.getText()));
                ordenDeCompra.setProveedor(isInProveedores(Integer.parseInt(tfIdProveedor.getText())));

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Se a editado OrdenDeCompra");
                alert.setHeaderText("Con exito");
                alert.showAndWait();

                this.ecenariosController.cargarOrdenDeCompra();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de OrdenDeCompra");
            alert.setHeaderText("OrdenDeCompra no seleccionado");
            alert.setContentText("Debes seleccionar un OrdenDeCompra de la lista para continuar.");
            alert.showAndWait();
        }
    }

    public void eliminarOrdenDeCompra(ActionEvent actionEvent) {

        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<OrdenDeCompra> selectionModel = tablaOrdenes.getSelectionModel();
        OrdenDeCompra ordenDeCompra = selectionModel.getSelectedItem();
        List<OrdenDeCompra> listaOrdenesCompraBase = this.ecenariosController.getProyectoSeleccionado().getOrdenDeCompras();

        // Verificar si hay algún elemento seleccionado
        if (ordenDeCompra != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar ordenDeCompra");
            alert.setHeaderText("¿Seguro que desea eliminar la ordenDeCompra?");
            alert.setContentText("Presione OK para continuar o Cancelar para salir.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                this.ecenariosController.getProyectoSeleccionado().getOrdenDeCompras().remove(ordenDeCompra);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Se a eliminado la OrdenDeCompra");
                alert2.setHeaderText("Con exito");
                alert2.showAndWait();
                this.ecenariosController.cargarOrdenDeCompra();
            } else {
                // Hacer otra cosa si el usuario presiona "Cancelar"
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de OrdenDeCompra");
            alert.setHeaderText("OrdenDeCompra no seleccionado");
            alert.setContentText("Debes seleccionar un OrdenDeCompra de la lista para continuar.");
            alert.showAndWait();
        }

    }

    public void volver(ActionEvent actionEvent) {
        ecenariosController.setOrdenDeCompraSeleccionada(null);
        ecenariosController.cargarDashboard();
    }

    public void limpiarPantalla(ActionEvent actionEvent) {
        ecenariosController.setOrdenDeCompraSeleccionada(null);
        ecenariosController.setItemSeleccionado(null);
        tablaOrdenes.getSelectionModel().clearSelection();
        dpFecha.setValue(null); // limpia la fecha
        tfTotal.setText(""); // limpia el total
        tfIdProveedor.setText(""); // limpia el ID del proveedor
        tablaItems.getItems().clear(); // limpia la tabla de items
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Se a limpiado la pantalla");
        alert2.setHeaderText("Con exito");
        alert2.showAndWait();
    }
}
