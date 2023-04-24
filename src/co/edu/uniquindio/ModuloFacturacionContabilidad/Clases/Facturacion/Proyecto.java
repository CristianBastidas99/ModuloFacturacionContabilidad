package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Producto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.Servicio;

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
    private List<OrdenDeCompra> ordenDeCompras = new ArrayList();
    private List<OrdenDeVenta> ordenDeVentas = new ArrayList();

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



}
