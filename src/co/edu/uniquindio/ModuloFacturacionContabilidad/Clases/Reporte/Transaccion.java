package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.Cuenta;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.RegistroContable;

import java.time.LocalDate;

public class Transaccion {

    private int id_transaccion;
    private LocalDate fecha;
    private double monto;
    private RegistroContable registroContable;
    private Cuenta cuenta;
    private TipoTransaccion tipoTransaccion;

    public Transaccion(int id_transaccion, LocalDate fecha, double monto, RegistroContable registroContable, Cuenta cuenta, TipoTransaccion tipoTransaccion) {
        this.id_transaccion = id_transaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.registroContable = registroContable;
        this.cuenta = cuenta;
        this.tipoTransaccion = tipoTransaccion;
    }
}
