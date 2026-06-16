package com.ut.catanddog.catanddog.Logica;

import com.ut.catanddog.catanddog.Logica.Dueño;
import com.ut.catanddog.catanddog.Logica.Mascota;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-06-16T13:54:03", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Agenda.class)
public class Agenda_ { 

    public static volatile SingularAttribute<Agenda, String> descripcion;
    public static volatile SingularAttribute<Agenda, String> celDueño;
    public static volatile SingularAttribute<Agenda, Mascota> unaMascota;
    public static volatile SingularAttribute<Agenda, Integer> id_agenda;
    public static volatile SingularAttribute<Agenda, Dueño> unDueño;
    public static volatile SingularAttribute<Agenda, Date> fecha_cita;

}