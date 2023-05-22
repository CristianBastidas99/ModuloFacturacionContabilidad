package co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Principal;

import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Contabilidad.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Facturacion.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Inventario.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Persona.*;
import co.edu.uniquindio.ModuloFacturacionContabilidad.Clases.Reporte.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Principal {

    private List<Proyecto> proyectos = new ArrayList();
    private List<Cliente> clientes = new ArrayList();
    private List<Proveedor> proveedores = new ArrayList();

    public Principal() {

        // Creamos 3 instancias de Cliente
        Cliente cliente1 = new Cliente(1, "Juan Perez", "Calle Falsa 123", "12345678", "juan.perez@example.com", "contraseña1");
        Cliente cliente2 = new Cliente(2, "María Rodríguez", "Calle Real 456", "23456789", "maria.rodriguez@example.com", "contraseña2");
        Cliente cliente3 = new Cliente(3, "Pedro Gómez", "Avenida Siempreviva 789", "34567890", "pedro.gomez@example.com", "contraseña3");
        Cliente cliente4 = new Cliente(1, "Cristian Bastidas", "Calle 123", "1234567890", "cfbastidaso@uqvirtual.edu.co", "password123");
        Cliente cliente5 = new Cliente(2, "Jessica Quintero", "Calle 456", "0987654321", "jyquinterov@uqvirtual.edu.co", "password456");

        // Creamos 3 instancias de Proveedor
        Proveedor proveedor1 = new Proveedor(1, "Proveedor 1", "Calle Proveedor 1", "11111111", "proveedor1@example.com");
        Proveedor proveedor2 = new Proveedor(2, "Proveedor 2", "Calle Proveedor 2", "22222222", "proveedor2@example.com");
        Proveedor proveedor3 = new Proveedor(3, "Proveedor 3", "Calle Proveedor 3", "33333333", "proveedor3@example.com");

        OrdenDeCompra orden1 = new OrdenDeCompra(1, LocalDate.now(), 1000.0, proveedor1);
        OrdenDeCompra orden2 = new OrdenDeCompra(2, LocalDate.now(), 2000.0, proveedor2);
        OrdenDeCompra orden3 = new OrdenDeCompra(3, LocalDate.now(), 3000.0, proveedor3);

        Item item1 = new Item(1, "Item 1 Proveedor 1", "Descripción del item 1 del proveedor 1", 10.0, proveedor1, TipoItem.PRODUCTO);
        Item item2 = new Item(2, "Item 2 Proveedor 1", "Descripción del item 2 del proveedor 1", 20.0, proveedor1, TipoItem.PRODUCTO);
        Item item3 = new Item(3, "Item 3 Proveedor 1", "Descripción del item 3 del proveedor 1", 30.0, proveedor1, TipoItem.SERVICIO);
        Item item4 = new Item(4, "Item 1 Proveedor 2", "Descripción del item 1 del proveedor 2", 15.0, proveedor2, TipoItem.PRODUCTO);
        Item item5 = new Item(5, "Item 2 Proveedor 2", "Descripción del item 2 del proveedor 2", 25.0, proveedor2, TipoItem.PRODUCTO);
        Item item6 = new Item(6, "Item 3 Proveedor 2", "Descripción del item 3 del proveedor 2", 35.0, proveedor2, TipoItem.SERVICIO);

        orden1.getItems().add(item1);
        orden1.getItems().add(item2);
        orden1.getItems().add(item3);

        orden2.getItems().add(item4);
        orden2.getItems().add(item5);
        orden2.getItems().add(item6);

        Inventario inventario = new Inventario(1, "Inventario principal", LocalDate.now());

        inventario.getItems().add(item1);
        inventario.getCantidades().put(item1, 5);
        inventario.getItems().add(item2);
        inventario.getCantidades().put(item2, 10);
        inventario.getItems().add(item3);
        inventario.getCantidades().put(item3, 15);
        inventario.getItems().add(item4);
        inventario.getCantidades().put(item4, 13);
        inventario.getItems().add(item5);
        inventario.getCantidades().put(item5, 7);
        inventario.getItems().add(item6);
        inventario.getCantidades().put(item6, 3);

        // Creamos los impuestos
        Impuesto impuesto1 = new Impuesto(1, "IVA", 0.16);
        Impuesto impuesto2 = new Impuesto(2, "Impuesto sobre ventas", 0.05);
        Impuesto impuesto3 = new Impuesto(3, "Impuesto al consumo", 0.08);
        Impuesto impuesto4 = new Impuesto(4, "Impuesto a las bebidas azucaradas", 0.20);

        // Creamos los detalles de factura para la primera factura
        DetalleFactura detalle1Factura1 = new DetalleFactura(1, 2, item1, impuesto1);
        DetalleFactura detalle2Factura1 = new DetalleFactura(2, 3, item2, impuesto2);
        Factura factura1 = new Factura(1, LocalDate.now(), 80.0, orden1, null, cliente1);
        factura1.getDetalleFacturas().add(detalle1Factura1);
        factura1.getDetalleFacturas().add(detalle2Factura1);

        // Creamos los detalles de factura para la segunda factura
        DetalleFactura detalle1Factura2 = new DetalleFactura(1, 1, item3, impuesto1);
        DetalleFactura detalle2Factura2 = new DetalleFactura(2, 4, item4, impuesto3);
        Factura factura2 = new Factura(2, LocalDate.now(), 170.0, orden2, null, cliente1);
        factura2.getDetalleFacturas().add(detalle1Factura2);
        factura2.getDetalleFacturas().add(detalle2Factura2);

        // Creamos los detalles de factura para la tercera factura
        DetalleFactura detalle1Factura3 = new DetalleFactura(1, 5, item5, impuesto1);
        DetalleFactura detalle2Factura3 = new DetalleFactura(2, 2, item6, impuesto4);
        Factura factura3 = new Factura(3, LocalDate.now(), 390.0, orden3, null, cliente1);
        factura3.getDetalleFacturas().add(detalle1Factura3);
        factura3.getDetalleFacturas().add(detalle2Factura3);

        Transaccion transaccion1 = new Transaccion(1, LocalDate.now(), 100.0, null, null, TipoTransaccion.INGRESO, null);
        Transaccion transaccion2 = new Transaccion(2, LocalDate.now(), 50.0, null, null, TipoTransaccion.INGRESO, null);
        Transaccion transaccion3 = new Transaccion(3, LocalDate.now(), 75.0, null, null, TipoTransaccion.GASTO, null);

        Pago pago1 = new Pago(1, LocalDate.now(), 100.0, "Completado", MetodoPago.TARJETA_DE_CRÉDITO, factura1, transaccion1);
        factura1.setPago(pago1);
        Pago pago2 = new Pago(2, LocalDate.now(), 50.0, "Completado", MetodoPago.TRANSFERENCIA_BANCARIA, factura2, transaccion2);
        factura2.setPago(pago2);
        Pago pago3 = new Pago(3, LocalDate.now(), 75.0, "Pendiente", MetodoPago.PAYPAL, factura3, transaccion3);
        factura3.setPago(pago3);

        // Creamos 3 instancias de Proyecto, cada una asociada a un cliente y un proveedor
        Proyecto proyecto1 = new Proyecto(1, "Proyecto 1", LocalDate.now(), LocalDate.now().plusMonths(5), null, "en curso", 5000);

        proyecto1.getClientes().add(cliente1);
        proyecto1.getClientes().add(cliente4);
        proyecto1.getClientes().add(cliente5);
        proyecto1.getOrdenDeCompras().add(orden1);
        proyecto1.getOrdenDeCompras().add(orden2);
        proyecto1.getOrdenDeCompras().add(orden3);
        proyecto1.setInventario(inventario);
        proyecto1.getFacturas().add(factura1);
        proyecto1.getFacturas().add(factura2);
        proyecto1.getFacturas().add(factura3);
        proyecto1.getPagos().add(pago1);
        proyecto1.getPagos().add(pago2);
        proyecto1.getPagos().add(pago3);
        proyecto1.getImpuestos().add(impuesto1);
        proyecto1.getImpuestos().add(impuesto2);
        proyecto1.getImpuestos().add(impuesto3);
        proyecto1.getImpuestos().add(impuesto4);
        proyecto1.getTransaccions().add(transaccion1);
        proyecto1.getTransaccions().add(transaccion2);
        proyecto1.getTransaccions().add(transaccion3);

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

    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        //La dirección de correo de envío
        String remitente = "cristianmasmasmas@gmail.com";
        //La clave de aplicación obtenida según se explica en este artículo:
        String claveemail = "djkergzcmkyrfigv";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveemail);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
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

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
