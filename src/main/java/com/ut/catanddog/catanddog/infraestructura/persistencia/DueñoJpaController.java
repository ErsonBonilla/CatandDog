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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DueñoJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public DueñoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public DueñoJpaController() {
        this.emf = Persistence.createEntityManagerFactory(Configuracion.getPersistenceUnitName());
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DueñoJpaEntity entity) {
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

    public void edit(DueñoJpaEntity entity) throws Exception {
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
                if (findDueño(id) == null) {
                    throw new NonexistentEntityException("The dueño with id " + id + " no longer exists.");
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
            DueñoJpaEntity entity;
            try {
                entity = em.getReference(DueñoJpaEntity.class, id);
                entity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dueño with id " + id + " no longer exists.", enfe);
            }
            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<DueñoJpaEntity> findDueñoEntities() {
        return findDueñoEntities(true, -1, -1);
    }

    public List<DueñoJpaEntity> findDueñoEntities(int maxResults, int firstResult) {
        return findDueñoEntities(false, maxResults, firstResult);
    }

    private List<DueñoJpaEntity> findDueñoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DueñoJpaEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public DueñoJpaEntity findDueño(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DueñoJpaEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getDueñoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DueñoJpaEntity> rt = cq.from(DueñoJpaEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
