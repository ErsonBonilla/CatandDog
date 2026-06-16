package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Agenda;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AGENDA")
public class AgendaJpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_AGENDA")
    private int id;

    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CITA")
    private Date fechaCita;

    @Column(name = "CELULAR_DUENO")
    private String celularDueño;

    @ManyToOne
    @JoinColumn(name = "DUENO_ID")
    private DueñoJpaEntity dueño;

    @ManyToOne
    @JoinColumn(name = "MASCOTA_ID")
    private MascotaJpaEntity mascota;

    public AgendaJpaEntity() {
    }

    public Agenda toDominio() {
        Agenda a = new Agenda(id, descripcion, fechaCita,
                dueño != null ? dueño.toDominio() : null,
                mascota != null ? mascota.toDominio() : null);
        a.setCelularDueño(celularDueño);
        return a;
    }

    public static AgendaJpaEntity fromDominio(Agenda agenda) {
        AgendaJpaEntity e = new AgendaJpaEntity();
        e.id = agenda.getId();
        e.descripcion = agenda.getDescripcion();
        e.fechaCita = agenda.getFechaCita();
        e.celularDueño = agenda.getCelularDueño();
        return e;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Date getFechaCita() { return fechaCita; }
    public void setFechaCita(Date fechaCita) { this.fechaCita = fechaCita; }
    public String getCelularDueño() { return celularDueño; }
    public void setCelularDueño(String celularDueño) { this.celularDueño = celularDueño; }
    public DueñoJpaEntity getDueño() { return dueño; }
    public void setDueño(DueñoJpaEntity dueño) { this.dueño = dueño; }
    public MascotaJpaEntity getMascota() { return mascota; }
    public void setMascota(MascotaJpaEntity mascota) { this.mascota = mascota; }
}
