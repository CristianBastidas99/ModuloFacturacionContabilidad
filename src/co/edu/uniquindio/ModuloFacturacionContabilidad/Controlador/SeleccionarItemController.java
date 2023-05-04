package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SeleccionarItemController implements Initializable {

    @FXML private AnchorPane root;
    @FXML private TableView<Item> tablaItems;
    @FXML private TableColumn<Item, Integer> colIdItem;
    @FXML private TableColumn<Item, TipoItem> colTipo;
    @FXML private TableColumn<Item, String> colNombre;
    @FXML private TableColumn<Item, String> colDescripcion;
    @FXML private TableColumn<Item, Double> colCostoUnitario;
    @FXML private Button btnAgregar;
    @FXML private Button btnVolver;

    // Controller properties
    private EcenariosController ecenariosController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializar las columnas de la tabla
        colIdItem.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colCostoUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
    }

    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub

        this.ecenariosController = ecenariosController;

        // Crear la lista observable y agregar los objetos OrdenDeCompra
        tablaItems.getItems().clear();
        ObservableList<Item> listaItems = FXCollections.observableArrayList();
        Proveedor proveedor = this.ecenariosController.getProveedorSeleccionado();
        listaItems.addAll(this.ecenariosController.getProyectoSeleccionado().getInventario().obtenerNombreItemsPorProveedor(proveedor.getId_proveedor()));
        tablaItems.setItems(listaItems);

    }

    public void handleAgregar(ActionEvent actionEvent) {
        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<Item> selectionModel = tablaItems.getSelectionModel();
        // Verificar si hay algún elemento seleccionado
        if (selectionModel.getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de item");
            alert.setHeaderText("Item no seleccionado");
            alert.setContentText("Debes seleccionar un item de la lista para continuar.");
            alert.showAndWait();
        } else {
            // Obtener el índice del elemento seleccionado
            if(!estaEnInventario(selectionModel.getSelectedItem())) {
                ecenariosController.getOrdenDeCompraSeleccionada().getItems().add(selectionModel.getSelectedItem());
                ecenariosController.cargarOrdenDeCompra();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en selección de item");
                alert.setHeaderText("Item seleccionado ya exite en OrdenDeCompra");
                alert.setContentText("Debes seleccionar un item diferente de la lista para continuar o volver.");
                alert.showAndWait();
            }
        }
    }

    public boolean estaEnInventario(Item item) {
        for (Item i : ecenariosController.getOrdenDeCompraSeleccionada().getItems()) {
            if (i.getId() == item.getId()) {
                return true;
            }
        }
        return false;
    }

    public void handleVolver(ActionEvent actionEvent) {
        ecenariosController.cargarOrdenDeCompra();
    }
}
