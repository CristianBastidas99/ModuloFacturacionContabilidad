package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Producto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Servicio;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenDeVenta {

    private int id_orden_venta;
    private LocalDate fecha;
    private double total;
    private Proyecto proyecto;
    private Cliente cliente;
    private List<Producto> productos = new ArrayList();
    private List<Servicio> servicios = new ArrayList();

    public OrdenDeVenta(int id_orden_venta, LocalDate fecha, double total, Proyecto proyecto, Cliente cliente) {
        this.id_orden_venta = id_orden_venta;
        this.fecha = fecha;
        this.total = total;
        this.proyecto = proyecto;
        this.cliente = cliente;
    }
}
