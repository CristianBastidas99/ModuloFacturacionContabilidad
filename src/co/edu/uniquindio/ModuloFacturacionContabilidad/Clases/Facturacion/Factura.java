package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Impuesto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {

    private int id_factura;
    private LocalDate fecha;
    private double total;
    private OrdenDeCompra ordenDeCompra;
    private Pago pago;
    private Proyecto proyecto;
    private Cliente cliente;
    private ArrayList<DetalleFactura>  detalleFacturas = new ArrayList();

    public Factura(int id_factura, LocalDate fecha, double total, OrdenDeCompra ordenDeCompra, Pago pago, Proyecto proyecto, Cliente cliente) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.total = total;
        this.ordenDeCompra = ordenDeCompra;
        this.pago = pago;
        this.proyecto = proyecto;
        this.cliente = cliente;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public OrdenDeCompra getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(ArrayList<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }
}
