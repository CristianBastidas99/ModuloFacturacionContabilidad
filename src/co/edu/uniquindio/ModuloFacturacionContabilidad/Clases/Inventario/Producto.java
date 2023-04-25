package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private int id_producto;
    private String descripcion;
    private double precio_unitario;
    private int existencias;
    private List<Proveedor> proveedores = new ArrayList();
    private List<OrdenDeCompra> ordenDeCompras = new ArrayList();
    private List<OrdenDeVenta> ordenDeVentas = new ArrayList();

    public Producto(int id_producto, String descripcion, double precio_unitario, int existencias) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        if (precio_unitario < 0) {
            throw new IllegalArgumentException("El precio unitario debe ser un número positivo.");
        }
        this.precio_unitario = precio_unitario;
        if (existencias < 0) {
            throw new IllegalArgumentException("Las existencias no pueden ser negativas.");
        }
        this.existencias = existencias;
    }

    public int getIdProducto() {
        return id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precio_unitario;
    }

    public int getExistencias() {
        return existencias;
    }

    public void actualizarProducto(String descripcion, double precio_unitario, int existencias) {
        this.descripcion = descripcion;
        if (precio_unitario < 0) {
            throw new IllegalArgumentException("El precio unitario debe ser un número positivo.");
        }
        this.precio_unitario = precio_unitario;
        if (existencias < 0) {
            throw new IllegalArgumentException("Las existencias no pueden ser negativas.");
        }
        this.existencias = existencias;
    }

    public void eliminarProducto() {
        // Código para eliminar el producto
    }

    public static Producto obtenerProductoPorId(int id_producto) {
        // Código para obtener el producto por su id
        return null;
    }

    public static List<Producto> obtenerProductosPorProveedor(Proveedor proveedor) {
        // Código para obtener los productos de un proveedor
        return null;
    }


}
