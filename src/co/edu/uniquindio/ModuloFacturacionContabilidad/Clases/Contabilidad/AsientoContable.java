package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Transaccion;

import java.time.LocalDate;

public class AsientoContable {

    private int id_asiento_contable;
    private LocalDate fecha;
    private String concepto;
    private double monto;
    private Cuenta cuenta;
    private Transaccion transaccion;

    public AsientoContable(int id_asiento_contable, LocalDate fecha, String concepto, double monto, Cuenta cuenta, Transaccion transaccion) {
        this.id_asiento_contable = id_asiento_contable;
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
        this.cuenta = cuenta;
        this.transaccion = transaccion;
    }

    public int getId_asiento_contable() {
        return id_asiento_contable;
    }

    public void setId_asiento_contable(int id_asiento_contable) {
        this.id_asiento_contable = id_asiento_contable;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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
