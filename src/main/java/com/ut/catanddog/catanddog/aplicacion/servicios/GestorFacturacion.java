package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.modelo.Factura;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import com.ut.catanddog.catanddog.dominio.modelo.Servicio;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioDueños;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioFacturas;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioMascotas;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioServicios;
import com.ut.catanddog.catanddog.infraestructura.pdf.ItextGeneradorFacturaPDF;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class GestorFacturacion {

    private final RepositorioFacturas repositorioFacturas;
    private final RepositorioServicios repositorioServicios;
    private final RepositorioDueños repositorioDueños;
    private final RepositorioMascotas repositorioMascotas;
    private final ItextGeneradorFacturaPDF generadorPDF;

    public GestorFacturacion(RepositorioFacturas repositorioFacturas,
            RepositorioServicios repositorioServicios,
            RepositorioDueños repositorioDueños,
            RepositorioMascotas repositorioMascotas,
            ItextGeneradorFacturaPDF generadorPDF) {
        this.repositorioFacturas = repositorioFacturas;
        this.repositorioServicios = repositorioServicios;
        this.repositorioDueños = repositorioDueños;
        this.repositorioMascotas = repositorioMascotas;
        this.generadorPDF = generadorPDF;
    }

    public Factura crearFactura(String estado, Date fechaVenta, Dueño dueño,
            List<Servicio> servicios) {
        Factura factura = new Factura(0, fechaVenta, estado, dueño);
        factura.setServicios(servicios);
        factura.recalcularTotales();
        return repositorioFacturas.guardar(factura);
    }

    public Factura registrarVenta(String estado, Date fechaVenta,
            double subtotal, double iva, double totalPagar,
            String nombreDueño, int cantidad, String nombreServicio,
            double precioUnitario, double porcentajeIva, String nombreMascota) {

        Dueño dueño = getOrCreateOwner(nombreDueño, null);
        Mascota mascota = getOrCreatePet(nombreMascota, dueño);

        Factura factura = new Factura(0, fechaVenta, estado, dueño);
        factura.setSubtotal(subtotal);
        factura.setIva(iva);
        factura.setTotalPagar(totalPagar);
        factura = repositorioFacturas.guardar(factura);

        Servicio servicio = new Servicio(0, nombreServicio, cantidad, precioUnitario, porcentajeIva);
        repositorioServicios.guardar(servicio);

        generarPDFFactura(factura);

        return factura;
    }

    public void generarPDFFactura(Factura factura) {
        String ruta = "C:/Facturas/Factura_" + factura.getId() + ".pdf";
        generadorPDF.generar(factura, ruta);
    }

    public int obtenerUltimoIdFactura() {
        return repositorioFacturas.listarTodos().stream()
                .mapToInt(Factura::getId)
                .max()
                .orElse(0);
    }

    public Optional<Factura> buscarPorId(int id) {
        return repositorioFacturas.buscarPorId(id);
    }

    public List<Factura> listarTodas() {
        return repositorioFacturas.listarTodos();
    }

    public void eliminarFactura(int id) {
        repositorioFacturas.eliminar(id);
    }

    private Dueño getOrCreateOwner(String nombreDueño, String celularDueño) {
        Optional<Dueño> existente = repositorioDueños.buscarPorNombre(nombreDueño);
        if (existente.isPresent()) {
            return existente.get();
        }
        Dueño nuevo = new Dueño(0, nombreDueño, celularDueño);
        return repositorioDueños.guardar(nuevo);
    }

    private Mascota getOrCreatePet(String nombreMascota, Dueño dueño) {
        Optional<Mascota> existente = repositorioMascotas.buscarPorNombre(nombreMascota);
        if (existente.isPresent()) {
            return existente.get();
        }
        Mascota nuevo = new Mascota(0, nombreMascota, null, null, dueño);
        return repositorioMascotas.guardar(nuevo);
    }
}
