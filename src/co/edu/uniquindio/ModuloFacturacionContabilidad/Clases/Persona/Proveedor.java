package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.StringJoiner;

public class Proveedor {

    private int id_proveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    public Proveedor(int id_proveedor, String nombre, String direccion, String telefono, String email) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Proveedor.class.getSimpleName() + "[", "]")
                .add("id_proveedor=" + id_proveedor)
                .add("nombre='" + nombre + "'")
                .add("direccion='" + direccion + "'")
                .add("telefono='" + telefono + "'")
                .add("email='" + email + "'")
                .toString();
    }

    public IntegerProperty idProveedorProperty() {
        return new SimpleIntegerProperty(id_proveedor);
    }
}
