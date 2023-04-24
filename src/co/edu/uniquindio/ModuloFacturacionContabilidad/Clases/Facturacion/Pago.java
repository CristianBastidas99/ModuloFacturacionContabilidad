package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Transaccion;

import java.time.LocalDate;

public class Pago {

    private int id_pago;
    private LocalDate fecha;
    private double monto;
    private MetodoPago metodoPago;
    private Factura factura;
    private Transaccion transaccion;

    public Pago(int id_pago, LocalDate fecha, double monto, MetodoPago metodoPago, Factura factura, Transaccion transaccion) {
        this.id_pago = id_pago;
        this.fecha = fecha;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.factura = factura;
        this.transaccion = transaccion;
    }
}
