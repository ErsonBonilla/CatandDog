package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Servicio;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioServicios;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaRepositorioServicios implements RepositorioServicios {

    private final ServicioJpaController controller;

    public JpaRepositorioServicios() {
        this.controller = new ServicioJpaController();
    }

    public JpaRepositorioServicios(ServicioJpaController controller) {
        this.controller = controller;
    }

    @Override
    public Servicio guardar(Servicio servicio) {
        ServicioJpaEntity entity = ServicioJpaEntity.fromDominio(servicio);
        if (servicio.getId() == 0) {
            controller.create(entity);
        } else {
            try {
                controller.edit(entity);
            } catch (Exception e) {
                throw new RuntimeException("Error al guardar servicio", e);
            }
        }
        return entity.toDominio();
    }

    @Override
    public Optional<Servicio> buscarPorId(int id) {
        ServicioJpaEntity entity = controller.findServicio(id);
        return entity != null ? Optional.of(entity.toDominio()) : Optional.empty();
    }

    @Override
    public List<Servicio> listarTodos() {
        return controller.findServicioEntities().stream()
                .map(ServicioJpaEntity::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int id) {
        try {
            controller.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar servicio", e);
        }
    }
}
