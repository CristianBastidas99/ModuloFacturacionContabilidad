package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Transaccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibroDiario {

    private int idLibroDiario;
    private LocalDate fecha;
    private List<AsientoContable> asientoContables = new ArrayList();

}
