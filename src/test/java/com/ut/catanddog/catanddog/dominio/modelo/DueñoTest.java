package com.ut.catanddog.catanddog.dominio.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DueñoTest {

    @Test
    void constructorConParametros() {
        Dueño d = new Dueño(1, "Juan", "3001234567");
        assertEquals(1, d.getId());
        assertEquals("Juan", d.getNombre());
        assertEquals("3001234567", d.getCelular());
    }

    @Test
    void constructorVacio() {
        Dueño d = new Dueño();
        assertNull(d.getNombre());
        assertNull(d.getCelular());
    }

    @Test
    void setYGet() {
        Dueño d = new Dueño();
        d.setId(5);
        d.setNombre("Ana");
        d.setCelular("3109876543");
        assertEquals(5, d.getId());
        assertEquals("Ana", d.getNombre());
        assertEquals("3109876543", d.getCelular());
    }

    @Test
    void celularValido() {
        assertTrue(new Dueño(1, "A", "3001234567").tieneCelularValido());
        assertTrue(new Dueño(1, "A", "1234567").tieneCelularValido());
    }

    @Test
    void celularInvalido() {
        assertFalse(new Dueño(1, "A", null).tieneCelularValido());
        assertFalse(new Dueño(1, "A", "").tieneCelularValido());
        assertFalse(new Dueño(1, "A", "12").tieneCelularValido());
        assertFalse(new Dueño(1, "A", "abc").tieneCelularValido());
    }

    @Test
    void equalsPorId() {
        Dueño a = new Dueño(1, "A", "300");
        Dueño b = new Dueño(1, "B", "301");
        assertEquals(a, b);
    }

    @Test
    void notEqualsDistintoId() {
        Dueño a = new Dueño(1, "A", "300");
        Dueño b = new Dueño(2, "A", "300");
        assertNotEquals(a, b);
    }

    @Test
    void hashCodeConsistente() {
        Dueño a = new Dueño(1, "A", "300");
        Dueño b = new Dueño(1, "B", "301");
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void toStringContieneNombre() {
        Dueño d = new Dueño(1, "Juan", "3001234567");
        assertTrue(d.toString().contains("Juan"));
        assertTrue(d.toString().contains("3001234567"));
    }
}
