package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioDueños;
import java.util.List;
import java.util.Optional;

public class GestorDueños {

    private final RepositorioDueños repositorio;

    public GestorDueños(RepositorioDueños repositorio) {
        this.repositorio = repositorio;
    }

    public Dueño registrarDueño(String nombre, String celular) {
        Dueño dueño = new Dueño(0, nombre, celular);
        return repositorio.guardar(dueño);
    }

    public Dueño actualizarDueño(int id, String nombre, String celular) {
        Dueño dueño = repositorio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Dueño no encontrado con id: " + id));
        dueño.setNombre(nombre);
        dueño.setCelular(celular);
        return repositorio.guardar(dueño);
    }

    public Optional<Dueño> buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public Optional<Dueño> buscarPorNombre(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    public List<Dueño> listarTodos() {
        return repositorio.listarTodos();
    }

    public void eliminarDueño(int id) {
        repositorio.eliminar(id);
    }
}
