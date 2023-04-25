package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {

    private int id_factura;
    private LocalDate fecha;
    private double total;
    private OrdenDeCompra ordenDeCompra;
    private Pago pago;
    private ArrayList<DetalleFactura>  detalleFacturas = new ArrayList();

    public Factura(int id_factura, LocalDate fecha, double total, OrdenDeCompra ordenDeCompra, Pago pago) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.total = total;
        this.ordenDeCompra = ordenDeCompra;
        this.pago = pago;
    }
}
