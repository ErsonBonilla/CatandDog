package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Servicio;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioServicios;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GestorServiciosTest {

    @Mock
    RepositorioServicios repositorio;

    @InjectMocks
    GestorServicios gestor;

    @Test
    void crearServicio() {
        when(repositorio.guardar(any(Servicio.class))).thenAnswer(i -> i.getArgument(0));

        Servicio resultado = gestor.crearServicio("Baño", 2, 15000, 19.0);

        assertEquals("Baño", resultado.getNombre());
        assertEquals(2, resultado.getCantidad());
        assertEquals(15000, resultado.getPrecio());
        assertEquals(19.0, resultado.getPorcentajeIva());
    }

    @Test
    void buscarPorNombreExistente() {
        Servicio s = new Servicio(1, "Baño", 1, 10000, 19);
        when(repositorio.listarTodos()).thenReturn(List.of(s));

        Optional<Servicio> resultado = gestor.buscarPorNombre("Baño");
        assertTrue(resultado.isPresent());
        assertEquals("Baño", resultado.get().getNombre());
    }

    @Test
    void buscarPorNombreInexistente() {
        when(repositorio.listarTodos()).thenReturn(List.of());
        assertTrue(gestor.buscarPorNombre("Inexistente").isEmpty());
    }

    @Test
    void listarTodos() {
        when(repositorio.listarTodos()).thenReturn(List.of(new Servicio(1, "A", 1, 0, 0)));
        assertEquals(1, gestor.listarTodos().size());
    }

    @Test
    void eliminarServicio() {
        gestor.eliminarServicio(1);
        verify(repositorio).eliminar(1);
    }
}
