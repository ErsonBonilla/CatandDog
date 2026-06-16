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

public class MascotaJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public MascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public MascotaJpaController() {
        this.emf = Persistence.createEntityManagerFactory(Configuracion.getPersistenceUnitName());
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MascotaJpaEntity entity) {
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

    public void edit(MascotaJpaEntity entity) throws Exception {
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
                if (findMascota(id) == null) {
                    throw new NonexistentEntityException("The mascota with id " + id + " no longer exists.");
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
            MascotaJpaEntity entity;
            try {
                entity = em.getReference(MascotaJpaEntity.class, id);
                entity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mascota with id " + id + " no longer exists.", enfe);
            }
            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<MascotaJpaEntity> findMascotaEntities() {
        return findMascotaEntities(true, -1, -1);
    }

    public List<MascotaJpaEntity> findMascotaEntities(int maxResults, int firstResult) {
        return findMascotaEntities(false, maxResults, firstResult);
    }

    private List<MascotaJpaEntity> findMascotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<MascotaJpaEntity> cq = em.getCriteriaBuilder().createQuery(MascotaJpaEntity.class);
            cq.select(cq.from(MascotaJpaEntity.class));
            TypedQuery<MascotaJpaEntity> q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public MascotaJpaEntity findMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MascotaJpaEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getMascotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<MascotaJpaEntity> rt = cq.from(MascotaJpaEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            TypedQuery<Long> q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
