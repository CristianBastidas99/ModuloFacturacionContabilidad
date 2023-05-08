package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;

import java.time.LocalDate;

public class Notificacion {

    private String titulo;
    private String mensaje;
    private LocalDate fecha;
    private boolean leida;
    private Proyecto proyecto;

    public Notificacion(String titulo, String mensaje, LocalDate fecha) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.leida = false;
    }

    public Notificacion() { }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void marcarComoLeida() {
        this.leida = true;
    }

    public void marcarComoNoLeida() {
        this.leida = false;
    }

    public boolean isLeida() {
        return leida;
    }
}
