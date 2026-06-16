package com.ut.catanddog.catanddog.Logica;

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
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_SERVICIO")
    private int id_servicio;

    private String nombre;
    private int cantidad;
    private int precio;

    @Column(name = "PORCENTAJE_IVA")
    private int porcentajeIva;

    @ManyToOne
    @JoinColumn(name = "MASCOTA_ID")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "FACTURA_ID")
    private Factura factura;

    public Servicio() {
    }

    public Servicio(int id_servicio, String nombre, int cantidad, int precio, int porcentajeIva, Mascota mascota, Factura factura) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.porcentajeIva = porcentajeIva;
        this.mascota = mascota;
        this.factura = factura;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

}
