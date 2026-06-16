package com.ut.catanddog.catanddog.dominio.puertos;

import com.ut.catanddog.catanddog.dominio.modelo.Factura;
import java.util.List;
import java.util.Optional;

public interface RepositorioFacturas {
    Factura guardar(Factura factura);
    Optional<Factura> buscarPorId(int id);
    List<Factura> listarTodos();
    void eliminar(int id);
}
