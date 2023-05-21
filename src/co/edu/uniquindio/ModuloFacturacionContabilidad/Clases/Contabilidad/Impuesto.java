package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Alert;

public class Impuesto {

    private int id_impuesto;
    private String nombre;
    private double porcentaje;

    public Impuesto(int id_impuesto, String nombre, double porcentaje) {
        this.id_impuesto = id_impuesto;
        this.nombre = nombre;
        setPorcentaje(porcentaje);
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
        if(porcentaje <= 1 && porcentaje >= 0) {
            this.porcentaje = porcentaje;
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al asignar porsentaje");
            alert.setHeaderText("Valor de porcentaje Invalido");
            alert.setContentText("Debes colocar un valor de porcentaje entre 0 y 1 para continuar.");
            alert.showAndWait();
            try {
                throw new Exception("Valor de porcentaje invalido");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public DoubleProperty porcentajeProperty(){
        return new SimpleDoubleProperty(porcentaje*100);
    }
}
