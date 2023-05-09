package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Impuesto {

    private int id_impuesto;
    private String nombre;
    private double porcentaje;

    public Impuesto(int id_impuesto, String nombre, double porcentaje) {
        this.id_impuesto = id_impuesto;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public int getId_impuesto() {
        return id_impuesto;
    }

    public void setId_impuesto(int id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public DoubleProperty porcentajeProperty(){
        return new SimpleDoubleProperty(porcentaje);
    }
}
