package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioMascotas;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaRepositorioMascotas implements RepositorioMascotas {

    private final MascotaJpaController controller;

    public JpaRepositorioMascotas() {
        this.controller = new MascotaJpaController();
    }

    public JpaRepositorioMascotas(MascotaJpaController controller) {
        this.controller = controller;
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        MascotaJpaEntity entity = MascotaJpaEntity.fromDominio(mascota);
        if (mascota.getId() == 0) {
            controller.create(entity);
        } else {
            try {
                controller.edit(entity);
            } catch (Exception e) {
                throw new RuntimeException("Error al guardar mascota", e);
            }
        }
        return entity.toDominio();
    }

    @Override
    public Optional<Mascota> buscarPorId(int id) {
        MascotaJpaEntity entity = controller.findMascota(id);
        return entity != null ? Optional.of(entity.toDominio()) : Optional.empty();
    }

    @Override
    public Optional<Mascota> buscarPorNombre(String nombre) {
        return controller.findMascotaEntities().stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .map(MascotaJpaEntity::toDominio)
                .findFirst();
    }

    @Override
    public List<Mascota> listarTodos() {
        return controller.findMascotaEntities().stream()
                .map(MascotaJpaEntity::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int id) {
        try {
            controller.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar mascota", e);
        }
    }
}
