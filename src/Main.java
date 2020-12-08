import Ejemplos.Department;
import Ejemplos.Employee;
import Ejemplos.Project;
import Models.Categoria;
import Models.Producto;
import Models.Proveedor;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("C:/Users/Marlo/Desktop/taller.odb");
        EntityManager em = emf.createEntityManager();

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

        em.persist(pro1);
        em.persist(pro2);
        em.persist(pro3);
        em.persist(pro4);
        em.persist(pro5);

        em.getTransaction().commit();

//        TypedQuery<Department> q1 = em.createQuery("SELECT d FROM Department d", Department.class);
//        List<Department> result = q1.getResultList();

        em.close();
        emf.close();
    }
}
