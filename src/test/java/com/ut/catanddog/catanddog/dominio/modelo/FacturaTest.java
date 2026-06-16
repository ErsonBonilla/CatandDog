package com.ut.catanddog.catanddog.dominio.modelo;

import java.util.Arrays;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    @Test
    void constructorConParametros() {
        Dueño d = new Dueño(1, "Juan", "300");
        Factura f = new Factura(1, new Date(), "Pendiente", d);
        assertEquals(1, f.getId());
        assertEquals("Pendiente", f.getEstado());
        assertEquals(d, f.getDueño());
        assertNotNull(f.getFechaVenta());
    }

    @Test
    void estaPagada() {
        Factura f = new Factura(1, null, "Pagado", null);
        assertTrue(f.estaPagada());
    }

    @Test
    void noEstaPagada() {
        Factura f = new Factura(1, null, "Pendiente", null);
        assertFalse(f.estaPagada());
    }

    @Test
    void estaPendiente() {
        Factura f = new Factura(1, null, "Pendiente", null);
        assertTrue(f.estaPendiente());
    }

    @Test
    void noEstaPendiente() {
        Factura f = new Factura(1, null, "Pagado", null);
        assertFalse(f.estaPendiente());
    }

    @Test
    void recalcularTotalesConServicios() {
        Dueño d = new Dueño(1, "Juan", "300");
        Factura f = new Factura(1, null, "Pendiente", d);

        Servicio s1 = new Servicio(1, "Baño", 2, 10000, 19.0);
        Servicio s2 = new Servicio(2, "Corte", 1, 20000, 19.0);

        f.setServicios(Arrays.asList(s1, s2));
        f.recalcularTotales();

        double expectedSubtotal = (10000 * 2) + (20000 * 1);
        double expectedIva = (20000 * 0.19) + (20000 * 0.19);
        assertEquals(expectedSubtotal, f.getSubtotal(), 0.001);
        assertEquals(expectedIva, f.getIva(), 0.001);
        assertEquals(expectedSubtotal + expectedIva, f.getTotalPagar(), 0.001);
    }

    @Test
    void recalcularTotalesSinServicios() {
        Factura f = new Factura(1, null, "Pendiente", null);
        f.recalcularTotales();
        assertEquals(0, f.getSubtotal(), 0.001);
        assertEquals(0, f.getIva(), 0.001);
        assertEquals(0, f.getTotalPagar(), 0.001);
    }

    @Test
    void notEqualsDistintoId() {
        Factura a = new Factura(1, null, "Pagado", null);
        Factura b = new Factura(2, null, "Pagado", null);
        assertNotEquals(a, b);
    }
}
