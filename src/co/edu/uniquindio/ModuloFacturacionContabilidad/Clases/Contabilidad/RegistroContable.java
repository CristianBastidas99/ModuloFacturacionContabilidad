package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Transaccion;

import java.time.LocalDate;

public class RegistroContable {

    private int id_registro_contable;
    private String descripcion;
    private LocalDate fecha;
    private TipoRegistroContable tipoRegistroContable;
    private Proyecto proyecto;
    private Cuenta cuenta;
    private Transaccion transaccion;

    public RegistroContable(int id_registro_contable, String descripcion, LocalDate fecha, TipoRegistroContable tipoRegistroContable, Proyecto proyecto, Cuenta cuenta, Transaccion transaccion) {
        this.id_registro_contable = id_registro_contable;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipoRegistroContable = tipoRegistroContable;
        this.proyecto = proyecto;
        this.cuenta = cuenta;
        this.transaccion = transaccion;
    }
}
