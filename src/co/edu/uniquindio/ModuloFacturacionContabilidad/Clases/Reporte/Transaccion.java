package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Cuenta;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.RegistroContable;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Pago;

import java.time.LocalDate;

public class Transaccion {

    private int id_transaccion;
    private LocalDate fecha;
    private double monto;
    private RegistroContable registroContable;
    private Cuenta cuenta;
    private TipoTransaccion tipoTransaccion;
    private Pago pago;

    public Transaccion(int id_transaccion, LocalDate fecha, double monto, RegistroContable registroContable, Cuenta cuenta, TipoTransaccion tipoTransaccion, Pago pago) {
        this.id_transaccion = id_transaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.registroContable = registroContable;
        this.cuenta = cuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.pago = pago;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public RegistroContable getRegistroContable() {
        return registroContable;
    }

    public void setRegistroContable(RegistroContable registroContable) {
        this.registroContable = registroContable;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
