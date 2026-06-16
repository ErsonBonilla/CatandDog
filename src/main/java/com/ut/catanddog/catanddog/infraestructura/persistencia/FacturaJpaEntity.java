package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.dominio.modelo.Factura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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
public class FacturaJpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_FACTURA")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_VENTA")
    private Date fechaVenta;

    private double subtotal;
    private double iva;

    @Column(name = "TOTAL_PAGAR")
    private double totalPagar;

    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DUENO_ID")
    private DueñoJpaEntity dueño;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicioJpaEntity> servicios = new ArrayList<>();

    public FacturaJpaEntity() {
    }

    public Factura toDominio() {
        Factura f = new Factura(id, fechaVenta, estado,
                dueño != null ? dueño.toDominio() : null);
        f.setSubtotal(subtotal);
        f.setIva(iva);
        f.setTotalPagar(totalPagar);
        if (servicios != null) {
            f.setServicios(servicios.stream()
                    .map(ServicioJpaEntity::toDominio)
                    .collect(Collectors.toList()));
        }
        return f;
    }

    public static FacturaJpaEntity fromDominio(Factura factura) {
        FacturaJpaEntity e = new FacturaJpaEntity();
        e.id = factura.getId();
        e.fechaVenta = factura.getFechaVenta();
        e.subtotal = factura.getSubtotal();
        e.iva = factura.getIva();
        e.totalPagar = factura.getTotalPagar();
        e.estado = factura.getEstado();
        if (factura.getDueño() != null) {
            e.dueño = DueñoJpaEntity.fromDominio(factura.getDueño());
        }
        if (factura.getServicios() != null) {
            e.servicios = factura.getServicios().stream()
                    .map(ServicioJpaEntity::fromDominio)
                    .collect(java.util.stream.Collectors.toList());
        }
        return e;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(Date fechaVenta) { this.fechaVenta = fechaVenta; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public double getIva() { return iva; }
    public void setIva(double iva) { this.iva = iva; }
    public double getTotalPagar() { return totalPagar; }
    public void setTotalPagar(double totalPagar) { this.totalPagar = totalPagar; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public DueñoJpaEntity getDueño() { return dueño; }
    public void setDueño(DueñoJpaEntity dueño) { this.dueño = dueño; }
    public List<ServicioJpaEntity> getServicios() { return servicios; }
    public void setServicios(List<ServicioJpaEntity> servicios) { this.servicios = servicios; }
}
