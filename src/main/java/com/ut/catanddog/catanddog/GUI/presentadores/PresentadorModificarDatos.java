package com.ut.catanddog.catanddog.GUI.presentadores;

import com.ut.catanddog.catanddog.aplicacion.servicios.GestorMascotas;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;

public class PresentadorModificarDatos {

    private final GestorMascotas gestorMascotas;

    public PresentadorModificarDatos(GestorMascotas gestorMascotas) {
        this.gestorMascotas = gestorMascotas;
    }

    public Mascota buscarMascota(int id) {
        return gestorMascotas.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada con id: " + id));
    }

    public void guardarCambios(int id, String nombre, String raza, String color,
            String alergico, String atencionEspecial, String observaciones,
            byte[] imagen, String nombreDueño, String celularDueño) {
        gestorMascotas.actualizarMascota(id, nombre, raza, color,
                alergico, atencionEspecial, observaciones, imagen,
                nombreDueño, celularDueño);
    }
}
