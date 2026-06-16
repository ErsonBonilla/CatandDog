package com.ut.catanddog.catanddog.infraestructura.persistencia;

import com.ut.catanddog.catanddog.infraestructura.config.Configuracion;
import com.ut.catanddog.catanddog.infraestructura.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class FacturaJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public FacturaJpaController() {
        this.emf = Persistence.createEntityManagerFactory(Configuracion.getPersistenceUnitName());
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FacturaJpaEntity entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(FacturaJpaEntity entity) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = entity.getId();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FacturaJpaEntity entity;
            try {
                entity = em.getReference(FacturaJpaEntity.class, id);
                entity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<FacturaJpaEntity> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<FacturaJpaEntity> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<FacturaJpaEntity> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<FacturaJpaEntity> cq = em.getCriteriaBuilder().createQuery(FacturaJpaEntity.class);
            cq.select(cq.from(FacturaJpaEntity.class));
            TypedQuery<FacturaJpaEntity> q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public FacturaJpaEntity findFactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FacturaJpaEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<FacturaJpaEntity> rt = cq.from(FacturaJpaEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            TypedQuery<Long> q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
