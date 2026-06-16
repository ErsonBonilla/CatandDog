package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Servicio;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioServicios;
import java.util.List;
import java.util.Optional;

public class GestorServicios {

    private final RepositorioServicios repositorio;

    public GestorServicios(RepositorioServicios repositorio) {
        this.repositorio = repositorio;
    }

    public Servicio crearServicio(String nombre, int cantidad, double precio, double porcentajeIva) {
        Servicio servicio = new Servicio(0, nombre, cantidad, precio, porcentajeIva);
        return repositorio.guardar(servicio);
    }

    public Optional<Servicio> buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public Optional<Servicio> buscarPorNombre(String nombre) {
        return repositorio.listarTodos().stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    public List<Servicio> listarTodos() {
        return repositorio.listarTodos();
    }

    public void eliminarServicio(int id) {
        repositorio.eliminar(id);
    }
}
