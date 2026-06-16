package com.ut.catanddog.catanddog.dominio.modelo;

import java.util.Objects;

public class Dueño {

    private int id;
    private String nombre;
    private String celular;

    public Dueño() {
    }

    public Dueño(int id, String nombre, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean tieneCelularValido() {
        return celular != null && celular.matches("\\d{7,15}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dueño)) return false;
        Dueño dueño = (Dueño) o;
        return id == dueño.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nombre + " (" + celular + ")";
    }
}
