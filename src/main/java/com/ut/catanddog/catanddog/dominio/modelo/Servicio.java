package com.ut.catanddog.catanddog.dominio.modelo;

import java.util.Objects;

public class Servicio {

    private int id;
    private String nombre;
    private int cantidad;
    private double precio;
    private double porcentajeIva;
    private Mascota mascota;
    private Factura factura;

    public Servicio() {
    }

    public Servicio(int id, String nombre, int cantidad, double precio, double porcentajeIva) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.porcentajeIva = porcentajeIva;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(double porcentajeIva) {
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

    public double calcularSubtotal() {
        return precio * cantidad;
    }

    public double calcularIva() {
        return calcularSubtotal() * (porcentajeIva / 100.0);
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularIva();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servicio)) return false;
        Servicio servicio = (Servicio) o;
        return id == servicio.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
