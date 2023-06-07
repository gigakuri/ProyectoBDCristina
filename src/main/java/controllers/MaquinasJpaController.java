/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import controllers.exceptions.NonexistentEntityException;
import entities.Maquinas;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Gigak
 */
public class MaquinasJpaController implements Serializable {

    public MaquinasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Maquinas maquinas) {
        if (maquinas.getProductosList() == null) {
            maquinas.setProductosList(new ArrayList<Productos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Productos> attachedProductosList = new ArrayList<Productos>();
            for (Productos productosListProductosToAttach : maquinas.getProductosList()) {
                productosListProductosToAttach = em.getReference(productosListProductosToAttach.getClass(), productosListProductosToAttach.getIdProducto());
                attachedProductosList.add(productosListProductosToAttach);
            }
            maquinas.setProductosList(attachedProductosList);
            em.persist(maquinas);
            for (Productos productosListProductos : maquinas.getProductosList()) {
                Maquinas oldIdMaquinaOfProductosListProductos = productosListProductos.getIdMaquina();
                productosListProductos.setIdMaquina(maquinas);
                productosListProductos = em.merge(productosListProductos);
                if (oldIdMaquinaOfProductosListProductos != null) {
                    oldIdMaquinaOfProductosListProductos.getProductosList().remove(productosListProductos);
                    oldIdMaquinaOfProductosListProductos = em.merge(oldIdMaquinaOfProductosListProductos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Maquinas maquinas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquinas persistentMaquinas = em.find(Maquinas.class, maquinas.getIdMaquina());
            List<Productos> productosListOld = persistentMaquinas.getProductosList();
            List<Productos> productosListNew = maquinas.getProductosList();
            List<Productos> attachedProductosListNew = new ArrayList<Productos>();
            for (Productos productosListNewProductosToAttach : productosListNew) {
                productosListNewProductosToAttach = em.getReference(productosListNewProductosToAttach.getClass(), productosListNewProductosToAttach.getIdProducto());
                attachedProductosListNew.add(productosListNewProductosToAttach);
            }
            productosListNew = attachedProductosListNew;
            maquinas.setProductosList(productosListNew);
            maquinas = em.merge(maquinas);
            for (Productos productosListOldProductos : productosListOld) {
                if (!productosListNew.contains(productosListOldProductos)) {
                    productosListOldProductos.setIdMaquina(null);
                    productosListOldProductos = em.merge(productosListOldProductos);
                }
            }
            for (Productos productosListNewProductos : productosListNew) {
                if (!productosListOld.contains(productosListNewProductos)) {
                    Maquinas oldIdMaquinaOfProductosListNewProductos = productosListNewProductos.getIdMaquina();
                    productosListNewProductos.setIdMaquina(maquinas);
                    productosListNewProductos = em.merge(productosListNewProductos);
                    if (oldIdMaquinaOfProductosListNewProductos != null && !oldIdMaquinaOfProductosListNewProductos.equals(maquinas)) {
                        oldIdMaquinaOfProductosListNewProductos.getProductosList().remove(productosListNewProductos);
                        oldIdMaquinaOfProductosListNewProductos = em.merge(oldIdMaquinaOfProductosListNewProductos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = maquinas.getIdMaquina();
                if (findMaquinas(id) == null) {
                    throw new NonexistentEntityException("The maquinas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquinas maquinas;
            try {
                maquinas = em.getReference(Maquinas.class, id);
                maquinas.getIdMaquina();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The maquinas with id " + id + " no longer exists.", enfe);
            }
            List<Productos> productosList = maquinas.getProductosList();
            for (Productos productosListProductos : productosList) {
                productosListProductos.setIdMaquina(null);
                productosListProductos = em.merge(productosListProductos);
            }
            em.remove(maquinas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Maquinas> findMaquinasEntities() {
        return findMaquinasEntities(true, -1, -1);
    }

    public List<Maquinas> findMaquinasEntities(int maxResults, int firstResult) {
        return findMaquinasEntities(false, maxResults, firstResult);
    }

    private List<Maquinas> findMaquinasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Maquinas.class));
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

    public Maquinas findMaquinas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Maquinas.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaquinasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Maquinas> rt = cq.from(Maquinas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public String[] verMaquinas() throws NonexistentEntityException {
        List<Maquinas> listaMaquinas = findMaquinasEntities();
        String[] maquinas = new String[listaMaquinas.size()];

        for (int i = 1; i < listaMaquinas.size(); i++) {
            maquinas[i] = listaMaquinas.get(i).toString();
        }

        return maquinas;

    }
    
}
