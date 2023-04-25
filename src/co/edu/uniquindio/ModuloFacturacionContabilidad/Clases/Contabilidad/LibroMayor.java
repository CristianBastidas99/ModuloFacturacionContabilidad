package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibroMayor {

    private int idLibroMayor;
    private String Descripcion;
    private LocalDate fecha;
    private LibroMayor libroMayorAnterior;
    private List<Cuenta> cuentas = new ArrayList();
    //saldoInicial (decimal), saldoFinal (decimal)

}
