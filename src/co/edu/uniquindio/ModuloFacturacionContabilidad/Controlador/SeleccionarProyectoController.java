package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class SeleccionarProyectoController implements Initializable {

    @FXML private AnchorPane root;
    @FXML private ListView<String> proyectosListView;
    @FXML private Button seleccionarButton;
    @FXML private Button cerrarSesionButton;

    private EcenariosController ecenariosController;
    private List<Proyecto> proyectos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Aquí se podrían cargar los proyectos disponibles en el ListView
        proyectosListView.getItems().clear();
    }

    @FXML
    void seleccionarProyecto() {
        // Obtener el modelo de selección de la ListView
        MultipleSelectionModel<String> selectionModel = proyectosListView.getSelectionModel();
        // Verificar si hay algún elemento seleccionado
        if (selectionModel.getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en selección de proyecto");
            alert.setHeaderText("Proyecto no seleccionado");
            alert.setContentText("Debes seleccionar un proyecto de la lista para continuar.");
            alert.showAndWait();
        } else {
            // Obtener el índice del elemento seleccionado
            int selectedIndex = selectionModel.getSelectedIndex();
            ecenariosController.setProyectoSeleccionado(proyectos.get(selectedIndex));
            ecenariosController.cargarDashboard();
        }
    }

    @FXML
    void cerrarSesion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Está seguro de que desea cerrar sesión?");
        alert.setContentText("Presione Aceptar para cerrar sesión o Cancelar para continuar trabajando.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Se presionó el botón Aceptar, se cierra la sesión
            ecenariosController.setClienteSesion(null);
            ecenariosController.cargarLogin();
        } else {
            // Se presionó el botón Cancelar, no se hace nada
        }
    }

    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub

        this.ecenariosController = ecenariosController;
        this.proyectos = ecenariosController.getClienteSesion().getProyectos();

        for (Proyecto proyecto : proyectos) {
            proyectosListView.getItems().add(proyecto.getNombre());
        }
    }

}
