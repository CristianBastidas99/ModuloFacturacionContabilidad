package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Impuesto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.DetalleFactura;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Factura;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Item;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class DetalleFacturaController implements Initializable {

    @FXML    private TextField cantidadTextField;

    @FXML    private TableView<Item> tablaItems;
    @FXML    private TableColumn<Item, Integer> colIdItem;
    @FXML    private TableColumn<Item, String> colTipo;
    @FXML    private TableColumn<Item, String> colNombre;
    @FXML    private TableColumn<Item, String> colDescripcion;
    @FXML    private TableColumn<Item, Double> colCostoUnitario;

    @FXML    private TableView<Impuesto> tablaImpuestos;
    @FXML    private TableColumn<Impuesto, Integer> colId;
    @FXML    private TableColumn<Impuesto, String> colNombreI;
    @FXML    private TableColumn<Impuesto, Double> colPorcentaje;

    private EcenariosController ecenariosController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Configurar las columnas de la tabla de Items
        colIdItem.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colCostoUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));

        // Configurar las columnas de la tabla de Impuestos
        colId.setCellValueFactory(new PropertyValueFactory<>("id_impuesto"));
        colNombreI.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPorcentaje.setCellValueFactory(new PropertyValueFactory<>("porcentaje"));

        // Configuración del filtro de texto para permitir solo dígitos en el campo de texto "cantidadTextField"
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        };
        // Aplicación del filtro al campo de texto "cantidadTextField"
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        cantidadTextField.setTextFormatter(formatter);


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

        // Crear la lista observable y agregar los objetos OrdenDeCompra
        tablaImpuestos.getItems().clear();
        ObservableList<Impuesto> listaImpuestos = FXCollections.observableArrayList();
        listaImpuestos.addAll(this.ecenariosController.getProyectoSeleccionado().getImpuestos());
        tablaImpuestos.setItems(listaImpuestos);

    }

    @FXML
    void agregarButtonClicked(ActionEvent event) {
        // Obtener el modelo de selección de la ListView
        TableView.TableViewSelectionModel<Item> selectionModelItem = tablaItems.getSelectionModel();
        TableView.TableViewSelectionModel<Impuesto> selectionModelImpuesto = tablaImpuestos.getSelectionModel();
        if(validarCampos()) {
            // Obtener el índice del elemento seleccionado
            if (!estaEnInventario(selectionModelItem.getSelectedItem())) {
                Factura factura = ecenariosController.getFacturaSeleccionada();
                String id = factura.getId_factura() + factura.getDetalleFacturas().size() + "";
                int idDetalleFactura = Integer.parseInt(id);
                DetalleFactura detalleFactura = new DetalleFactura(idDetalleFactura, Double.parseDouble(cantidadTextField.getText()), selectionModelItem.getSelectedItem(), selectionModelImpuesto.getSelectedItem());
                ecenariosController.getFacturaSeleccionada().getDetalleFacturas().add(detalleFactura);
                ecenariosController.cargarFactura();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en selección de item");
                alert.setHeaderText("Item seleccionado ya exite en Factura");
                alert.setContentText("Debes seleccionar un item diferente de la lista para continuar o volver.");
                alert.showAndWait();
            }
        }
    }

    private boolean estaEnInventario(Item item) {
        for (DetalleFactura i : ecenariosController.getFacturaSeleccionada().getDetalleFacturas()) {
            if (i.getItem().getId() == item.getId()) {
                return true;
            }
        }
        return false;
    }

    private boolean validarCampos(){
        if(cantidadTextField.getText().isEmpty()) {
            // Mostrar mensaje de error o alerta indicando que el campo total es obligatorio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error campo cantidad");
            alert.setHeaderText("El campo esta vacio");
            alert.setContentText("Debes colocar un valor para continuar.");
            alert.showAndWait();
            return false;
        }
        TableView.TableViewSelectionModel<Item> selectionModel = tablaItems.getSelectionModel();
        // Verificar si hay algún elemento seleccionado
        if (selectionModel.getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de item");
            alert.setHeaderText("Item no seleccionado");
            alert.setContentText("Debes seleccionar un item de la lista para continuar.");
            alert.showAndWait();
            return false;
        }
        TableView.TableViewSelectionModel<Impuesto> selectionModel2 = tablaImpuestos.getSelectionModel();
        // Verificar si hay algún elemento seleccionado
        if (selectionModel2.getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de Impuesto");
            alert.setHeaderText("Impuesto no seleccionado");
            alert.setContentText("Debes seleccionar un item de la lista para continuar.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    void cancelarButtonClicked(ActionEvent event) {
        // Acción del botón "Cancelar"
        ecenariosController.cargarFactura();
    }

}
