package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Factura;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeVenta;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int id_cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String tipo_pago_preferido;
    private List<Proyecto> proyectos = new ArrayList();
    private List<Factura> facturas = new ArrayList();
    private List<OrdenDeVenta> ordenDeVentas = new ArrayList();

    // Constructor
    public Cliente(int id_cliente, String nombre, String direccion, String telefono, String email, String tipo_pago_preferido) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tipo_pago_preferido = tipo_pago_preferido;
    }

}
