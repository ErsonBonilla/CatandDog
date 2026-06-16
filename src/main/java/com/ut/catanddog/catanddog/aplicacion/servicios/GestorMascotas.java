package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioDueños;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioMascotas;
import java.util.List;
import java.util.Optional;

public class GestorMascotas {

    private final RepositorioMascotas repositorioMascotas;
    private final RepositorioDueños repositorioDueños;

    public GestorMascotas(RepositorioMascotas repositorioMascotas, RepositorioDueños repositorioDueños) {
        this.repositorioMascotas = repositorioMascotas;
        this.repositorioDueños = repositorioDueños;
    }

    public Mascota registrarMascota(String nombre, String raza, String color,
            String alergico, String atencionEspecial, String observaciones,
            byte[] imagen, Dueño dueño) {
        Mascota mascota = new Mascota(0, nombre, raza, color, dueño);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEspecial);
        mascota.setObservaciones(observaciones);
        mascota.setImagen(imagen);
        return repositorioMascotas.guardar(mascota);
    }

    public Mascota actualizarMascota(int id, String nombre, String raza, String color,
            String alergico, String atencionEspecial, String observaciones,
            byte[] imagen, String nombreDueño, String celularDueño) {
        Mascota mascota = repositorioMascotas.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada con id: " + id));

        mascota.setNombre(nombre);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEspecial);
        mascota.setObservaciones(observaciones);
        mascota.setImagen(imagen);

        Dueño dueño = mascota.getDueño();
        if (dueño != null) {
            dueño.setNombre(nombreDueño);
            dueño.setCelular(celularDueño);
        }

        return repositorioMascotas.guardar(mascota);
    }

    public Optional<Mascota> buscarPorId(int id) {
        return repositorioMascotas.buscarPorId(id);
    }

    public Optional<Mascota> buscarPorNombre(String nombre) {
        return repositorioMascotas.buscarPorNombre(nombre);
    }

    public List<Mascota> listarTodos() {
        return repositorioMascotas.listarTodos();
    }

    public void eliminarMascota(int id) {
        repositorioMascotas.eliminar(id);
    }
}
