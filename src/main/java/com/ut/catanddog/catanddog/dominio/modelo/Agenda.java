package com.ut.catanddog.catanddog.dominio.modelo;

import java.util.Date;
import java.util.Objects;

public class Agenda {

    private int id;
    private String descripcion;
    private Date fechaCita;
    private String celularDueño;
    private Dueño dueño;
    private Mascota mascota;

    public Agenda() {
    }

    public Agenda(int id, String descripcion, Date fechaCita, Dueño dueño, Mascota mascota) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCita = fechaCita;
        this.dueño = dueño;
        this.mascota = mascota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getCelularDueño() {
        return celularDueño;
    }

    public void setCelularDueño(String celularDueño) {
        this.celularDueño = celularDueño;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public boolean esFechaFutura() {
        return fechaCita != null && fechaCita.after(new Date());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agenda)) return false;
        Agenda agenda = (Agenda) o;
        return id == agenda.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
