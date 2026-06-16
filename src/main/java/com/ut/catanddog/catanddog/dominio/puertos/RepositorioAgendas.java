package com.ut.catanddog.catanddog.dominio.puertos;

import com.ut.catanddog.catanddog.dominio.modelo.Agenda;
import java.util.List;
import java.util.Optional;

public interface RepositorioAgendas {
    Agenda guardar(Agenda agenda);
    Optional<Agenda> buscarPorId(int id);
    List<Agenda> listarTodos();
    void eliminar(int id);
}
