package com.ut.catanddog.catanddog.dominio.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    @Test
    void constructorConParametros() {
        Servicio s = new Servicio(1, "Baño", 2, 15000, 19.0);
        assertEquals(1, s.getId());
        assertEquals("Baño", s.getNombre());
        assertEquals(2, s.getCantidad());
        assertEquals(15000, s.getPrecio());
        assertEquals(19.0, s.getPorcentajeIva());
    }

    @Test
    void calcularSubtotal() {
        Servicio s = new Servicio(1, "Baño", 3, 10000, 19.0);
        assertEquals(30000, s.calcularSubtotal());
    }

    @Test
    void calcularSubtotalCero() {
        Servicio s = new Servicio(1, "Baño", 0, 10000, 19.0);
        assertEquals(0, s.calcularSubtotal());
    }

    @Test
    void calcularIva() {
        Servicio s = new Servicio(1, "Baño", 2, 10000, 19.0);
        assertEquals(3800, s.calcularIva(), 0.001);
    }

    @Test
    void calcularIvaCero() {
        Servicio s = new Servicio(1, "Baño", 2, 10000, 0.0);
        assertEquals(0, s.calcularIva(), 0.001);
    }

    @Test
    void calcularTotal() {
        Servicio s = new Servicio(1, "Baño", 2, 10000, 19.0);
        assertEquals(23800, s.calcularTotal(), 0.001);
    }

    @Test
    void setYGetAsociaciones() {
        Servicio s = new Servicio(1, "Baño", 1, 0, 0);
        Mascota m = new Mascota(1, "A", "", "", null);
        Factura f = new Factura(1, null, "Pagado", null);
        s.setMascota(m);
        s.setFactura(f);
        assertEquals(m, s.getMascota());
        assertEquals(f, s.getFactura());
    }

    @Test
    void notEqualsDistintoId() {
        Servicio a = new Servicio(1, "Baño", 1, 0, 0);
        Servicio b = new Servicio(2, "Baño", 1, 0, 0);
        assertNotEquals(a, b);
    }
}
