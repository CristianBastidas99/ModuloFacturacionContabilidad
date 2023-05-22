package co.edu.uniquindio.ModuloFacturacionContabilidad.Controlador;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    // Menubar items
    @FXML private MenuItem menuItemCliente;
    @FXML private MenuItem menuItemProveedor;
    @FXML private MenuItem menuItemRegistroContable;
    @FXML private MenuItem menuItemCuenta;
    @FXML private MenuItem menuItemImpuesto;
    @FXML private MenuItem menuItemAsientoContable;
    @FXML private MenuItem menuItemLibroDiario;
    @FXML private MenuItem menuItemLibroMayor;
    @FXML private MenuItem menuItemOrdenDeCompra;
    @FXML private MenuItem menuItemFactura;
    @FXML private MenuItem menuItemDetalleFactura;
    @FXML private MenuItem menuItemPago;
    @FXML private MenuItem menuItemTransaccion;
    @FXML private MenuItem menuItemProducto;
    @FXML private MenuItem menuItemServicio;
    @FXML private MenuItem menuItemInventario;

    // Project info
    @FXML private Label nombreLabel;
    @FXML private Label fechaInicioLabel;
    @FXML private Label fechaFinEstimadaLabel;
    @FXML private Label fechaFinRealLabel;
    @FXML private Label estadoLabel;
    @FXML private Label presupuestoLabel;

    // Chart
    @FXML private LineChart<String, Number> lineChart;

    // Client info
    @FXML private Label userLabel;

    // Controller properties
    private Proyecto proyecto;
    private EcenariosController ecenariosController;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.lineChart.getData().clear();

    }

    public void init(EcenariosController ecenariosController) {
        // TODO Auto-generated method stub

        this.ecenariosController = ecenariosController;
        this.proyecto = ecenariosController.getProyectoSeleccionado();

        if(this.proyecto != null) {
            // Carga la información general del proyecto
            cargarInformacionGeneralProyecto(this.proyecto);

            // Carga el gráfico de ingresos/gastos/ganancias/pérdidas
            cargarGrafico(this.proyecto);
        }

        userLabel.setText("Usuario: " + ecenariosController.getClienteSesion().getNombre());
    }

    private void cargarInformacionGeneralProyecto(Proyecto proyecto) {
        // Lógica para cargar la información general del proyecto
        nombreLabel.setText(proyecto.getNombre());
        fechaInicioLabel.setText(proyecto.getFecha_inicio().toString());
        fechaFinEstimadaLabel.setText(proyecto.getFecha_fin_estimada().toString());
        fechaFinRealLabel.setText(proyecto.getFecha_fin_real() != null ? proyecto.getFecha_fin_real().toString() : "");
        estadoLabel.setText(proyecto.getEstado());
        presupuestoLabel.setText(String.format("%.2f", proyecto.getPresupuesto()));
    }

    private void cargarGrafico(Proyecto proyecto) {
        // Lógica para cargar el gráfico de ingresos/gastos/ganancias/pérdidas
        double presupuesto = proyecto.getPresupuesto();
        double ingresos = 0.8 * presupuesto;
        double gastos = 0.6 * presupuesto;
        double ganancias = ingresos - gastos;
        double perdidas = 0.0;

        // Crear las series de datos
        XYChart.Series<String, Number> seriesIngresos = new XYChart.Series<>();
        seriesIngresos.setName("Ingresos");
        seriesIngresos.getData().add(new XYChart.Data<>("", ingresos));

        XYChart.Series<String, Number> seriesGastos = new XYChart.Series<>();
        seriesGastos.setName("Gastos");
        seriesGastos.getData().add(new XYChart.Data<>("", gastos));

        XYChart.Series<String, Number> seriesGanancias = new XYChart.Series<>();
        seriesGanancias.setName("Ganancias");
        seriesGanancias.getData().add(new XYChart.Data<>("", ganancias));

        XYChart.Series<String, Number> seriesPerdidas = new XYChart.Series<>();
        seriesPerdidas.setName("Pérdidas");
        seriesPerdidas.getData().add(new XYChart.Data<>("", perdidas));

        // Agregar las series de datos al gráfico
        lineChart.getData().addAll(seriesIngresos, seriesGastos, seriesGanancias, seriesPerdidas);
    }

    public void handleCliente(ActionEvent actionEvent) {
    }

    public void handleProveedor(ActionEvent actionEvent) {
    }

    public void handleRegistroContable(ActionEvent actionEvent) {
    }

    public void handleCuenta(ActionEvent actionEvent) {
    }

    public void handleImpuesto(ActionEvent actionEvent) {
    }

    public void handleAsientoContable(ActionEvent actionEvent) {
    }

    public void handleLibroDiario(ActionEvent actionEvent) {
    }

    public void handleLibroMayor(ActionEvent actionEvent) {
    }

    public void handleOrdenDeCompra(ActionEvent actionEvent) {
        ecenariosController.cargarOrdenDeCompra();
    }

    public void handleFactura(ActionEvent actionEvent) {
        ecenariosController.cargarFactura();
    }

    public void handlePago(ActionEvent actionEvent) {
        ecenariosController.cargarPago();
    }

    public void handleTransaccion(ActionEvent actionEvent) {
    }

    public void handleInventario(ActionEvent actionEvent) {
    }

    public void handleCerrarSesion(ActionEvent actionEvent) {
        ecenariosController.setClienteSesion(null);
        ecenariosController.setProyectoSeleccionado(null);
        ecenariosController.cargarLogin();
    }

    public void handleItem(ActionEvent actionEvent) {
    }

    public void handleCambiarProyecto(ActionEvent actionEvent) {
    }
}
