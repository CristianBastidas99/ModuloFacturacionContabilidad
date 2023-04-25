package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion;

import java.time.LocalDate;

public class DetalleFactura {

    private int idDetalleFactura;
    private double Cantidad;
    private double PrecioUnitario;
    private Factura factura;

    public DetalleFactura(int idDetalleFactura, double cantidad, double precioUnitario, Factura factura) {
        this.idDetalleFactura = idDetalleFactura;
        Cantidad = cantidad;
        PrecioUnitario = precioUnitario;
        this.factura = factura;
    }
}
