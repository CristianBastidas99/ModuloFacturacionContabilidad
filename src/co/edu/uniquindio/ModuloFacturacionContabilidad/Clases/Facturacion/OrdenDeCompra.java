package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Producto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Servicio;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdenDeCompra {

    private int id_orden_compra;
    private LocalDate fecha;
    private double total;
    private Proyecto proyecto;
    private Proveedor proveedor;
    private List<Producto> productos = new ArrayList();
    private List<Servicio> servicios = new ArrayList();

    public OrdenDeCompra(int id_orden_compra, LocalDate fecha, double total, Proyecto proyecto, Proveedor proveedor) {
        this.id_orden_compra = id_orden_compra;
        this.fecha = fecha;
        this.total = total;
        this.proyecto = proyecto;
        this.proveedor = proveedor;
    }
}
