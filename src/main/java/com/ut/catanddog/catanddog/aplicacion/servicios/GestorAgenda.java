package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Agenda;
import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioAgendas;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class GestorAgenda {

    private final RepositorioAgendas repositorioAgendas;

    public GestorAgenda(RepositorioAgendas repositorioAgendas) {
        this.repositorioAgendas = repositorioAgendas;
    }

    public Agenda programarCita(String descripcion, Date fechaCita, String celularDueño,
            Dueño dueño, Mascota mascota) {
        Agenda agenda = new Agenda(0, descripcion, fechaCita, dueño, mascota);
        agenda.setCelularDueño(celularDueño);
        return repositorioAgendas.guardar(agenda);
    }

    public Optional<Agenda> buscarPorId(int id) {
        return repositorioAgendas.buscarPorId(id);
    }

    public List<Agenda> listarTodas() {
        return repositorioAgendas.listarTodos();
    }

    public void eliminarCita(int id) {
        repositorioAgendas.eliminar(id);
    }
}
