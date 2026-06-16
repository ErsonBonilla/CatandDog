package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Dueño;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DUENO")
public class DueñoJpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DUENO")
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CELULAR")
    private String celular;

    public DueñoJpaEntity() {
    }

    public Dueño toDominio() {
        Dueño d = new Dueño(id, nombre, celular);
        return d;
    }

    public static DueñoJpaEntity fromDominio(Dueño dueño) {
        DueñoJpaEntity e = new DueñoJpaEntity();
        e.id = dueño.getId();
        e.nombre = dueño.getNombre();
        e.celular = dueño.getCelular();
        return e;
    }

    public void actualizarDesdeDominio(Dueño dueño) {
        this.nombre = dueño.getNombre();
        this.celular = dueño.getCelular();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
}
