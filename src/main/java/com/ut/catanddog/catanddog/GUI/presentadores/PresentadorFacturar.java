package com.ut.catanddog.catanddog.GUI.presentadores;

import com.ut.catanddog.catanddog.aplicacion.servicios.GestorDueños;
import com.ut.catanddog.catanddog.aplicacion.servicios.GestorFacturacion;
import com.ut.catanddog.catanddog.aplicacion.servicios.GestorMascotas;
import com.ut.catanddog.catanddog.aplicacion.servicios.GestorServicios;
import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import com.ut.catanddog.catanddog.dominio.modelo.Servicio;
import java.util.Date;
import java.util.List;

public class PresentadorFacturar {

    private final GestorFacturacion gestorFacturacion;
    private final GestorDueños gestorDueños;
    private final GestorMascotas gestorMascotas;
    private final GestorServicios gestorServicios;

    public PresentadorFacturar(GestorFacturacion gestorFacturacion,
            GestorDueños gestorDueños,
            GestorMascotas gestorMascotas,
            GestorServicios gestorServicios) {
        this.gestorFacturacion = gestorFacturacion;
        this.gestorDueños = gestorDueños;
        this.gestorMascotas = gestorMascotas;
        this.gestorServicios = gestorServicios;
    }

    public void cargarClientes(javax.swing.JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Seleccione Cliente:");
        for (Dueño dueño : gestorDueños.listarTodos()) {
            combo.addItem(dueño.getNombre());
        }
    }

    public void cargarMascotas(javax.swing.JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Seleccione Mascota:");
        for (Mascota mascota : gestorMascotas.listarTodos()) {
            combo.addItem(mascota.getNombre());
        }
    }

    public void cargarServicios(javax.swing.JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Seleccione Servicio:");
        for (Servicio servicio : gestorServicios.listarTodos()) {
            combo.addItem(servicio.getNombre());
        }
    }

    public Servicio buscarServicioPorNombre(String nombre) {
        return gestorServicios.buscarPorNombre(nombre)
                .orElse(null);
    }

    public int obtenerSiguienteIdFactura() {
        return gestorFacturacion.obtenerUltimoIdFactura() + 1;
    }

    public void registrarVenta(String estado, Date fechaVenta,
            double subtotal, double iva, double totalPagar,
            String nombreDueño, int cantidad, String nombreServicio,
            double precioUnitario, double porcentajeIva, String nombreMascota) {
        gestorFacturacion.registrarVenta(estado, fechaVenta, subtotal, iva,
                totalPagar, nombreDueño, cantidad, nombreServicio,
                precioUnitario, porcentajeIva, nombreMascota);
    }
}
