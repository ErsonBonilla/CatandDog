package com.ut.catanddog.catanddog.dominio.puertos;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import java.util.List;
import java.util.Optional;

public interface RepositorioDueños {
    Dueño guardar(Dueño dueño);
    Optional<Dueño> buscarPorId(int id);
    Optional<Dueño> buscarPorNombre(String nombre);
    List<Dueño> listarTodos();
    void eliminar(int id);
}
