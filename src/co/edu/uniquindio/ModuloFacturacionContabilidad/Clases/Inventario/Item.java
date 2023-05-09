package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {

    private int id;
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private TipoItem tipo;
    private Proveedor proveedor;

    public Item(int id, String nombre, String descripcion, double precioUnitario, Proveedor proveedor, TipoItem tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.proveedor = proveedor;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public StringProperty toStringProperty(){
        return new SimpleStringProperty(id + "(" + nombre + ", " + tipo.name() + ")");
    }
}
