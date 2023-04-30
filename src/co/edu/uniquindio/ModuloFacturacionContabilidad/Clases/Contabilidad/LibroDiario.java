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

    public LibroDiario(int idLibroDiario, LocalDate fecha) {
        this.idLibroDiario = idLibroDiario;
        this.fecha = fecha;
    }

    public int getIdLibroDiario() {
        return idLibroDiario;
    }

    public void setIdLibroDiario(int idLibroDiario) {
        this.idLibroDiario = idLibroDiario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<AsientoContable> getAsientoContables() {
        return asientoContables;
    }

    public void setAsientoContables(List<AsientoContable> asientoContables) {
        this.asientoContables = asientoContables;
    }
}
