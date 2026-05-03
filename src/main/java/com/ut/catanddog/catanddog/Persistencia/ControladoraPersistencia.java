package com.ut.catanddog.catanddog.Persistencia;

import com.ut.catanddog.catanddog.Logica.Agenda;
import com.ut.catanddog.catanddog.Logica.Dueño;
import com.ut.catanddog.catanddog.Logica.Mascota;
import com.ut.catanddog.catanddog.Logica.Servicio;
import com.ut.catanddog.catanddog.Logica.Factura;
import com.ut.catanddog.catanddog.Persistencia.exceptions.NonexistentEntityException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    AgendaJpaController agendaJpa = new AgendaJpaController();
    DueñoJpaController dueñoJpa = new DueñoJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();
    ServicioJpaController serviJpa = new ServicioJpaController();
    FacturaJpaController factuJpa = new FacturaJpaController();
    

    public void guardar(Dueño dueño, Mascota masco) {
        //crear en la BD el Dueño
        dueñoJpa.create(dueño);
        //crear en la BD la Mascota;
        mascoJpa.create(masco);   
    }
   
    public List<Mascota> traerMascotas() {
        
        return mascoJpa.findMascotaEntities();
        
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
       return mascoJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Dueño traerDueño(int id_dueño) {
        return dueñoJpa.findDueño(id_dueño);
    }

    public void modificarDueño(Dueño dueño) {
        try {
            dueñoJpa.edit(dueño);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearServicio(Servicio servi) {
        //crear en la BD el servicio;
        serviJpa.create(servi);
    }
        public void crearFactura(Factura factu) {
        //crear en la BD el servicio;
        factuJpa.create(factu);
    }
             public void crearAgenda(Agenda agenda) {
        //crear en la BD el servicio;
        agendaJpa.create(agenda);
    }
            public Agenda traerAgenda(int id_agenda) {
        return agendaJpa.findAgenda(id_agenda);
    }
        
       public void borrarFactura(int id_factura) {
        try {
            factuJpa.destroy(id_factura);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void borrarAgenda(int id_agenda) {
        try {
            agendaJpa.destroy(id_agenda);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
           
           public void modificarFactura(Factura factu) {
         try {
            factuJpa.edit(factu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
                  
           public void modificarAgenda(Agenda agenda) {
         try {
            agendaJpa.edit(agenda);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        

    public void borrarServicio(int id_servicio) {
        try {
            serviJpa.destroy(id_servicio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarServicio(Servicio servi) {
         try {
            serviJpa.edit(servi);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public LinkedList<Servicio> traerListaServicios() {
            List<Servicio> lista = serviJpa.findServicioEntities();
            LinkedList<Servicio> listaServicios = new LinkedList(lista);
            return listaServicios;
        }


    public void crearMascota(Mascota masco) {
       //crear en la BD el servicio;
        mascoJpa.create(masco);
    }

    public void crearDueño(Dueño dueño) {
        //crear en la BD el servicio;
        dueñoJpa.create(dueño);
    }

    public void editarMascota(Mascota masco) {
       try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Factura traerFactura(int id_factura) {
        return factuJpa.findFactura(id_factura);
    }

    public void editarFactura(Factura factu) {
      try {
            factuJpa.edit(factu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarfactura(Factura factu, Servicio servi) {
             factuJpa.create(factu);
             serviJpa.create(servi);
    }

    public Dueño buscarDueñoPorNombre(String nombreDueño) {
          List<Dueño> dueños = dueñoJpa.findDueñoEntities();
    for (Dueño dueño : dueños) {
        if (dueño.getNombre().equals(nombreDueño)) {
            return dueño;
        }
    }
    return null;
    }

    public void guardarCita(Agenda agenda) {
               //crear en la BD el Dueño
        agendaJpa.create(agenda);
    }

    public List<Mascota> traerMascotas2() {
       return mascoJpa.findMascotaEntities();
    }

    public Mascota buscarMascotaPorNombre(String mascota) {
                 List<Mascota> mascotas= mascoJpa.findMascotaEntities();
    for (Mascota masco : mascotas) {
        if (masco.getNombre().equals(mascota)) {
            return masco;
        }
    }
    return null;
    }
    
    public List<Factura> traerFacturas() {
    return factuJpa.findFacturaEntities();
}

   
}
