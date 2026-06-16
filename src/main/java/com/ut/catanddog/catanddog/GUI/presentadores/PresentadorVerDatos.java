package com.ut.catanddog.catanddog.GUI.presentadores;

import com.ut.catanddog.catanddog.aplicacion.servicios.GestorMascotas;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import java.util.List;

public class PresentadorVerDatos {

    private final GestorMascotas gestorMascotas;

    public PresentadorVerDatos(GestorMascotas gestorMascotas) {
        this.gestorMascotas = gestorMascotas;
    }

    public List<Mascota> listarMascotas() {
        return gestorMascotas.listarTodos();
    }

    public void eliminarMascota(int id) {
        gestorMascotas.eliminarMascota(id);
    }

    public Mascota buscarMascota(int id) {
        return gestorMascotas.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada"));
    }
}
