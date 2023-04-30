package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibroMayor {

    private int idLibroMayor;
    private String Descripcion;
    private LocalDate fecha;
    private List<Cuenta> cuentas = new ArrayList();
    //saldoInicial (decimal), saldoFinal (decimal)


    public LibroMayor(int idLibroMayor, String descripcion, LocalDate fecha) {
        this.idLibroMayor = idLibroMayor;
        Descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getIdLibroMayor() {
        return idLibroMayor;
    }

    public void setIdLibroMayor(int idLibroMayor) {
        this.idLibroMayor = idLibroMayor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
