package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Mascota;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MASCOTA")
public class MascotaJpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NUM_CLIENTE")
    private int id;

    private String nombre;
    private String raza;
    private String color;
    private String alergico;

    @Column(name = "ATENCION_ESPECIAL")
    private String atencionEspecial;

    private String observaciones;

    @Lob
    private byte[] imagen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DUENO_ID")
    private DueñoJpaEntity dueño;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicioJpaEntity> servicios = new ArrayList<>();

    public MascotaJpaEntity() {
    }

    public Mascota toDominio() {
        Mascota m = new Mascota(id, nombre, raza, color,
                dueño != null ? dueño.toDominio() : null);
        m.setAlergico(alergico);
        m.setAtencionEspecial(atencionEspecial);
        m.setObservaciones(observaciones);
        m.setImagen(imagen);
        if (servicios != null) {
            m.setServicios(servicios.stream()
                    .map(ServicioJpaEntity::toDominio)
                    .collect(Collectors.toList()));
        }
        return m;
    }

    public static MascotaJpaEntity fromDominio(Mascota mascota) {
        MascotaJpaEntity e = new MascotaJpaEntity();
        e.id = mascota.getId();
        e.nombre = mascota.getNombre();
        e.raza = mascota.getRaza();
        e.color = mascota.getColor();
        e.alergico = mascota.getAlergico();
        e.atencionEspecial = mascota.getAtencionEspecial();
        e.observaciones = mascota.getObservaciones();
        e.imagen = mascota.getImagen();
        if (mascota.getDueño() != null) {
            e.dueño = DueñoJpaEntity.fromDominio(mascota.getDueño());
        }
        return e;
    }

    public void actualizarDesdeDominio(Mascota mascota) {
        this.nombre = mascota.getNombre();
        this.raza = mascota.getRaza();
        this.color = mascota.getColor();
        this.alergico = mascota.getAlergico();
        this.atencionEspecial = mascota.getAtencionEspecial();
        this.observaciones = mascota.getObservaciones();
        this.imagen = mascota.getImagen();
        if (mascota.getDueño() != null) {
            if (this.dueño == null) {
                this.dueño = new DueñoJpaEntity();
            }
            this.dueño.actualizarDesdeDominio(mascota.getDueño());
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getAlergico() { return alergico; }
    public void setAlergico(String alergico) { this.alergico = alergico; }
    public String getAtencionEspecial() { return atencionEspecial; }
    public void setAtencionEspecial(String atencionEspecial) { this.atencionEspecial = atencionEspecial; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public byte[] getImagen() { return imagen; }
    public void setImagen(byte[] imagen) { this.imagen = imagen; }
    public DueñoJpaEntity getDueño() { return dueño; }
    public void setDueño(DueñoJpaEntity dueño) { this.dueño = dueño; }
    public List<ServicioJpaEntity> getServicios() { return servicios; }
    public void setServicios(List<ServicioJpaEntity> servicios) { this.servicios = servicios; }
}
