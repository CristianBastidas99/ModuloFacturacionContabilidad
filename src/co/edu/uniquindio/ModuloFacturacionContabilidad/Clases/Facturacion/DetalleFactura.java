package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Impuesto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Item;

public class DetalleFactura {

    private int idDetalleFactura;
    private double cantidad;
    private Item item;
    private Impuesto impuesto;

    public DetalleFactura(int idDetalleFactura, double cantidad, Item item, Impuesto impuesto) {
        this.idDetalleFactura = idDetalleFactura;
        this.cantidad = cantidad;
        this.item = item;
        this.impuesto = impuesto;
    }

    public double calcularSubtotal() {
        return cantidad * item.getPrecioUnitario();
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
}
