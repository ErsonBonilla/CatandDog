package com.ut.catanddog.catanddog.dominio.puertos;

import com.ut.catanddog.catanddog.dominio.modelo.Servicio;
import java.util.List;
import java.util.Optional;

public interface RepositorioServicios {
    Servicio guardar(Servicio servicio);
    Optional<Servicio> buscarPorId(int id);
    List<Servicio> listarTodos();
    void eliminar(int id);
}
