package com.ut.catanddog.catanddog.dominio.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MascotaTest {

    @Test
    void constructorConParametros() {
        Dueño d = new Dueño(1, "Juan", "300");
        Mascota m = new Mascota(1, "Firulais", "Pastor", "Negro", d);
        assertEquals(1, m.getId());
        assertEquals("Firulais", m.getNombre());
        assertEquals("Pastor", m.getRaza());
        assertEquals("Negro", m.getColor());
        assertEquals(d, m.getDueño());
    }

    @Test
    void esAlergicoSi() {
        Mascota m = new Mascota(1, "A", "", "", null);
        m.setAlergico("SI");
        assertTrue(m.esAlergico());
    }

    @Test
    void esAlergicoNo() {
        Mascota m = new Mascota(1, "A", "", "", null);
        m.setAlergico("NO");
        assertFalse(m.esAlergico());
    }

    @Test
    void esAlergicoNull() {
        Mascota m = new Mascota(1, "A", "", "", null);
        assertFalse(m.esAlergico());
    }

    @Test
    void requiereAtencionEspecialSi() {
        Mascota m = new Mascota(1, "A", "", "", null);
        m.setAtencionEspecial("SI");
        assertTrue(m.requiereAtencionEspecial());
    }

    @Test
    void requiereAtencionEspecialNo() {
        Mascota m = new Mascota(1, "A", "", "", null);
        m.setAtencionEspecial("NO");
        assertFalse(m.requiereAtencionEspecial());
    }

    @Test
    void setYGetServicios() {
        Mascota m = new Mascota(1, "A", "", "", null);
        assertTrue(m.getServicios().isEmpty());
    }

    @Test
    void equalsPorId() {
        Mascota a = new Mascota(1, "A", "", "", null);
        Mascota b = new Mascota(1, "B", "", "", null);
        assertEquals(a, b);
    }

    @Test
    void notEqualsDistintoId() {
        Mascota a = new Mascota(1, "A", "", "", null);
        Mascota b = new Mascota(2, "A", "", "", null);
        assertNotEquals(a, b);
    }
}
