package com.ut.catanddog.catanddog.dominio.puertos;

import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import java.util.List;
import java.util.Optional;

public interface RepositorioMascotas {
    Mascota guardar(Mascota mascota);
    Optional<Mascota> buscarPorId(int id);
    Optional<Mascota> buscarPorNombre(String nombre);
    List<Mascota> listarTodos();
    void eliminar(int id);
}
