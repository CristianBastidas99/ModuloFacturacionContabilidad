package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {

    private int id_inventario;
    private String nombre;
    private double valorTotal;
    private LocalDate fechaActualizacion;
    private List<Item> items = new ArrayList<>();
    private Map<Item, Integer> cantidades = new HashMap<>();

    public Inventario(int id_inventario, String nombre, LocalDate fechaActualizacion) {
        this.id_inventario = id_inventario;
        this.nombre = nombre;
        this.fechaActualizacion = fechaActualizacion;
    }

    public List<String> obtenerNombreItems(){

        ArrayList<String> nombreItems = new ArrayList<>();
        for (Item item: items) {
            nombreItems.add(item.getNombre() + " - " + item.getProveedor().getId_proveedor());
        }
        return nombreItems;
    }

    public List<Item> obtenerNombreItemsPorProveedor(int idProveedor){

        ArrayList<Item> itemsProveedor = new ArrayList<>();
        int idProveedorBuscado;
        for (Item item: items) {
            idProveedorBuscado = item.getProveedor().getId_proveedor();
            if(idProveedorBuscado == idProveedor) {
                itemsProveedor.add(item);
            }
        }
        return itemsProveedor;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<Item, Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(Map<Item, Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public double getValorTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : cantidades.entrySet()) {
            Item item = entry.getKey();
            int cantidad = entry.getValue();
            double precioUnitario = item.getPrecioUnitario();
            total += cantidad * precioUnitario;
        }
        return total;
    }


    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
