package com.ut.catanddog.catanddog.Logica;

import com.ut.catanddog.catanddog.Logica.Factura;
import com.ut.catanddog.catanddog.Logica.Mascota;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-06-16T13:54:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, Integer> precio;
    public static volatile SingularAttribute<Servicio, Factura> factura;
    public static volatile SingularAttribute<Servicio, Integer> porcentajeIva;
    public static volatile SingularAttribute<Servicio, Mascota> mascota;
    public static volatile SingularAttribute<Servicio, Integer> cantidad;
    public static volatile SingularAttribute<Servicio, Integer> id_servicio;
    public static volatile SingularAttribute<Servicio, String> nombre;

}