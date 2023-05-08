package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Impuesto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.LibroDiario;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.LibroMayor;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Inventario;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Item;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Notificacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Proyecto {

    private int id_proyecto;
    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin_estimada;
    private LocalDate fecha_fin_real;
    private String estado;
    private double presupuesto;
    private Inventario inventario;
    private List<Cliente> clientes = new ArrayList();
    private List<OrdenDeCompra> ordenDeCompras = new ArrayList();
    private List<Factura> facturas = new ArrayList();
    private List<LibroMayor> libroMayorList = new ArrayList();
    private List<LibroDiario> libroDiarioList = new ArrayList();
    private List<Impuesto> impuestos= new ArrayList<>();
    private List<Notificacion> notificaciones = new ArrayList();

    public Proyecto(int id_proyecto, String nombre, LocalDate fecha_inicio, LocalDate fecha_fin_estimada,
                    LocalDate fecha_fin_real, String estado, double presupuesto) {
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin_estimada = fecha_fin_estimada;
        this.fecha_fin_real = fecha_fin_real;
        this.estado = estado;
        this.presupuesto = presupuesto;
    }

    public List<String> obtenerNombreImpuestos(){

        ArrayList<String> nombreImpuesto = new ArrayList<>();
        for (Impuesto impuesto: impuestos) {
            nombreImpuesto.add(impuesto.getNombre() + " - %" + impuesto.getPorcentaje());
        }
        return nombreImpuesto;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin_estimada() {
        return fecha_fin_estimada;
    }

    public void setFecha_fin_estimada(LocalDate fecha_fin_estimada) {
        this.fecha_fin_estimada = fecha_fin_estimada;
    }

    public LocalDate getFecha_fin_real() {
        return fecha_fin_real;
    }

    public void setFecha_fin_real(LocalDate fecha_fin_real) {
        this.fecha_fin_real = fecha_fin_real;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<OrdenDeCompra> getOrdenDeCompras() {
        return ordenDeCompras;
    }

    public void setOrdenDeCompras(List<OrdenDeCompra> ordenDeCompras) {
        this.ordenDeCompras = ordenDeCompras;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<LibroMayor> getLibroMayorList() {
        return libroMayorList;
    }

    public void setLibroMayorList(List<LibroMayor> libroMayorList) {
        this.libroMayorList = libroMayorList;
    }

    public List<LibroDiario> getLibroDiarioList() {
        return libroDiarioList;
    }

    public void setLibroDiarioList(List<LibroDiario> libroDiarioList) {
        this.libroDiarioList = libroDiarioList;
    }


    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Proyecto.class.getSimpleName() + "[", "]")
                .add("id_proyecto=" + id_proyecto)
                .add("nombre='" + nombre + "'")
                .add("fecha_inicio=" + fecha_inicio)
                .add("fecha_fin_estimada=" + fecha_fin_estimada)
                .add("fecha_fin_real=" + fecha_fin_real)
                .add("estado='" + estado + "'")
                .add("presupuesto=" + presupuesto)
                .add("inventario=" + inventario)
                .toString();
    }
}
