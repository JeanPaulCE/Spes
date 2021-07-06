/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Controlador.JPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ucr.ac.cr.spesv2.Controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.spesv2.Controlador.exceptions.PreexistingEntityException;
import ucr.ac.cr.spesv2.Modelo.Colaborador;
import ucr.ac.cr.spesv2.Modelo.Perfil;
import ucr.ac.cr.spesv2.Modelo.Usuario;

/**
 *
 * @author jpcdl
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Colaborador colaboradorId = usuario.getColaboradorId();
            if (colaboradorId != null) {
                colaboradorId = em.getReference(colaboradorId.getClass(), colaboradorId.getId());
                usuario.setColaboradorId(colaboradorId);
            }
            Perfil perfilId = usuario.getPerfilId();
            if (perfilId != null) {
                perfilId = em.getReference(perfilId.getClass(), perfilId.getId());
                usuario.setPerfilId(perfilId);
            }
            em.persist(usuario);
            if (colaboradorId != null) {
                colaboradorId.getUsuarioCollection().add(usuario);
                colaboradorId = em.merge(colaboradorId);
            }
            if (perfilId != null) {
                perfilId.getUsuarioCollection().add(usuario);
                perfilId = em.merge(perfilId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getNombre()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getNombre());
            Colaborador colaboradorIdOld = persistentUsuario.getColaboradorId();
            Colaborador colaboradorIdNew = usuario.getColaboradorId();
            Perfil perfilIdOld = persistentUsuario.getPerfilId();
            Perfil perfilIdNew = usuario.getPerfilId();
            if (colaboradorIdNew != null) {
                colaboradorIdNew = em.getReference(colaboradorIdNew.getClass(), colaboradorIdNew.getId());
                usuario.setColaboradorId(colaboradorIdNew);
            }
            if (perfilIdNew != null) {
                perfilIdNew = em.getReference(perfilIdNew.getClass(), perfilIdNew.getId());
                usuario.setPerfilId(perfilIdNew);
            }
            usuario = em.merge(usuario);
            if (colaboradorIdOld != null && !colaboradorIdOld.equals(colaboradorIdNew)) {
                colaboradorIdOld.getUsuarioCollection().remove(usuario);
                colaboradorIdOld = em.merge(colaboradorIdOld);
            }
            if (colaboradorIdNew != null && !colaboradorIdNew.equals(colaboradorIdOld)) {
                colaboradorIdNew.getUsuarioCollection().add(usuario);
                colaboradorIdNew = em.merge(colaboradorIdNew);
            }
            if (perfilIdOld != null && !perfilIdOld.equals(perfilIdNew)) {
                perfilIdOld.getUsuarioCollection().remove(usuario);
                perfilIdOld = em.merge(perfilIdOld);
            }
            if (perfilIdNew != null && !perfilIdNew.equals(perfilIdOld)) {
                perfilIdNew.getUsuarioCollection().add(usuario);
                perfilIdNew = em.merge(perfilIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuario.getNombre();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
//            Colaborador colaboradorId = usuario.getColaboradorId();
//            if (colaboradorId != null) {
//                colaboradorId.getUsuarioCollection().remove(usuario);
//                colaboradorId = em.merge(colaboradorId);
//            }
//            Perfil perfilId = usuario.getPerfilId();
//            if (perfilId != null) {
//                perfilId.getUsuarioCollection().remove(usuario);
//                perfilId = em.merge(perfilId);
//            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
