package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Servicio {

    private int id_servicio;
    private String descripcion;
    private double costoPorHora;
    private Proveedor proveedor;

    public Servicio(int id_servicio, String descripcion, double costoPorHora, Proveedor proveedor) {
        this.id_servicio = id_servicio;
        this.descripcion = descripcion;
        this.costoPorHora = costoPorHora;
        this.proveedor = proveedor;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(double costoPorHora) {
        this.costoPorHora = costoPorHora;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
