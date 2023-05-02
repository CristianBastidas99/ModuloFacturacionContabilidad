package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Principal;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.OrdenDeCompra;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.Proyecto;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Cliente;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.Proveedor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    private List<Proyecto> proyectos = new ArrayList();
    private List<Cliente> clientes = new ArrayList();
    private List<Proveedor> proveedores = new ArrayList();

    public Principal() {

        // Creamos 3 instancias de Cliente
        Cliente cliente1 = new Cliente(1, "Juan Perez", "Calle Falsa 123", "12345678", "juan.perez@example.com", "contraseña1");
        Cliente cliente2 = new Cliente(2, "María Rodríguez", "Calle Real 456", "23456789", "maria.rodriguez@example.com", "contraseña2");
        Cliente cliente3 = new Cliente(3, "Pedro Gómez", "Avenida Siempreviva 789", "34567890", "pedro.gomez@example.com", "contraseña3");
        Cliente cliente4 = new Cliente(1, "Cristian Bastidas", "Calle 123", "1234567890", "cbastidaso@uqvirtual.edu.co", "password123");
        Cliente cliente5 = new Cliente(2, "Jessica Quintero", "Calle 456", "0987654321", "jyquinterov@uqvirtual.edu.co", "password456");

        // Creamos 3 instancias de Proveedor
        Proveedor proveedor1 = new Proveedor(1, "Proveedor 1", "Calle Proveedor 1", "11111111", "proveedor1@example.com");
        Proveedor proveedor2 = new Proveedor(2, "Proveedor 2", "Calle Proveedor 2", "22222222", "proveedor2@example.com");
        Proveedor proveedor3 = new Proveedor(3, "Proveedor 3", "Calle Proveedor 3", "33333333", "proveedor3@example.com");

        // Creamos 3 instancias de Proyecto, cada una asociada a un cliente y un proveedor
        Proyecto proyecto1 = new Proyecto(1, "Proyecto 1", LocalDate.now(), LocalDate.now().plusMonths(1), null, "en curso", 5000);
        proyecto1.getClientes().add(cliente1);
        proyecto1.getClientes().add(cliente4);
        proyecto1.getClientes().add(cliente5);
        cliente1.getProyectos().add(proyecto1);
        cliente4.getProyectos().add(proyecto1);
        cliente5.getProyectos().add(proyecto1);

        Proyecto proyecto2 = new Proyecto(2, "Proyecto 2", LocalDate.now(), LocalDate.now().plusMonths(2), null, "en curso", 10000);
        proyecto2.getClientes().add(cliente2);
        cliente2.getProyectos().add(proyecto2);

        Proyecto proyecto3 = new Proyecto(3, "Proyecto 3", LocalDate.now(), LocalDate.now().plusMonths(3), null, "en curso", 15000);
        proyecto3.getClientes().add(cliente3);
        cliente3.getProyectos().add(proyecto3);


        // Agregamos los objetos creados a las listas correspondientes
        agregarCliente(cliente1);
        agregarCliente(cliente2);
        agregarCliente(cliente3);
        agregarCliente(cliente4);
        agregarCliente(cliente5);

        agregarProveedor(proveedor1);
        agregarProveedor(proveedor2);
        agregarProveedor(proveedor3);

        agregarProyecto(proyecto1);
        agregarProyecto(proyecto2);
        agregarProyecto(proyecto3);

    }

    /**
     * Agrega un nuevo proveedor a la lista de proveedores
     *
     * @param proveedor el proveedor a agregar
     */
    public void agregarProveedor(Proveedor proveedor) {
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
    public void agregarProyecto(Proyecto proyecto) {
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

    /**
     * Agrega un nuevo cliente a la lista de clientes
     *
     * @param cliente el cliente a agregar
     * @return true si se agrega correctamente, false si el cliente ya existe en la lista
     */
    public boolean agregarCliente(Cliente cliente) {
        // Busca el ID del último cliente agregado
        int ultimoIdCliente = 0;
        if (!clientes.isEmpty()) {
            Cliente ultimoCliente = clientes.get(clientes.size() - 1);
            ultimoIdCliente = ultimoCliente.getId_cliente();
        }
        // Asigna el siguiente ID al nuevo cliente
        int nuevoIdCliente = ultimoIdCliente + 1;
        cliente.setId_cliente(nuevoIdCliente);
        // Verifica que el cliente no exista ya en la lista
        for (Cliente c : clientes) {
            if (c.getId_cliente() == cliente.getId_cliente()) {
                return false; // Si el cliente ya existe, devuelve false
            }
        }
        // Si el cliente no existe, lo agrega a la lista y devuelve true
        String passwordMd5 = convertirAMd5(cliente.getPassword());
        cliente.setPassword(passwordMd5);
        clientes.add(cliente);
        return true;
    }

    /**
     * Obtiene un cliente por su ID
     *
     * @param id_cliente el ID del cliente a obtener
     * @return el cliente correspondiente al ID especificado, o null si no se encuentra
     */
    public Cliente obtenerCliente(int id_cliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId_cliente() == id_cliente) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente, devuelve null
    }

    /**
     * Actualiza los datos de un cliente existente
     *
     * @param clienteActualizado el cliente actualizado
     * @return true si se actualiza el cliente correctamente, false si el cliente no se encuentra
     */
    public boolean actualizarCliente(Cliente clienteActualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId_cliente() == clienteActualizado.getId_cliente()) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setDireccion(clienteActualizado.getDireccion());
                cliente.setTelefono(clienteActualizado.getTelefono());
                cliente.setEmail(clienteActualizado.getEmail());
                cliente.setPassword(clienteActualizado.getPassword());
                return true; // Si se encuentra el cliente y se actualiza, devuelve true
            }
        }
        return false; // Si no se encuentra el cliente, devuelve false
    }

    /**
     * Elimina un cliente de la lista de clientes
     *
     * @param id_cliente el ID del cliente a eliminar
     * @return true si se elimina el cliente correctamente, false si el cliente no se encuentra
     */
    public boolean eliminarCliente(int id_cliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId_cliente() == id_cliente) {
                clientes.remove(cliente);
                return true; // Si se encuentra y elimina el cliente, devuelve true
            }
        }
        return false; // Si no se encuentra el cliente, devuelve false
    }

    public Cliente isValidUser(String email, String password) {
        String passwordMd5 = convertirAMd5(password);
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getPassword().equals(passwordMd5)) {
                return cliente;
            }
        }
        return null;
    }

    private String convertirAMd5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
