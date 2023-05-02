package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Producto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenDeCompra {

    private int id_orden_compra;
    private LocalDate fecha;
    private double total;
    private Proveedor proveedor;
    private List<Object> items = new ArrayList();

    public OrdenDeCompra(int id_orden_compra, LocalDate fecha, double total, Proveedor proveedor) {
        this.id_orden_compra = id_orden_compra;
        this.fecha = fecha;
        this.total = total;
        this.proveedor = proveedor;
    }

    public int getId_orden_compra() {
        return id_orden_compra;
    }

    public void setId_orden_compra(int id_orden_compra) {
        this.id_orden_compra = id_orden_compra;
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }
}
