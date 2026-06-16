package com.ut.catanddog.catanddog.aplicacion.servicios;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import com.ut.catanddog.catanddog.dominio.modelo.Factura;
import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import com.ut.catanddog.catanddog.dominio.modelo.Servicio;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioDueños;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioFacturas;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioMascotas;
import com.ut.catanddog.catanddog.dominio.puertos.RepositorioServicios;
import com.ut.catanddog.catanddog.infraestructura.pdf.ItextGeneradorFacturaPDF;
import java.util.Date;
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
class GestorFacturacionTest {

    @Mock
    RepositorioFacturas repoFacturas;
    @Mock
    RepositorioServicios repoServicios;
    @Mock
    RepositorioDueños repoDueños;
    @Mock
    RepositorioMascotas repoMascotas;
    @Mock
    ItextGeneradorFacturaPDF generadorPDF;

    @InjectMocks
    GestorFacturacion gestor;

    @Test
    void crearFacturaConServicios() {
        Dueño d = new Dueño(1, "Juan", "300");
        Servicio s = new Servicio(1, "Baño", 2, 10000, 19.0);
        when(repoFacturas.guardar(any(Factura.class))).thenAnswer(i -> i.getArgument(0));

        Factura resultado = gestor.crearFactura("Pendiente", new Date(), d, List.of(s));

        assertEquals("Pendiente", resultado.getEstado());
        assertEquals(d, resultado.getDueño());
        assertEquals(20000, resultado.getSubtotal(), 0.001);
        assertEquals(3800, resultado.getIva(), 0.001);
        assertEquals(23800, resultado.getTotalPagar(), 0.001);
    }

    @Test
    void obtenerUltimoIdFactura_SinFacturas() {
        when(repoFacturas.listarTodos()).thenReturn(List.of());
        assertEquals(0, gestor.obtenerUltimoIdFactura());
    }

    @Test
    void obtenerUltimoIdFactura_ConFacturas() {
        when(repoFacturas.listarTodos()).thenReturn(
                List.of(new Factura(5, null, "", null), new Factura(3, null, "", null)));
        assertEquals(5, gestor.obtenerUltimoIdFactura());
    }

    @Test
    void eliminarFactura() {
        gestor.eliminarFactura(1);
        verify(repoFacturas).eliminar(1);
    }
}
