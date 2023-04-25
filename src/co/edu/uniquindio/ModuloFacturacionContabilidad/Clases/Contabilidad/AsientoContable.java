package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Transaccion;

import java.time.LocalDate;

public class AsientoContable {

    private int id_asiento_contable;
    private LocalDate fecha;
    private String concepto;
    private double monto;
    private Cuenta cuenta;
    private Transaccion transaccion;



}
