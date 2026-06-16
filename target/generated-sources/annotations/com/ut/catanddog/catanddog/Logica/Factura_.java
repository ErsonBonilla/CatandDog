package com.ut.catanddog.catanddog.Logica;

import com.ut.catanddog.catanddog.Logica.Dueño;
import com.ut.catanddog.catanddog.Logica.Servicio;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-06-16T13:54:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Integer> id_factura;
    public static volatile SingularAttribute<Factura, String> estado;
    public static volatile SingularAttribute<Factura, Double> iva;
    public static volatile SingularAttribute<Factura, Double> subtotal;
    public static volatile SingularAttribute<Factura, Dueño> unDueño;
    public static volatile ListAttribute<Factura, Servicio> listaServicios;
    public static volatile SingularAttribute<Factura, Date> fecha_venta;
    public static volatile SingularAttribute<Factura, Double> total_pagar;

}