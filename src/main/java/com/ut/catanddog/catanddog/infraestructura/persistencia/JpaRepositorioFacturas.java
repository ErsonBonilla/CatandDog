package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Factura;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioFacturas;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaRepositorioFacturas implements RepositorioFacturas {

    private final FacturaJpaController controller;

    public JpaRepositorioFacturas() {
        this.controller = new FacturaJpaController();
    }

    public JpaRepositorioFacturas(FacturaJpaController controller) {
        this.controller = controller;
    }

    @Override
    public Factura guardar(Factura factura) {
        FacturaJpaEntity entity = FacturaJpaEntity.fromDominio(factura);
        if (factura.getId() == 0) {
            controller.create(entity);
        } else {
            try {
                controller.edit(entity);
            } catch (Exception e) {
                throw new RuntimeException("Error al guardar factura", e);
            }
        }
        return entity.toDominio();
    }

    @Override
    public Optional<Factura> buscarPorId(int id) {
        FacturaJpaEntity entity = controller.findFactura(id);
        return entity != null ? Optional.of(entity.toDominio()) : Optional.empty();
    }

    @Override
    public List<Factura> listarTodos() {
        return controller.findFacturaEntities().stream()
                .map(FacturaJpaEntity::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int id) {
        try {
            controller.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar factura", e);
        }
    }
}
