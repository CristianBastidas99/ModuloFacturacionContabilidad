package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.Transaccion;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cuenta {

    private int id_cuenta;
    private String nombre;
    private LocalDate fecha;
    private TipoCuenta tipoCuenta;
    private Cliente cliente;
    private ArrayList<AsientoContable> asientoContables = new ArrayList<>();

    public Cuenta(int id_cuenta, String nombre, LocalDate fecha, TipoCuenta tipoCuenta, Cliente cliente) {
        this.id_cuenta = id_cuenta;
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipoCuenta = tipoCuenta;
        this.cliente = cliente;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<AsientoContable> getAsientoContables() {
        return asientoContables;
    }

    public void setAsientoContables(ArrayList<AsientoContable> asientoContables) {
        this.asientoContables = asientoContables;
    }
}
