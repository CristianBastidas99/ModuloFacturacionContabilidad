package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Servicio {

    private int id_servicio;
    private String descripcion;
    private double precio_unitario;
    private Proveedor proveedor;

    public Servicio(int id_servicio, String descripcion, double precio_unitario, Proveedor proveedor) {
        this.id_servicio = id_servicio;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.proveedor = proveedor;
    }
}
