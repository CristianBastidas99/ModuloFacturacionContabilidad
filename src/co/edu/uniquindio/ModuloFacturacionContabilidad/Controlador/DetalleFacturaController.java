package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DetalleFacturaController implements Initializable {

    @FXML private TextField cantidadTextField;
    @FXML private ComboBox<String> itemComboBox;
    @FXML private ComboBox<String> impuestoComboBox;

    private EcenariosController ecenariosController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemComboBox.getItems().clear();
        impuestoComboBox.getItems().clear();
    }

    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub
        this.ecenariosController = ecenariosController;

        // Inicializa los ComboBox con los valores correspondientes
        List<String> items = this.ecenariosController.getProyectoSeleccionado().getInventario().obtenerNombreItems();
        itemComboBox.setItems(FXCollections.observableList(items));

        List<String> impuestos = this.ecenariosController.getProyectoSeleccionado().obtenerNombreImpuestos();
        impuestoComboBox.setItems(FXCollections.observableList(impuestos));
    }
}
