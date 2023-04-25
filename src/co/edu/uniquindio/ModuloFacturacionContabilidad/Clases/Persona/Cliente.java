package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Factura;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int id_cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private List<Proyecto> proyectos = new ArrayList();

    public Cliente(int id_cliente, String nombre, String direccion, String telefono, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
}
