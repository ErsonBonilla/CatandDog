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

public class AgendaJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public AgendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public AgendaJpaController() {
        this.emf = Persistence.createEntityManagerFactory(Configuracion.getPersistenceUnitName());
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AgendaJpaEntity entity) {
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

    public void edit(AgendaJpaEntity entity) throws Exception {
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
                if (findAgenda(id) == null) {
                    throw new NonexistentEntityException("The agenda with id " + id + " no longer exists.");
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
            AgendaJpaEntity entity;
            try {
                entity = em.getReference(AgendaJpaEntity.class, id);
                entity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agenda with id " + id + " no longer exists.", enfe);
            }
            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<AgendaJpaEntity> findAgendaEntities() {
        return findAgendaEntities(true, -1, -1);
    }

    public List<AgendaJpaEntity> findAgendaEntities(int maxResults, int firstResult) {
        return findAgendaEntities(false, maxResults, firstResult);
    }

    private List<AgendaJpaEntity> findAgendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<AgendaJpaEntity> cq = em.getCriteriaBuilder().createQuery(AgendaJpaEntity.class);
            cq.select(cq.from(AgendaJpaEntity.class));
            TypedQuery<AgendaJpaEntity> q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AgendaJpaEntity findAgenda(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AgendaJpaEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<AgendaJpaEntity> rt = cq.from(AgendaJpaEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            TypedQuery<Long> q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
