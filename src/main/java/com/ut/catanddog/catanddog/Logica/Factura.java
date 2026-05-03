package com.ut.catanddog.catanddog.Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
public class Factura implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_factura;
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;
    private double subtotal;
    private double iva;
    private double total_pagar;
    private String estado;
    
    @OneToOne
    private Dueño unDueño;
    
    @OneToMany(mappedBy="factu")
    private LinkedList<Servicio> listaServicios;

    public Factura() {
    }

    public Factura(int id_factura, Date fecha_venta, double subtotal, double iva, double total_pagar, String estado, Dueño unDueño, LinkedList<Servicio> listaServicios) {
        this.id_factura = id_factura;
        this.fecha_venta = fecha_venta;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total_pagar = total_pagar;
        this.estado = estado;
        this.unDueño = unDueño;
        this.listaServicios = listaServicios;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(double total_pagar) {
        this.total_pagar = total_pagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Dueño getUnDueño() {
        return unDueño;
    }

    public void setUnDueño(Dueño unDueño) {
        this.unDueño = unDueño;
    }

    public LinkedList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(LinkedList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }   
    
}
