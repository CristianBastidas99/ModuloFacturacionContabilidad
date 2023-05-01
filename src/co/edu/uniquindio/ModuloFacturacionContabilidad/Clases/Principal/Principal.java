package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Principal;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    private List<Proyecto> proyectos = new ArrayList();
    private List<Cliente> clientes = new ArrayList();
    private List<Proveedor> proveedores = new ArrayList();

    public Principal() {
    }

    /**
     * Agrega un nuevo proveedor a la lista de proveedores
     *
     * @param proveedor el proveedor a agregar
     */
    public void agregarProveedor(Proveedor proveedor) throws Exception {
        int ultimoIdProveedor = 0;
        if (!proveedores.isEmpty()) {
            Proveedor ultimoProveedor = proveedores.get(proveedores.size() - 1);
            ultimoIdProveedor = ultimoProveedor.getId_proveedor();
        }
        int nuevoIdProveedor = ultimoIdProveedor + 1;
        proveedor.setId_proveedor(nuevoIdProveedor);
        proveedores.add(proveedor);
    }

    /**
     * Obtiene un proveedor por su ID
     *
     * @param id_proveedor el ID del proveedor a obtener
     * @return el proveedor correspondiente al ID especificado, o null si no se encuentra
     */
    public Proveedor obtenerProveedor(int id_proveedor) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId_proveedor() == id_proveedor) {
                return proveedor;
            }
        }
        return null; // Si no se encuentra el proveedor, devuelve null
    }

    /**
     * Actualiza los datos de un proveedor existente
     *
     * @param proveedorActualizado el proveedor actualizado
     * @return true si se actualizó el proveedor correctamente, false si no se encontró el proveedor
     */
    public boolean actualizarProveedor(Proveedor proveedorActualizado) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId_proveedor() == proveedorActualizado.getId_proveedor()) {
                proveedor.setNombre(proveedorActualizado.getNombre());
                proveedor.setDireccion(proveedorActualizado.getDireccion());
                proveedor.setTelefono(proveedorActualizado.getTelefono());
                proveedor.setEmail(proveedorActualizado.getEmail());
                return true; // Si se encuentra el proveedor y se actualiza, devuelve true
            }
        }
        return false; // Si no se encuentra el proveedor, devuelve false
    }

    /**
     * Elimina un proveedor de la lista de proveedores
     *
     * @param id_proveedor el ID del proveedor a eliminar
     * @return true si se eliminó el proveedor correctamente, false si no se encontró el proveedor
     */
    public boolean eliminarProveedor(int id_proveedor) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId_proveedor() == id_proveedor) {
                proveedores.remove(proveedor);
                return true; // Si se encuentra y elimina el proveedor, devuelve true
            }
        }
        return false; // Si no se encuentra el proveedor, devuelve false
    }

    /**
     * Agrega un nuevo proyecto a la lista de proyectos
     *
     * @param proyecto el proyecto a agregar
     */
    public void agregarProyecto(Proyecto proyecto) throws Exception {
        int ultimoIdProyecto = 0;
        if (!proyectos.isEmpty()) {
            Proyecto ultimoProyecto = proyectos.get(proyectos.size() - 1);
            ultimoIdProyecto = ultimoProyecto.getId_proyecto();
        }
        int nuevoIdProyecto = ultimoIdProyecto + 1;
        proyecto.setId_proyecto(nuevoIdProyecto);
        proyectos.add(proyecto);
    }

    /**
     * Obtiene un proyecto por su ID
     *
     * @param id_proyecto el ID del proyecto a obtener
     * @return el proyecto correspondiente al ID especificado, o null si no se encuentra
     */
    public Proyecto obtenerProyecto(int id_proyecto) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getId_proyecto() == id_proyecto) {
                return proyecto;
            }
        }
        return null; // Si no se encuentra el proyecto, devuelve null
    }

    /**
     * Actualiza los datos de un proyecto existente
     *
     * @param proyectoActualizado el proyecto actualizado
     * @return true si se actualizó el proyecto correctamente, false si no se encontró el proyecto
     */
    public boolean actualizarProyecto(Proyecto proyectoActualizado) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getId_proyecto() == proyectoActualizado.getId_proyecto()) {
                proyecto.setNombre(proyectoActualizado.getNombre());
                proyecto.setFecha_inicio(proyectoActualizado.getFecha_inicio());
                proyecto.setFecha_fin_estimada(proyectoActualizado.getFecha_fin_estimada());
                proyecto.setFecha_fin_real(proyectoActualizado.getFecha_fin_real());
                proyecto.setEstado(proyectoActualizado.getEstado());
                proyecto.setPresupuesto(proyectoActualizado.getPresupuesto());
                return true; // Si se encuentra el proyecto y se actualiza, devuelve true
            }
        }
        return false; // Si no se encuentra el proyecto, devuelve false
    }

    /**
     * Elimina un proyecto de la lista de proyectos
     *
     * @param id_proyecto el ID del proyecto a eliminar
     * @return true si se eliminó el proyecto correctamente, false si no se encontró el proyecto
     */
    public boolean eliminarProyecto(int id_proyecto) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getId_proyecto() == id_proyecto) {
                proyectos.remove(proyecto);
                return true; // Si se encuentra y elimina el proyecto, devuelve true
            }
        }
        return false; // Si no se encuentra el proyecto, devuelve false
    }

}
