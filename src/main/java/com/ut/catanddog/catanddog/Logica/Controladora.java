package com.ut.catanddog.catanddog.Logica;

import com.ut.catanddog.catanddog.Persistencia.PersistenceFacade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Controladora {

    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);

    private final PersistenceFacade persistenceFacade = new PersistenceFacade();

    public void guardar(String nombreMascota, String raza, String color, String observaciones,
            String alergico, String atencionEspecial, String nombreDueño, String celularDueño,
            byte[] imagen) {

        Dueño owner = new Dueño();
        owner.setNombre(nombreDueño);
        owner.setCelDueño(celularDueño);

        Mascota pet = new Mascota();
        pet.setNombre(nombreMascota);
        pet.setRaza(raza);
        pet.setColor(color);
        pet.setAlergico(alergico);
        pet.setAtencion_especial(atencionEspecial);
        pet.setObservaciones(observaciones);
        pet.setImagen(imagen);
        pet.setUnDueño(owner);

        persistenceFacade.saveOwnerAndPet(owner, pet);
    }

    public void crearMascota(Mascota mascota) {
        persistenceFacade.createPet(mascota);
    }

    public void crearDueño(Dueño dueño) {
        persistenceFacade.createOwner(dueño);
    }

    public List<Mascota> traerMascotas() {
        return persistenceFacade.findAllPets();
    }

    public void borrarMascota(int idMascota) {
        persistenceFacade.deletePet(idMascota);
    }

    public Mascota traerMascota(int idMascota) {
        return persistenceFacade.findPet(idMascota);
    }

    public void modificarMascota(Mascota mascota, String nombreMascota, String raza, String color,
            String observaciones, String alergico, String atencionEspecial,
            String nombreDueño, String celularDueño, byte[] imagen) {

        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atencionEspecial);
        mascota.setImagen(imagen);

        persistenceFacade.updatePet(mascota);

        Dueño owner = findOwnerById(mascota.getUnDueño().getId_dueño());
        owner.setCelDueño(celularDueño);
        owner.setNombre(nombreDueño);
        persistenceFacade.updateOwner(owner);
    }

    public void editarMascota(Mascota mascota) {
        persistenceFacade.editPet(mascota);
    }

    private Dueño findOwnerById(int idDueño) {
        return persistenceFacade.findOwner(idDueño);
    }

    public void crearServicio(Servicio servicio) {
        persistenceFacade.createService(servicio);
    }

    public void borrarServicio(int idServicio) {
        persistenceFacade.deleteService(idServicio);
    }

    public void modificarServicio(Servicio servicio) {
        persistenceFacade.updateService(servicio);
    }

    public List<Servicio> traerListaServicios() {
        return persistenceFacade.findAllServices();
    }

    public void crearFactura(Factura factura) {
        persistenceFacade.createInvoice(factura);
    }

    public void borrarFactura(int idFactura) {
        persistenceFacade.deleteInvoice(idFactura);
    }

    public void modificarFactura(Factura factura) {
        persistenceFacade.updateInvoice(factura);
    }

    public Factura traerFactura(int idFactura) {
        return persistenceFacade.findInvoice(idFactura);
    }

    public void editarFactura(Factura factura) {
        persistenceFacade.updateInvoice(factura);
    }

    public void guardarFactura(String estado, String fecha, String iva, String subtotalFactu,
            String totalPagar, String nombreDueño, int cantidad, String nombreServicio,
            double precioUnitario, double porcentajeIva, String nombreMascota) {

        Dueño dueño = getOrCreateOwner(nombreDueño, null);
        Mascota mascota = getOrCreatePet(nombreMascota, dueño);

        double subtotal = parseDouble(subtotalFactu, "subtotal");
        double ivaValor = parseDouble(iva, "iva");
        double total = parseDouble(totalPagar, "total a pagar");
        Date fechaVenta = parseDate(fecha, "fecha de factura");

        Factura factura = new Factura();
        factura.setEstado(estado);
        factura.setFecha_venta(fechaVenta);
        factura.setIva(ivaValor);
        factura.setSubtotal(subtotal);
        factura.setTotal_pagar(total);
        factura.setUnDueño(dueño);

        Servicio servicio = new Servicio();
        servicio.setNombre(nombreServicio);
        servicio.setCantidad(cantidad);
        servicio.setPrecio((int) precioUnitario);
        servicio.setPorcentajeIva((int) porcentajeIva);
        servicio.setFactura(factura);
        servicio.setMascota(mascota);

        persistenceFacade.saveInvoiceWithService(factura, servicio);
    }

    public void guardarCita(String descripcion, String fechaCita, String celularDueño,
            String cliente, String nombreMascota) {

        Dueño dueño = getOrCreateOwner(cliente, celularDueño);
        Mascota mascota = getOrCreatePet(nombreMascota, dueño);

        Date fecha = parseDate(fechaCita, "fecha de cita");

        Agenda agenda = new Agenda();
        agenda.setDescripcion(descripcion);
        agenda.setFecha_cita(fecha);
        agenda.setCelDueño(celularDueño);
        agenda.setUnDueño(dueño);
        agenda.setUnaMascota(mascota);

        persistenceFacade.createAppointment(agenda);
    }

    public int obtenerUltimoIdFactura() {
        return persistenceFacade.findAllInvoices().stream()
                .mapToInt(Factura::getId_factura)
                .max()
                .orElse(0);
    }

    private Dueño getOrCreateOwner(String nombreDueño, String celularDueño) {
        Dueño owner = persistenceFacade.findOwnerByName(nombreDueño);
        if (owner == null) {
            owner = new Dueño();
            owner.setNombre(nombreDueño);
            owner.setCelDueño(celularDueño);
            persistenceFacade.createOwner(owner);
        }
        return owner;
    }

    private Mascota getOrCreatePet(String nombreMascota, Dueño dueño) {
        Mascota pet = persistenceFacade.findPetByName(nombreMascota);
        if (pet == null) {
            pet = new Mascota();
            pet.setNombre(nombreMascota);
            pet.setUnDueño(dueño);
            persistenceFacade.createPet(pet);
        }
        return pet;
    }

    private Date parseDate(String rawDate, String fieldName) {
        try {
            return DATE_FORMAT.parse(rawDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato inválido para " + fieldName + ". Use dd-MM-yyyy", e);
        }
    }

    private double parseDouble(String rawValue, String fieldName) {
        try {
            return Double.parseDouble(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor numérico inválido en " + fieldName + ": " + rawValue, e);
        }
    }
}
