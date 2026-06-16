package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Servicio;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICIO")
public class ServicioJpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_SERVICIO")
    private int id;

    private String nombre;
    private int cantidad;
    private double precio;

    @Column(name = "PORCENTAJE_IVA")
    private double porcentajeIva;

    @ManyToOne
    @JoinColumn(name = "MASCOTA_ID")
    private MascotaJpaEntity mascota;

    @ManyToOne
    @JoinColumn(name = "FACTURA_ID")
    private FacturaJpaEntity factura;

    public ServicioJpaEntity() {
    }

    public Servicio toDominio() {
        Servicio s = new Servicio(id, nombre, cantidad, precio, porcentajeIva);
        return s;
    }

    public static ServicioJpaEntity fromDominio(Servicio servicio) {
        ServicioJpaEntity e = new ServicioJpaEntity();
        e.id = servicio.getId();
        e.nombre = servicio.getNombre();
        e.cantidad = servicio.getCantidad();
        e.precio = servicio.getPrecio();
        e.porcentajeIva = servicio.getPorcentajeIva();
        return e;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public double getPorcentajeIva() { return porcentajeIva; }
    public void setPorcentajeIva(double porcentajeIva) { this.porcentajeIva = porcentajeIva; }
    public MascotaJpaEntity getMascota() { return mascota; }
    public void setMascota(MascotaJpaEntity mascota) { this.mascota = mascota; }
    public FacturaJpaEntity getFactura() { return factura; }
    public void setFactura(FacturaJpaEntity factura) { this.factura = factura; }
}
