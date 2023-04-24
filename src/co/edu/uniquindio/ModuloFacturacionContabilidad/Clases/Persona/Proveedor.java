package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.*;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {

    private int id_proveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private List<OrdenDeCompra> ordenDeCompras = new ArrayList();
    private List<Producto> productos = new ArrayList();

    public Proveedor(int id_proveedor, String nombre, String direccion, String telefono, String email) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
}
