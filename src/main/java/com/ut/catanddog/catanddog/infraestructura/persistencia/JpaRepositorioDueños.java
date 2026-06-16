package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioDueños;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaRepositorioDueños implements RepositorioDueños {

    private final DueñoJpaController controller;

    public JpaRepositorioDueños() {
        this.controller = new DueñoJpaController();
    }

    public JpaRepositorioDueños(DueñoJpaController controller) {
        this.controller = controller;
    }

    @Override
    public Dueño guardar(Dueño dueño) {
        DueñoJpaEntity entity = DueñoJpaEntity.fromDominio(dueño);
        if (dueño.getId() == 0) {
            controller.create(entity);
        } else {
            try {
                controller.edit(entity);
            } catch (Exception e) {
                throw new RuntimeException("Error al guardar dueño", e);
            }
        }
        return entity.toDominio();
    }

    @Override
    public Optional<Dueño> buscarPorId(int id) {
        DueñoJpaEntity entity = controller.findDueño(id);
        return entity != null ? Optional.of(entity.toDominio()) : Optional.empty();
    }

    @Override
    public Optional<Dueño> buscarPorNombre(String nombre) {
        return controller.findDueñoEntities().stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .map(DueñoJpaEntity::toDominio)
                .findFirst();
    }

    @Override
    public List<Dueño> listarTodos() {
        return controller.findDueñoEntities().stream()
                .map(DueñoJpaEntity::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int id) {
        try {
            controller.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar dueño", e);
        }
    }
}
