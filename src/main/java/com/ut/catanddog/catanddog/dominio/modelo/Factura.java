package com.ut.catanddog.catanddog.dominio.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Factura {

    private int id;
    private Date fechaVenta;
    private double subtotal;
    private double iva;
    private double totalPagar;
    private String estado;
    private Dueño dueño;
    private List<Servicio> servicios = new ArrayList<>();

    public Factura() {
    }

    public Factura(int id, Date fechaVenta, String estado, Dueño dueño) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.dueño = dueño;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public void recalcularTotales() {
        this.subtotal = servicios.stream()
                .mapToDouble(Servicio::calcularSubtotal)
                .sum();
        this.iva = servicios.stream()
                .mapToDouble(Servicio::calcularIva)
                .sum();
        this.totalPagar = this.subtotal + this.iva;
    }

    public boolean estaPagada() {
        return "Pagado".equalsIgnoreCase(estado);
    }

    public boolean estaPendiente() {
        return "Pendiente".equalsIgnoreCase(estado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura)) return false;
        Factura factura = (Factura) o;
        return id == factura.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
