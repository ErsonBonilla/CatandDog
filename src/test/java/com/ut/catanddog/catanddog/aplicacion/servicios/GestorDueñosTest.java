package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioDueños;
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
class GestorDueñosTest {

    @Mock
    RepositorioDueños repositorio;

    @InjectMocks
    GestorDueños gestor;

    @Test
    void registrarDueño() {
        when(repositorio.guardar(any(Dueño.class))).thenAnswer(i -> i.getArgument(0));

        Dueño resultado = gestor.registrarDueño("Juan", "3001234567");

        assertEquals("Juan", resultado.getNombre());
        assertEquals("3001234567", resultado.getCelular());
        verify(repositorio).guardar(any(Dueño.class));
    }

    @Test
    void buscarPorId_Existente() {
        Dueño dueño = new Dueño(1, "Ana", "310");
        when(repositorio.buscarPorId(1)).thenReturn(Optional.of(dueño));

        Optional<Dueño> resultado = gestor.buscarPorId(1);

        assertTrue(resultado.isPresent());
        assertEquals("Ana", resultado.get().getNombre());
    }

    @Test
    void buscarPorId_Inexistente() {
        when(repositorio.buscarPorId(99)).thenReturn(Optional.empty());
        assertTrue(gestor.buscarPorId(99).isEmpty());
    }

    @Test
    void buscarPorNombre() {
        when(repositorio.buscarPorNombre("Juan")).thenReturn(Optional.of(new Dueño(1, "Juan", "300")));
        assertTrue(gestor.buscarPorNombre("Juan").isPresent());
    }

    @Test
    void listarTodos() {
        when(repositorio.listarTodos()).thenReturn(List.of(new Dueño(1, "A", "1"), new Dueño(2, "B", "2")));
        assertEquals(2, gestor.listarTodos().size());
    }

    @Test
    void eliminarDueño() {
        gestor.eliminarDueño(1);
        verify(repositorio).eliminar(1);
    }

    @Test
    void actualizarDueñoLanzaExcepcionSiNoExiste() {
        when(repositorio.buscarPorId(99)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> gestor.actualizarDueño(99, "X", "0"));
    }
}
