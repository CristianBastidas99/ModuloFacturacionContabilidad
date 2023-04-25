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
    private Proyecto proyecto;

}
