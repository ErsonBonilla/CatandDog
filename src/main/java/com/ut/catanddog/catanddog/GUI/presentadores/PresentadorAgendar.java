package com.ut.catanddog.catanddog.GUI.presentadores;

import com.ut.catanddog.catanddog.aplicacion.servicios.GestorAgenda;
import com.ut.catanddog.catanddog.aplicacion.servicios.GestorDueños;
import com.ut.catanddog.catanddog.aplicacion.servicios.GestorMascotas;
import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;

public class PresentadorAgendar {

    private final GestorAgenda gestorAgenda;
    private final GestorDueños gestorDueños;
    private final GestorMascotas gestorMascotas;

    public PresentadorAgendar(GestorAgenda gestorAgenda, GestorDueños gestorDueños, GestorMascotas gestorMascotas) {
        this.gestorAgenda = gestorAgenda;
        this.gestorDueños = gestorDueños;
        this.gestorMascotas = gestorMascotas;
    }

    public void cargarClientes(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Seleccione Cliente:");
        for (Dueño dueño : gestorDueños.listarTodos()) {
            combo.addItem(dueño.getNombre());
        }
    }

    public void cargarMascotas(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Selecciona Mascota:");
        for (Mascota mascota : gestorMascotas.listarTodos()) {
            combo.addItem(mascota.getNombre());
        }
    }

    public void cargarCelulares(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Selecciona Celular Dueño:");
        for (Dueño dueño : gestorDueños.listarTodos()) {
            if (dueño.getCelular() != null && !dueño.getCelular().isBlank()) {
                combo.addItem(dueño.getCelular());
            }
        }
    }

    public void guardarCita(String descripcion, Date fechaCita, String celular,
            String nombreCliente, String nombreMascota) {
        if (fechaCita == null) {
            throw new IllegalArgumentException("Debe seleccionar una fecha");
        }
        Dueño dueño = gestorDueños.buscarPorNombre(nombreCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        Mascota mascota = gestorMascotas.buscarPorNombre(nombreMascota)
                .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada"));

        gestorAgenda.programarCita(descripcion, fechaCita, celular, dueño, mascota);
    }

}
