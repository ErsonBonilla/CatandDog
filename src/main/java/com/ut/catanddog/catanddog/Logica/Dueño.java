package com.ut.catanddog.catanddog.Logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DUENO")
public class Dueño implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DUENO")
    private int id_dueño;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CELULAR")
    private String celDueño;

    public Dueño() {
    }

    public Dueño(int id_dueño, String nombre, String celDueño) {
        this.id_dueño = id_dueño;
        this.nombre = nombre;
        this.celDueño = celDueño;
    }

    public int getId_dueño() {
        return id_dueño;
    }

    public void setId_dueño(int id_dueño) {
        this.id_dueño = id_dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelDueño() {
        return celDueño;
    }

    public void setCelDueño(String celDueño) {
        this.celDueño = celDueño;
    }

}
