package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.*;

import java.util.ArrayList;

public class Cliente {

    private int id_cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String tipo_pago_preferido;

    // Constructor
    public Cliente(int id_cliente, String nombre, String direccion, String telefono, String email, String tipo_pago_preferido) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tipo_pago_preferido = tipo_pago_preferido;
    }

    // Métodos de acceso a datos
    public void crearCliente() {
        // Lógica para crear un nuevo cliente en la base de datos
    }

    public void actualizarCliente() {
        // Lógica para actualizar los datos de un cliente en la base de datos
    }

    public void eliminarCliente() {
        // Lógica para eliminar un cliente de la base de datos
    }

    public Cliente obtenerClientePorId(int id) {
        // Lógica para obtener los datos de un cliente por su ID
        return null;
    }

    public ArrayList<Cliente> obtenerClientesPorTipoPago(String tipo_pago) {
        // Lógica para obtener una lista de clientes que prefieren un determinado tipo de pago
        return null;
    }

    // Métodos para obtener relaciones
    public ArrayList<Proyecto> obtenerProyectosPorCliente() {
        // Lógica para obtener una lista de proyectos asociados a este cliente
        return null;
    }

    public ArrayList<Factura> obtenerFacturasPorCliente() {
        // Lógica para obtener una lista de facturas asociadas a este cliente
        return null;
    }

    public ArrayList<OrdenDeVenta> obtenerOrdenesDeVentaPorCliente() {
        // Lógica para obtener una lista de órdenes de venta realizadas por este cliente
        return null;
    }

    // Restricciones
    // El ID del cliente debe ser único
    // El tipo de pago preferido debe ser una opción válida

}
