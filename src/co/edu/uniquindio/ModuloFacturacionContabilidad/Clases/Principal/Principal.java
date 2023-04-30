package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Principal;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    private List<Proyecto> proyectos = new ArrayList();
    private List<Cliente> clientes = new ArrayList();
    private List<Proveedor> proveedores = new ArrayList();

    public Principal() {
    }
}
