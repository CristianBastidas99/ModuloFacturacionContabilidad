package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Item;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.TipoItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

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

        // Asignar un listener a la tabla de órdenes de compra para actualizar el formulario de factura
        tablaOrdenes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarFactura(newValue));

    }

    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub

        this.ecenariosController = ecenariosController;

        // Crear la lista observable y agregar los objetos OrdenDeCompra
        tablaOrdenes.getItems().clear();
        ObservableList<OrdenDeCompra> listaOrdenesDeCompra = FXCollections.observableArrayList();
        listaOrdenesDeCompra.addAll(this.ecenariosController.getProyectoSeleccionado().getOrdenDeCompras());
        tablaOrdenes.setItems(listaOrdenesDeCompra);

        OrdenDeCompra ordenDeCompra = this.ecenariosController.getOrdenDeCompraSeleccionada();
        if(ordenDeCompra != null){
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

    private void mostrarFactura(OrdenDeCompra ordenDeCompra) {
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
        if (selectionModel.getSelectedItem() == null) {

        } else {
            // Obtener el índice del elemento seleccionado
            ecenariosController.setOrdenDeCompraSeleccionada(selectionModel.getSelectedItem());
            ecenariosController.setProveedorSeleccionado(selectionModel.getSelectedItem().getProveedor());
            ecenariosController.cargarSeleccionarItem();
        }
    }

    public void quitarItem(ActionEvent actionEvent) {
    }

    public void crearFactura(ActionEvent actionEvent) {
    }

    public void editarFactura(ActionEvent actionEvent) {
    }

    public void eliminarFactura(ActionEvent actionEvent) {
    }

    public void volver(ActionEvent actionEvent) {
        ecenariosController.setOrdenDeCompraSeleccionada(null);
        ecenariosController.cargarDashboard();
    }

    public void limpiarPabtalla(ActionEvent actionEvent) {
        ecenariosController.setOrdenDeCompraSeleccionada(null);
        ecenariosController.setItemSeleccionado(null);
        dpFecha.setValue(null); // limpia la fecha
        tfTotal.setText(""); // limpia el total
        tfIdProveedor.setText(""); // limpia el ID del proveedor
        tablaItems.getItems().clear(); // limpia la tabla de items
    }
}
