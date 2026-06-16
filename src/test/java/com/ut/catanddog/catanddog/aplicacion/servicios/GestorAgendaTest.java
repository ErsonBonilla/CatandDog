package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Agenda;
import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioAgendas;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GestorAgendaTest {

    @Mock
    RepositorioAgendas repositorio;

    @InjectMocks
    GestorAgenda gestor;

    @Test
    void programarCita() {
        Dueño d = new Dueño(1, "Juan", "300");
        Mascota m = new Mascota(1, "Firulais", "", "", d);
        Date fecha = new Date();

        when(repositorio.guardar(any(Agenda.class))).thenAnswer(i -> i.getArgument(0));

        Agenda resultado = gestor.programarCita("Vacunación", fecha, "300", d, m);

        assertEquals("Vacunación", resultado.getDescripcion());
        assertEquals(fecha, resultado.getFechaCita());
        assertEquals("300", resultado.getCelularDueño());
        verify(repositorio).guardar(any(Agenda.class));
    }
}
