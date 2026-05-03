package com.ut.catanddog.catanddog.Logica;

import static com.ut.catanddog.catanddog.GUI.Facturar.tablaServicios;
import com.ut.catanddog.catanddog.Persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDueño, String celDueño,byte[] imagen) {
        Dueño dueño = new Dueño ();
        dueño.setNombre(nombreDueño);
        dueño.setCelDueño(celDueño);
        
        Mascota masco = new Mascota ();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setImagen(imagen);
        masco.setUnDueño(dueño);
            
        controlPersis.guardar(dueño,masco);
        
    }
    public void crearMascota (Mascota masco){
        controlPersis.crearMascota (masco);
    }
    public void crearDueño (Dueño dueño){
        controlPersis.crearDueño (dueño);
    }
    

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
       controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return  controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDueño, String celDueño,byte[] imagen) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setImagen(imagen);
        
        //modifico masco
        controlPersis.modificarMascota(masco);
        
        //seteo nuevo valores del dueño
        Dueño dueño = this.buscarDueño(masco.getUnDueño().getId_dueño());
        dueño.setCelDueño(celDueño);
        dueño.setNombre(nombreDueño);
        
        //llamar al modificar dueño
        this.modificarDueño(dueño);
    }
     public void editarMascota(Mascota Masco){
        controlPersis.editarMascota(Masco);
    }
    
    private Dueño buscarDueño(int id_dueño) {
        return controlPersis.traerDueño(id_dueño);
    }

    private void modificarDueño(Dueño dueño) {
       controlPersis.modificarDueño(dueño);
    }
    
    public void crearServicio (Servicio servi){
        controlPersis.crearServicio(servi);
    }
    public void borrarServicio(int id_servicio){
        controlPersis.borrarServicio(id_servicio);
    }
    public void modificarServicio(Servicio servi){
        controlPersis.modificarServicio(servi);
    }
    public LinkedList<Servicio> traerListaServicios(){
        return controlPersis.traerListaServicios();
    }
    
       public void crearFactura (Factura factu){
        controlPersis.crearFactura (factu);
    }
    public void borrarFactura(int id_factura){
        controlPersis.borrarFactura(id_factura);
    }
    public void modificarFactura(Factura factu){
        controlPersis.modificarFactura(factu);
    }
    public Factura traerFactura(int id_factura) {
        return  controlPersis.traerFactura(id_factura);
    }
     public void editarFactura(Factura factu){
        controlPersis.editarFactura(factu);
    }

public void guardarFactura(String estado, String fecha, String iva, String subtotalFactu, String total_pagar, String nombreDueño, int cantidad, String nombreServicio, double precioUnitario, double porcentajeIva, String mascota) {
    // Buscar el Dueño en la base de datos por nombre
    Dueño dueño = controlPersis.buscarDueñoPorNombre(nombreDueño);
        if (dueño == null) {
        dueño = new Dueño();
        dueño.setNombre(nombreDueño);
        controlPersis.crearDueño(dueño);
    }
        
        // Buscar la mascota por nombre
    Mascota mascoEncontrada = controlPersis.buscarMascotaPorNombre(mascota);
    if (mascoEncontrada == null) {
        mascoEncontrada = new Mascota();
        mascoEncontrada.setNombre(mascota);
        mascoEncontrada.setUnDueño(dueño);
        controlPersis.crearMascota(mascoEncontrada);
    }

    // Parsear los valores
    double subtotal = Double.parseDouble(subtotalFactu);
    double ivaValor = Double.parseDouble(iva);
    double totalPagar = Double.parseDouble(total_pagar);

    // Convertir la fecha
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date fechaVenta = null;
    try {
        fechaVenta = dateFormat.parse(fecha);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    // Crear instancia de Factura
    Factura factu = new Factura();
    factu.setEstado(estado);
    factu.setFecha_venta(fechaVenta);
    factu.setIva(ivaValor);
    factu.setSubtotal(subtotal);
    factu.setTotal_pagar(totalPagar);
    factu.setUnDueño(dueño);

    // Crear instancia de Servicio
    Servicio servi = new Servicio();
    servi.setNombre(nombreServicio);
    servi.setCantidad(cantidad);
    servi.setPrecio((int) precioUnitario);
    servi.setPorcentajeIva((int) porcentajeIva);
    servi.setFactu(factu);
    servi.setMasco(mascoEncontrada);

    // Guardar la factura y el servicio
    controlPersis.guardarfactura(factu, servi);
}

    public void guardarCita(String descripcion, String fecha_cita, String celDueño, String cliente, String mascota) {
 // Convertir la fecha
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date fechaCita = null;
    try {
        fechaCita = dateFormat.parse(fecha_cita);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    // Buscar el dueño por nombre (suponiendo que el nombre es único)
    Dueño dueño = controlPersis.buscarDueñoPorNombre(cliente);
    if (dueño == null) {
        dueño = new Dueño();
        dueño.setNombre(cliente);
        dueño.setCelDueño(celDueño);
        controlPersis.crearDueño(dueño);
    }

    // Buscar la mascota por nombre
    Mascota mascoEncontrada = controlPersis.buscarMascotaPorNombre(mascota);
    if (mascoEncontrada == null) {
        mascoEncontrada = new Mascota();
        mascoEncontrada.setNombre(mascota);
        mascoEncontrada.setUnDueño(dueño);
        controlPersis.crearMascota(mascoEncontrada);
    }

    // Crear la instancia de Agenda
    Agenda agend = new Agenda();
    agend.setDescripcion(descripcion);
    agend.setFecha_cita(fechaCita);
    agend.setCelDueño(celDueño);
    agend.setUnDueño(dueño);
    agend.setUnaMascota(mascoEncontrada);

    // Guardar la cita
    controlPersis.guardarCita(agend);
    }

public int obtenerUltimoIdFactura() {
    List<Factura> facturas = controlPersis.traerFacturas();
    if (facturas.isEmpty()) {
        return 0; // Si no hay facturas, retornar 0
    }
    // Obtener el máximo ID de factura
    return facturas.stream().mapToInt(Factura::getId_factura).max().orElse(0);
}


}
    

