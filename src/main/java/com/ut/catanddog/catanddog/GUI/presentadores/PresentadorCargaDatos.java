package com.ut.catanddog.catanddog.GUI.presentadores;

import com.ut.catanddog.catanddog.aplicacion.servicios.GestorDueños;
import com.ut.catanddog.catanddog.aplicacion.servicios.GestorMascotas;
import com.ut.catanddog.catanddog.dominio.modelo.Dueño;

public class PresentadorCargaDatos {

    private final GestorMascotas gestorMascotas;
    private final GestorDueños gestorDueños;

    public PresentadorCargaDatos(GestorMascotas gestorMascotas, GestorDueños gestorDueños) {
        this.gestorMascotas = gestorMascotas;
        this.gestorDueños = gestorDueños;
    }

    public void guardar(String nombreMascota, String raza, String color,
            String alergico, String atencionEspecial, String observaciones,
            String nombreDueño, String celular, byte[] imagen) {

        Dueño dueño = gestorDueños.buscarPorNombre(nombreDueño)
                .orElseGet(() -> gestorDueños.registrarDueño(nombreDueño, celular));

        gestorMascotas.registrarMascota(nombreMascota, raza, color,
                alergico, atencionEspecial, observaciones, imagen, dueño);
    }
}
