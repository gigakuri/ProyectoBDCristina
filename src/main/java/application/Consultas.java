
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import controllers.MaquinasJpaController;
import controllers.ProductosJpaController;
import controllers.VentasJpaController;
import entities.Maquinas;
import entities.Productos;
import entities.Ventas;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cristina
 */
public class Consultas {
    
    public static MaquinasJpaController maquinaJPA = new MaquinasJpaController(getEntityManager());
    public static ProductosJpaController productoJPA = new ProductosJpaController(getEntityManager());
    public static VentasJpaController ventaJPA = new VentasJpaController(getEntityManager());
    
    public static void main(String[] args) throws Exception {
        
        System.out.println(
        "--- Prueba los métodos de consulta incluidos en los controladores ---\n" +
        "--- Prueba a crear una entidad de cada tipo ---\n" +
        "--- Prueba a modificar una entidad de cada tipo ---\n" +
        "--- Prueba a borrar una entidad de cada tipo ---");
        
        
        //CONSULTA
        System.out.println("--- Máquinas expendedoras ---");
        List<Maquinas> listaMaquinas = maquinaJPA.findMaquinasEntities();
        System.out.println(listaMaquinas);
        System.out.println("--- Productos ---");
        List<Productos> listaProductos = productoJPA.findProductosEntities();
        System.out.println(listaProductos);
        System.out.println("--- Ventas ---");
        List<Ventas> listaVentas = ventaJPA.findVentasEntities();
        System.out.println(listaVentas);
        
        //CREACIÓN
//        Maquinas mPrueba = new Maquinas("prueba");
//        maquinaJPA.create(mPrueba);
//        System.out.println("MÁQUINAS: \n" + listaMaquinas);
//        Productos pPrueba = new Productos("prueba");
//        productoJPA.create(pPrueba);
//        System.out.println("PRODUCTOS: \n" + listaProductos);
//        Ventas pVenta = new Ventas(pPrueba);
//        ventaJPA.create(pVenta);
//        System.out.println("VENTAS: \n" + listaVentas);
        
        //MODIFICACIÓN
//        mPrueba.setNumSerie("999-999-999");
//        maquinaJPA.edit(mPrueba);
//        System.out.println("MÁQUINAS: \n" + listaMaquinas);
//        pPrueba.setNombre("Pruebaa");
//        pPrueba.setIdMaquina(mPrueba);
//        productoJPA.edit(pPrueba);
//        System.out.println("PRODUCTOS: \n" + listaProductos);
//        pVenta.setImporte(BigDecimal.valueOf(99.9));
//        ventaJPA.edit(pVenta);
//        System.out.println("VENTAS: \n" + listaVentas);
        
        //ELIMINACIÓN
//        ventaJPA.destroy(12);
//        productoJPA.destroy(22);
//        maquinaJPA.destroy(3017);
        
    }
    
    private static EntityManagerFactory getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BDMaquinaExpendedora");

        return entityManagerFactory;
    }
    
}
