package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Transaccion;

import java.time.LocalDate;

public class Pago {

    private int id_pago;
    private LocalDate fecha;
    private double monto;
    private String estado;
    private boolean autorizacion;
    private MetodoPago metodoPago;
    private Factura factura;
    private Transaccion transaccion;

    public Pago(int id_pago, LocalDate fecha, double monto, String estado, boolean autorizacion, MetodoPago metodoPago, Factura factura, Transaccion transaccion) {
        this.id_pago = id_pago;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
        this.autorizacion = autorizacion;
        this.metodoPago = metodoPago;
        this.factura = factura;
        this.transaccion = transaccion;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
}
