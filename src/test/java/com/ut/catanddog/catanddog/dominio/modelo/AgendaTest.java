package com.ut.catanddog.catanddog.dominio.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test
    void constructorConParametros() {
        Dueño d = new Dueño(1, "Juan", "300");
        Mascota m = new Mascota(1, "Firulais", "", "", d);
        Date fecha = new GregorianCalendar(2026, Calendar.JUNE, 20).getTime();
        Agenda a = new Agenda(1, "Vacunación", fecha, d, m);

        assertEquals(1, a.getId());
        assertEquals("Vacunación", a.getDescripcion());
        assertEquals(fecha, a.getFechaCita());
        assertEquals(d, a.getDueño());
        assertEquals(m, a.getMascota());
    }

    @Test
    void fechaFutura() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Agenda a = new Agenda(1, "", cal.getTime(), null, null);
        assertTrue(a.esFechaFutura());
    }

    @Test
    void fechaPasada() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -30);
        Agenda a = new Agenda(1, "", cal.getTime(), null, null);
        assertFalse(a.esFechaFutura());
    }

    @Test
    void fechaNull() {
        Agenda a = new Agenda(1, "", null, null, null);
        assertFalse(a.esFechaFutura());
    }

    @Test
    void setYGetCelular() {
        Agenda a = new Agenda(1, "", null, null, null);
        a.setCelularDueño("3001234567");
        assertEquals("3001234567", a.getCelularDueño());
    }

    @Test
    void notEqualsDistintoId() {
        Agenda a = new Agenda(1, "A", null, null, null);
        Agenda b = new Agenda(2, "A", null, null, null);
        assertNotEquals(a, b);
    }
}
