package com.ut.catanddog.catanddog.Logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



/**
 *
 * @author User
 */
@Entity
public class Servicio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_servicio;
    private String nombre;
    private int cantidad;
    private int precio;
    private int porcentajeIva;
    @ManyToOne
    private Mascota masco;
    @ManyToOne
    private Factura factu;
 
    public Servicio() {
    }

    public Servicio(int id_servicio, String nombre, int cantidad, int precio, int porcentajeIva, Mascota masco, Factura factu) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.porcentajeIva = porcentajeIva;
        this.masco = masco;
        this.factu = factu;
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

    public Mascota getMasco() {
        return masco;
    }

    public void setMasco(Mascota masco) {
        this.masco = masco;
    }

    public Factura getFactu() {
        return factu;
    }

    public void setFactu(Factura factu) {
        this.factu = factu;
    }  
   
} 