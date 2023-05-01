package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Proveedor {

    private int id_proveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private List<Producto> productos = new ArrayList();

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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Proveedor proveedor = (Proveedor) o;

        if (getId_proveedor() != proveedor.getId_proveedor()) return false;
        if (!getNombre().equals(proveedor.getNombre())) return false;
        if (!getDireccion().equals(proveedor.getDireccion())) return false;
        if (!getTelefono().equals(proveedor.getTelefono())) return false;
        if (!getEmail().equals(proveedor.getEmail())) return false;
        return getProductos() != null ? getProductos().equals(proveedor.getProductos()) : proveedor.getProductos() == null;
    }

    @Override
    public int hashCode() {
        int result = getId_proveedor();
        result = 31 * result + getNombre().hashCode();
        result = 31 * result + getDireccion().hashCode();
        result = 31 * result + getTelefono().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + (getProductos() != null ? getProductos().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Proveedor.class.getSimpleName() + "[", "]")
                .add("id_proveedor=" + id_proveedor)
                .add("nombre='" + nombre + "'")
                .add("direccion='" + direccion + "'")
                .add("telefono='" + telefono + "'")
                .add("email='" + email + "'")
                .add("productos=" + productos)
                .toString();
    }
}
