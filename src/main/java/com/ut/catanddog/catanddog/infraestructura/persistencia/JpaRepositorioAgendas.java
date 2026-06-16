package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Agenda;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioAgendas;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaRepositorioAgendas implements RepositorioAgendas {

    private final AgendaJpaController controller;

    public JpaRepositorioAgendas() {
        this.controller = new AgendaJpaController();
    }

    public JpaRepositorioAgendas(AgendaJpaController controller) {
        this.controller = controller;
    }

    @Override
    public Agenda guardar(Agenda agenda) {
        AgendaJpaEntity entity = AgendaJpaEntity.fromDominio(agenda);
        if (agenda.getId() == 0) {
            controller.create(entity);
        } else {
            try {
                controller.edit(entity);
            } catch (Exception e) {
                throw new RuntimeException("Error al guardar agenda", e);
            }
        }
        return entity.toDominio();
    }

    @Override
    public Optional<Agenda> buscarPorId(int id) {
        AgendaJpaEntity entity = controller.findAgenda(id);
        return entity != null ? Optional.of(entity.toDominio()) : Optional.empty();
    }

    @Override
    public List<Agenda> listarTodos() {
        return controller.findAgendaEntities().stream()
                .map(AgendaJpaEntity::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int id) {
        try {
            controller.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar agenda", e);
        }
    }
}
