package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeVenta;

import java.util.ArrayList;
import java.util.List;

public class Servicio {

    private int id_servicio;
    private String descripcion;
    private double precio_unitario;
    private List<DetalleFactura> detalleFacturas = new ArrayList();
    private List<OrdenDeCompra> ordenDeCompras = new ArrayList();
    private List<OrdenDeVenta> ordenDeVentas = new ArrayList();

    public Servicio(int id_servicio, String descripcion, double precio_unitario) {
        this.id_servicio = id_servicio;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    // Métodos relevantes para la clase
    public void crearServicio() {
        // Lógica para crear un servicio
    }

    public void actualizarServicio() {
        // Lógica para actualizar un servicio
    }

    public void eliminarServicio() {
        // Lógica para eliminar un servicio
    }

    public Servicio obtenerServicioPorId(int id_servicio) {
        // Lógica para obtener un servicio por su id
        return null;
    }

    public List<Servicio> obtenerServiciosPorProveedor(Proveedor proveedor) {
        // Lógica para obtener todos los servicios de un proveedor
        return null;
    }


}
