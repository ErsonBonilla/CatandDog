package com.ut.catanddog.catanddog.Logica;

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
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_AGENDA")
    private int id_agenda;

    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CITA")
    private Date fecha_cita;

    @Column(name = "CELULAR_DUENO")
    private String celDueño;

    @ManyToOne
    @JoinColumn(name = "DUENO_ID")
    private Dueño unDueño;

    @ManyToOne
    @JoinColumn(name = "MASCOTA_ID")
    private Mascota unaMascota;

    public Agenda() {
    }

    public Agenda(int id_agenda, String descripcion, Date fecha_cita, String celDueño, Dueño unDueño, Mascota unaMascota) {
        this.id_agenda = id_agenda;
        this.descripcion = descripcion;
        this.fecha_cita = fecha_cita;
        this.celDueño = celDueño;
        this.unDueño = unDueño;
        this.unaMascota = unaMascota;
    }

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getCelDueño() {
        return celDueño;
    }

    public void setCelDueño(String celDueño) {
        this.celDueño = celDueño;
    }

    public Dueño getUnDueño() {
        return unDueño;
    }

    public void setUnDueño(Dueño unDueño) {
        this.unDueño = unDueño;
    }

    public Mascota getUnaMascota() {
        return unaMascota;
    }

    public void setUnaMascota(Mascota unaMascota) {
        this.unaMascota = unaMascota;
    }

}
