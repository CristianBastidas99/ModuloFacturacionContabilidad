package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.RegistroContable;

import java.time.LocalDate;

public class Transaccion {

    private int id_transaccion;
    private LocalDate fecha;
    private double monto;
    private RegistroContable registroContable;

    public Transaccion(int id_transaccion, LocalDate fecha, double monto, RegistroContable registroContable) {
        this.id_transaccion = id_transaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.registroContable = registroContable;
    }
}
