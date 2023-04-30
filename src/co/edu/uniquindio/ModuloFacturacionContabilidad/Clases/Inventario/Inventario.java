package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Inventario {

    private int id_inventario;
    private String nombre;
    private List<Producto> productos;
    private Map<Producto, Integer> cantidades;
    private double valorTotal;
    private LocalDate fechaActualizacion;

    public Inventario(int id_inventario, String nombre, List<Producto> productos, Map<Producto, Integer> cantidades, double valorTotal, LocalDate fechaActualizacion) {
        this.id_inventario = id_inventario;
        this.nombre = nombre;
        this.productos = productos;
        this.cantidades = cantidades;
        this.valorTotal = valorTotal;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Map<Producto, Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(Map<Producto, Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
