package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioDueños;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioMascotas;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GestorMascotasTest {

    @Mock
    RepositorioMascotas repoMascotas;

    @Mock
    RepositorioDueños repoDueños;

    @InjectMocks
    GestorMascotas gestor;

    @Test
    void registrarMascota() {
        Dueño dueño = new Dueño(1, "Juan", "300");
        when(repoMascotas.guardar(any(Mascota.class))).thenAnswer(i -> i.getArgument(0));

        Mascota resultado = gestor.registrarMascota("Firulais", "Pastor", "Negro",
                "NO", "NO", "Sano", null, dueño);

        assertEquals("Firulais", resultado.getNombre());
        assertEquals("Pastor", resultado.getRaza());
        assertEquals(dueño, resultado.getDueño());
        verify(repoMascotas).guardar(any(Mascota.class));
    }

    @Test
    void buscarPorId() {
        Mascota m = new Mascota(1, "Firulais", "", "", new Dueño(1, "Juan", "300"));
        when(repoMascotas.buscarPorId(1)).thenReturn(Optional.of(m));
        assertTrue(gestor.buscarPorId(1).isPresent());
    }

    @Test
    void eliminarMascota() {
        gestor.eliminarMascota(1);
        verify(repoMascotas).eliminar(1);
    }
}
