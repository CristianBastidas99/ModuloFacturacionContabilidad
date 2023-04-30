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

    public int getId_registro_contable() {
        return id_registro_contable;
    }

    public void setId_registro_contable(int id_registro_contable) {
        this.id_registro_contable = id_registro_contable;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoRegistroContable getTipoRegistroContable() {
        return tipoRegistroContable;
    }

    public void setTipoRegistroContable(TipoRegistroContable tipoRegistroContable) {
        this.tipoRegistroContable = tipoRegistroContable;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
}
