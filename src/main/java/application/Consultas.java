/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import controllers.MaquinasJpaController;
import controllers.ProductosJpaController;
import controllers.VentasJpaController;
import entities.Maquinas;
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
    
    public static void main(String[] args) {
        
        System.out.println(
        "--- Prueba los métodos de consulta incluidos en los controladores ---\n" +
        "--- Prueba a crear una entidad de cada tipo ---\n" +
        "--- Prueba a modificar una entidad de cada tipo ---\n" +
        "--- Prueba a borrar una entidad de cada tipo ---");
        
        
        //Consulta
        System.out.println("--- Máquinas expendedoras ---");
        List<Maquinas> listaMaquinas = maquinaJPA.findMaquinasEntities();
        System.out.println(listaMaquinas);
        
    }
    
    private static EntityManagerFactory getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BDMaquinaExpendedora");

        return entityManagerFactory;
    }
    
}
