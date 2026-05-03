
package com.ut.catanddog.catanddog.Logica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_cliente;
    private String nombre;
    private String raza;
    private String color;
    private String alergico;
    private String atencion_especial;
    private String observaciones;
    @Lob
    private byte[] imagen;
    @OneToOne
    private Dueño unDueño;
    @OneToMany(mappedBy="masco")
    private LinkedList<Servicio> listaServicios;
    //alt+ins
    public Mascota() {
    }

    public Mascota(int num_cliente, String nombre, String raza, String color, String alergico, String atencion_especial, String observaciones, byte[] imagen, Dueño unDueño, LinkedList<Servicio> listaServicios) {
        this.num_cliente = num_cliente;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencion_especial = atencion_especial;
        this.observaciones = observaciones;
        this.imagen = imagen;
        this.unDueño = unDueño;
        this.listaServicios = listaServicios;
    }
    
    // Constructor sin imagen

    public Mascota(int num_cliente, String nombre, String raza, String color, String alergico, String atencion_especial, String observaciones, Dueño unDueño, LinkedList<Servicio> listaServicios) {
        this.num_cliente = num_cliente;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencion_especial = atencion_especial;
        this.observaciones = observaciones;
        this.unDueño = unDueño;
        this.listaServicios = listaServicios;
    }
 


    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencion_especial() {
        return atencion_especial;
    }

    public void setAtencion_especial(String atencion_especial) {
        this.atencion_especial = atencion_especial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
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
