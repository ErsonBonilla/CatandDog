package com.ut.catanddog.catanddog.Logica;

import com.ut.catanddog.catanddog.Logica.Dueño;
import com.ut.catanddog.catanddog.Logica.Servicio;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-06-16T13:54:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Mascota.class)
public class Mascota_ { 

    public static volatile SingularAttribute<Mascota, Integer> num_cliente;
    public static volatile SingularAttribute<Mascota, String> raza;
    public static volatile SingularAttribute<Mascota, String> color;
    public static volatile SingularAttribute<Mascota, String> alergico;
    public static volatile SingularAttribute<Mascota, String> observaciones;
    public static volatile SingularAttribute<Mascota, byte[]> imagen;
    public static volatile SingularAttribute<Mascota, String> atencion_especial;
    public static volatile SingularAttribute<Mascota, Dueño> unDueño;
    public static volatile ListAttribute<Mascota, Servicio> listaServicios;
    public static volatile SingularAttribute<Mascota, String> nombre;

}