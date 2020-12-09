import Ejemplos.Department;
import Ejemplos.Employee;
import Ejemplos.Project;
import Models.Categoria;
import Models.Producto;
import Models.Proveedor;

import javax.persistence.*;
import java.util.List;

public class Main {

    public static void insertData(EntityManager em) {
        em.getTransaction().begin();
        Proveedor p1 = new Proveedor("Antonio Hernández", "Coca Cola", "San José", "85694312");
        Proveedor p2 = new Proveedor("Pedro Pérez", "Robasa", "Alajuela", "75809340");
        Proveedor p3 = new Proveedor("Gregorio García", "Coarsa", "Cartago", "65498382");

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        Categoria c1 = new Categoria("Bebidas");
        Categoria c2 = new Categoria("Jabones");
        Categoria c3 = new Categoria("Dulces");
        Categoria c4 = new Categoria("Enlatados");

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);

        Producto pro1 = new Producto("Coca Cola Regular", 800.0, 10, p1, c1);
        Producto pro2 = new Producto("Fanta Naranja Regular", 800.0, 10, p1, c1);
        Producto pro3 = new Producto("Rinso", 1500.0, 50, p2, c2);
        Producto pro4 = new Producto("M&Ms", 700.0, 10, p3, c3);
        Producto pro5 = new Producto("Atún Sardimar", 1500.0, 5, p3, c4);
        Producto pro6 = new Producto("Te", 1000.0, 1, p1, c1);

        em.persist(pro1);
        em.persist(pro2);
        em.persist(pro3);
        em.persist(pro4);
        em.persist(pro5);
        em.persist(pro6);

        em.getTransaction().commit();
    }

    public static void updateProduct(EntityManager em) {
        em.getTransaction().begin();

        //Actualización de un producto
        Query q2 = em.createQuery("UPDATE Producto p SET p.precio = 10000 WHERE p.nombre = \"Te\"");
        q2.executeUpdate();

        em.getTransaction().commit();
    }

    public static void deleteProduct(EntityManager em) {
        em.getTransaction().begin();
        //Eliminación
        Query q4 = em.createQuery("DELETE FROM Producto p WHERE p.nombre = \"Te\"");
        q4.executeUpdate();

        em.getTransaction().commit();
    }

    public static void getProduct(EntityManager em) {
        //Consulta para obtener un solo producto
        TypedQuery<Producto> q1 = em.createQuery("SELECT p FROM Producto p WHERE p.nombre = \"Te\"", Producto.class);
        Producto p = q1.getSingleResult();
        System.out.println(p);
    }

    public static void getProducts(EntityManager em) {
        //Consulta de múltiples productos
        TypedQuery<Producto> q5 = em.createQuery("SELECT p FROM Producto p", Producto.class);
        List<Producto> results = q5.getResultList();

        System.out.println("## Productos ##");
        for (Producto pro : results) {
            System.out.println(pro);
        }
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("C:/Users/pvill/Desktop/taller.odb");
        EntityManager em = emf.createEntityManager();

        insertData(em);

        getProduct(em);

        updateProduct(em);

        //Consulta para verificar que se actualizó el producto

        getProduct(em);

        deleteProduct(em);

        getProducts(em);

        em.close();
        emf.close();
    }
}
