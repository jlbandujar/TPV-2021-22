/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DAW2
 */
public class Crud {
       public static void insertaProducto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unidad");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Productos producto = new Productos();
        producto.setNombre("Espinacas");
        producto.setPrecio(10);
        producto.setImagen("espinacas.jpg");
        producto.setCategoria("complementos");
        manager.merge(producto);
        manager.getTransaction().commit();
        }
       public static List<Productos> getProductos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unidad");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos";
        Query q = manager.createNativeQuery(sql,Productos.class); //método para consultas en SQL
        List<Productos> productosBD =  q.getResultList();

        return productosBD;        
        }
       
        public static int destroyProducto(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unidad");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Productos p WHERE p.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;  
        
    }
        


}
