package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Impuesto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Producto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Servicio;

import java.time.LocalDate;

public class DetalleFactura {

    private int idDetalleFactura;
    private double cantidad;
    private Object item;
    private Impuesto impuesto;

    public DetalleFactura(int idDetalleFactura, double cantidad, Impuesto impuesto) {
        this.idDetalleFactura = idDetalleFactura;
        this.cantidad = cantidad;
        this.impuesto = impuesto;
    }

    public double calcularSubtotal() {
        double precioUnitario = 0;
        if (item instanceof Producto) {
            precioUnitario = ((Producto) item).getPrecio_unitario();
        } else if (item instanceof Servicio) {
            precioUnitario = ((Servicio) item).getCostoPorHora();
        }
        return cantidad * precioUnitario;
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
}
