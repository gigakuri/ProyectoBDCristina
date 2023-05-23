/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Maquinas;
import entities.Productos;
import entities.Ventas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cristina
 */
public class ProductosJpaController implements Serializable {

    public ProductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productos productos) {
        if (productos.getVentasList() == null) {
            productos.setVentasList(new ArrayList<Ventas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquinas idMaquina = productos.getIdMaquina();
            if (idMaquina != null) {
                idMaquina = em.getReference(idMaquina.getClass(), idMaquina.getIdMaquina());
                productos.setIdMaquina(idMaquina);
            }
            List<Ventas> attachedVentasList = new ArrayList<Ventas>();
            for (Ventas ventasListVentasToAttach : productos.getVentasList()) {
                ventasListVentasToAttach = em.getReference(ventasListVentasToAttach.getClass(), ventasListVentasToAttach.getIdVenta());
                attachedVentasList.add(ventasListVentasToAttach);
            }
            productos.setVentasList(attachedVentasList);
            em.persist(productos);
            if (idMaquina != null) {
                idMaquina.getProductosList().add(productos);
                idMaquina = em.merge(idMaquina);
            }
            for (Ventas ventasListVentas : productos.getVentasList()) {
                Productos oldIdProductoOfVentasListVentas = ventasListVentas.getIdProducto();
                ventasListVentas.setIdProducto(productos);
                ventasListVentas = em.merge(ventasListVentas);
                if (oldIdProductoOfVentasListVentas != null) {
                    oldIdProductoOfVentasListVentas.getVentasList().remove(ventasListVentas);
                    oldIdProductoOfVentasListVentas = em.merge(oldIdProductoOfVentasListVentas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productos productos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productos persistentProductos = em.find(Productos.class, productos.getIdProducto());
            Maquinas idMaquinaOld = persistentProductos.getIdMaquina();
            Maquinas idMaquinaNew = productos.getIdMaquina();
            List<Ventas> ventasListOld = persistentProductos.getVentasList();
            List<Ventas> ventasListNew = productos.getVentasList();
            List<String> illegalOrphanMessages = null;
            for (Ventas ventasListOldVentas : ventasListOld) {
                if (!ventasListNew.contains(ventasListOldVentas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ventas " + ventasListOldVentas + " since its idProducto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idMaquinaNew != null) {
                idMaquinaNew = em.getReference(idMaquinaNew.getClass(), idMaquinaNew.getIdMaquina());
                productos.setIdMaquina(idMaquinaNew);
            }
            List<Ventas> attachedVentasListNew = new ArrayList<Ventas>();
            for (Ventas ventasListNewVentasToAttach : ventasListNew) {
                ventasListNewVentasToAttach = em.getReference(ventasListNewVentasToAttach.getClass(), ventasListNewVentasToAttach.getIdVenta());
                attachedVentasListNew.add(ventasListNewVentasToAttach);
            }
            ventasListNew = attachedVentasListNew;
            productos.setVentasList(ventasListNew);
            productos = em.merge(productos);
            if (idMaquinaOld != null && !idMaquinaOld.equals(idMaquinaNew)) {
                idMaquinaOld.getProductosList().remove(productos);
                idMaquinaOld = em.merge(idMaquinaOld);
            }
            if (idMaquinaNew != null && !idMaquinaNew.equals(idMaquinaOld)) {
                idMaquinaNew.getProductosList().add(productos);
                idMaquinaNew = em.merge(idMaquinaNew);
            }
            for (Ventas ventasListNewVentas : ventasListNew) {
                if (!ventasListOld.contains(ventasListNewVentas)) {
                    Productos oldIdProductoOfVentasListNewVentas = ventasListNewVentas.getIdProducto();
                    ventasListNewVentas.setIdProducto(productos);
                    ventasListNewVentas = em.merge(ventasListNewVentas);
                    if (oldIdProductoOfVentasListNewVentas != null && !oldIdProductoOfVentasListNewVentas.equals(productos)) {
                        oldIdProductoOfVentasListNewVentas.getVentasList().remove(ventasListNewVentas);
                        oldIdProductoOfVentasListNewVentas = em.merge(oldIdProductoOfVentasListNewVentas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productos.getIdProducto();
                if (findProductos(id) == null) {
                    throw new NonexistentEntityException("The productos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productos productos;
            try {
                productos = em.getReference(Productos.class, id);
                productos.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Ventas> ventasListOrphanCheck = productos.getVentasList();
            for (Ventas ventasListOrphanCheckVentas : ventasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Productos (" + productos + ") cannot be destroyed since the Ventas " + ventasListOrphanCheckVentas + " in its ventasList field has a non-nullable idProducto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Maquinas idMaquina = productos.getIdMaquina();
            if (idMaquina != null) {
                idMaquina.getProductosList().remove(productos);
                idMaquina = em.merge(idMaquina);
            }
            em.remove(productos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productos> findProductosEntities() {
        return findProductosEntities(true, -1, -1);
    }

    public List<Productos> findProductosEntities(int maxResults, int firstResult) {
        return findProductosEntities(false, maxResults, firstResult);
    }

    private List<Productos> findProductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productos.class));
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

    public Productos findProductos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productos> rt = cq.from(Productos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
