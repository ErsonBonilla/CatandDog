package com.ut.catanddog.catanddog.dominio.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mascota {

    private int id;
    private String nombre;
    private String raza;
    private String color;
    private String alergico;
    private String atencionEspecial;
    private String observaciones;
    private byte[] imagen;
    private Dueño dueño;
    private List<Servicio> servicios = new ArrayList<>();

    public Mascota() {
    }

    public Mascota(int id, String nombre, String raza, String color, Dueño dueño) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.dueño = dueño;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencionEspecial() {
        return atencionEspecial;
    }

    public void setAtencionEspecial(String atencionEspecial) {
        this.atencionEspecial = atencionEspecial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public boolean requiereAtencionEspecial() {
        return "SI".equalsIgnoreCase(atencionEspecial);
    }

    public boolean esAlergico() {
        return "SI".equalsIgnoreCase(alergico);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mascota)) return false;
        Mascota mascota = (Mascota) o;
        return id == mascota.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
