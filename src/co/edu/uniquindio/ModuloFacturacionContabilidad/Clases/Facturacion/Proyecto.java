package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    private int id_proyecto;
    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin_estimada;
    private LocalDate fecha_fin_real;
    private String estado;
    private double presupuesto;
    private List<Producto> productos;
    private List<Servicio> servicios;

    public Proyecto(int id_proyecto, String nombre, LocalDate fecha_inicio, LocalDate fecha_fin_estimada,
                    LocalDate fecha_fin_real, String estado, double presupuesto) {
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin_estimada = fecha_fin_estimada;
        this.fecha_fin_real = fecha_fin_real;
        this.estado = estado;
        this.presupuesto = presupuesto;
        this.productos = new ArrayList<Producto>();
        this.servicios = new ArrayList<Servicio>();
    }

    // Método para agregar un producto al proyecto
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        producto.agregarProyecto(this);
    }

    // Método para agregar un servicio al proyecto
    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
        servicio.agregarProyecto(this);
    }

    // Método para obtener el presupuesto del proyecto
    public double getPresupuesto() {
        return this.presupuesto;
    }

    // Método para actualizar el estado del proyecto
    public void actualizarEstado(String estado) {
        this.estado = estado;
    }

    // Métodos para obtener proyectos por cliente y empleado (no implementados)
    public List<Proyecto> obtenerProyectosPorCliente(Cliente cliente) {
        // Lógica para obtener proyectos por cliente
    }

    public List<Proyecto> obtenerProyectosPorEmpleado(Empleado empleado) {
        // Lógica para obtener proyectos por empleado
    }

    // Métodos para obtener y actualizar proyectos por ID (no implementados)
    public Proyecto obtenerProyectoPorId(int id_proyecto) {
        // Lógica para obtener proyecto por ID
    }

    public void actualizarProyecto(Proyecto proyecto) {
        // Lógica para actualizar proyecto
    }

    // Método para eliminar proyecto (no implementado)
    public void eliminarProyecto() {
        // Lógica para eliminar proyecto
    }

}
