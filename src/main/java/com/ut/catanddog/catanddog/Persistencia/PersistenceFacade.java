package com.ut.catanddog.catanddog.Persistencia;

import com.ut.catanddog.catanddog.Logica.Agenda;
import com.ut.catanddog.catanddog.Logica.Dueño;
import com.ut.catanddog.catanddog.Logica.Factura;
import com.ut.catanddog.catanddog.Logica.Mascota;
import com.ut.catanddog.catanddog.Logica.Servicio;
import com.ut.catanddog.catanddog.Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceFacade {

    private static final Logger LOGGER = Logger.getLogger(PersistenceFacade.class.getName());

    private final AgendaJpaController agendaRepository = new AgendaJpaController();
    private final DueñoJpaController dueñoRepository = new DueñoJpaController();
    private final MascotaJpaController mascotaRepository = new MascotaJpaController();
    private final ServicioJpaController servicioRepository = new ServicioJpaController();
    private final FacturaJpaController facturaRepository = new FacturaJpaController();

    @FunctionalInterface
    private interface DestroyAction {
        void destroy(int id) throws NonexistentEntityException;
    }

    @FunctionalInterface
    private interface SafeAction {
        void execute() throws Exception;
    }

    private void logError(String operation, Exception ex) {
        LOGGER.log(Level.SEVERE, "Error en operación de persistencia: {0}", new Object[]{operation});
        LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
    }

    private void safeExecute(SafeAction action, String operation) {
        try {
            action.execute();
        } catch (Exception ex) {
            logError(operation, ex);
        }
    }

    private void safeDestroy(DestroyAction action, int id, String description) {
        try {
            action.destroy(id);
        } catch (NonexistentEntityException ex) {
            LOGGER.log(Level.WARNING, "No se encontró {0} con id {1}", new Object[]{description, id});
        } catch (Exception ex) {
            logError("Eliminar " + description, ex);
        }
    }

    public void saveOwnerAndPet(Dueño owner, Mascota pet) {
        dueñoRepository.create(owner);
        mascotaRepository.create(pet);
    }

    public List<Mascota> findAllPets() {
        return mascotaRepository.findMascotaEntities();
    }

    public void deletePet(int petId) {
        safeDestroy(mascotaRepository::destroy, petId, "mascota");
    }

    public Mascota findPet(int petId) {
        return mascotaRepository.findMascota(petId);
    }

    public void updatePet(Mascota pet) {
        safeExecute(() -> mascotaRepository.edit(pet), "actualizar mascota");
    }

    public Dueño findOwner(int ownerId) {
        return dueñoRepository.findDueño(ownerId);
    }

    public void updateOwner(Dueño owner) {
        safeExecute(() -> dueñoRepository.edit(owner), "actualizar dueño");
    }

    public void createService(Servicio service) {
        servicioRepository.create(service);
    }

    public void createInvoice(Factura invoice) {
        facturaRepository.create(invoice);
    }

    public void createAppointment(Agenda appointment) {
        agendaRepository.create(appointment);
    }

    public Agenda findAppointment(int appointmentId) {
        return agendaRepository.findAgenda(appointmentId);
    }

    public void deleteInvoice(int invoiceId) {
        safeDestroy(facturaRepository::destroy, invoiceId, "factura");
    }

    public void deleteAppointment(int appointmentId) {
        safeDestroy(agendaRepository::destroy, appointmentId, "agenda");
    }

    public void updateInvoice(Factura invoice) {
        safeExecute(() -> facturaRepository.edit(invoice), "actualizar factura");
    }

    public void updateAppointment(Agenda appointment) {
        safeExecute(() -> agendaRepository.edit(appointment), "actualizar agenda");
    }

    public void deleteService(int serviceId) {
        safeDestroy(servicioRepository::destroy, serviceId, "servicio");
    }

    public void updateService(Servicio service) {
        safeExecute(() -> servicioRepository.edit(service), "actualizar servicio");
    }

    public List<Servicio> findAllServices() {
        return new ArrayList<>(servicioRepository.findServicioEntities());
    }

    public void createPet(Mascota pet) {
        mascotaRepository.create(pet);
    }

    public void createOwner(Dueño owner) {
        dueñoRepository.create(owner);
    }

    public void editPet(Mascota pet) {
        safeExecute(() -> mascotaRepository.edit(pet), "editar mascota");
    }

    public Factura findInvoice(int invoiceId) {
        return facturaRepository.findFactura(invoiceId);
    }

    public void editInvoice(Factura invoice) {
        safeExecute(() -> facturaRepository.edit(invoice), "editar factura");
    }

    public void saveInvoiceWithService(Factura invoice, Servicio service) {
        facturaRepository.create(invoice);
        servicioRepository.create(service);
    }

    public Dueño findOwnerByName(String ownerName) {
        return dueñoRepository.findDueñoEntities().stream()
                .filter(owner -> owner.getNombre().equalsIgnoreCase(ownerName))
                .findFirst()
                .orElse(null);
    }

    public Mascota findPetByName(String petName) {
        return mascotaRepository.findMascotaEntities().stream()
                .filter(pet -> pet.getNombre().equalsIgnoreCase(petName))
                .findFirst()
                .orElse(null);
    }

    public List<Factura> findAllInvoices() {
        return facturaRepository.findFacturaEntities();
    }
}
