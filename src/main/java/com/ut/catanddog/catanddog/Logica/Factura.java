package com.ut.catanddog.catanddog.Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_FACTURA")
    private int id_factura;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_VENTA")
    private Date fecha_venta;

    private double subtotal;
    private double iva;

    @Column(name = "TOTAL_PAGAR")
    private double total_pagar;

    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DUENO_ID")
    private Dueño unDueño;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> listaServicios = new ArrayList<>();

    public Factura() {
    }

    public Factura(int id_factura, Date fecha_venta, double subtotal, double iva, double total_pagar, String estado, Dueño unDueño, List<Servicio> listaServicios) {
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

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

}
