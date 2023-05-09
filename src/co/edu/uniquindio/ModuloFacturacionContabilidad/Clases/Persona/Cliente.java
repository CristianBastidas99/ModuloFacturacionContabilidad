package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Factura;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Notificacion;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cliente {

    private int id_cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    private List<Proyecto> proyectos = new ArrayList();


    public Cliente(int id_cliente, String nombre, String direccion, String telefono, String email, String password) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return new StringJoiner(", ", Cliente.class.getSimpleName() + "[", "]")
                .add("id_cliente=" + id_cliente)
                .add("nombre='" + nombre + "'")
                .add("direccion='" + direccion + "'")
                .add("telefono='" + telefono + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("proyectos=" + proyectos)
                .toString();
    }

    public IntegerProperty idClienteProperty() {
        return new SimpleIntegerProperty(id_cliente);
    }
}
