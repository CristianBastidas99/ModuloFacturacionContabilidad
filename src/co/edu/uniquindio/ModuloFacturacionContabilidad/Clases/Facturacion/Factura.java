package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;

import java.time.LocalDate;

public class Factura {

    private int id_factura;
    private LocalDate fecha;
    private double total;
    private OrdenDeVenta ordenDeVenta;
    private Pago pago;

    public Factura(int id_factura, LocalDate fecha, double total, OrdenDeVenta ordenDeVenta, Pago pago) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.total = total;
        this.ordenDeVenta = ordenDeVenta;
        this.pago = pago;
    }
}
