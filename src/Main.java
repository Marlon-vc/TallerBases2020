import Models.Department;
import Models.Employee;
import Models.Project;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Open a database connection
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("C:/Users/Marlo/Desktop/example.odb");
        EntityManager em = emf.createEntityManager();

        // Store 1000 entities in the database
        long startTime = System.nanoTime();
        em.getTransaction().begin();

//        Query dq1 = em.createQuery("DELETE FROM Department d");
//        dq1.executeUpdate();
//        Query dq2 = em.createQuery("DELETE FROM Employee e");
//        dq2.executeUpdate();
//        Query dq3 = em.createQuery("DELETE FROM Project p");
//        dq3.executeUpdate();

        Department dept1 = new Department(1, "Finances", "San José");
        Department dept2 = new Department(2, "HR", "Cartago");
        em.persist(dept1);
        em.persist(dept2);

        Project p1 = new Project("Web Page");
        p1.setDepartment(dept1);
        em.persist(p1);

        for (int i = 0; i < 500; i++) {
            Employee emp = new Employee(
                    "SSN1" + i,
                    "Name " + i,
                    "Lastname " + i,
                    "Birthdate " + i);
            emp.setDepartment(dept1);

            if (i > 450) {
                emp.addProject(p1);
            }

            em.persist(emp);
        }
        for (int i = 0; i < 100; i++) {
            Employee emp = new Employee(
                    "SSN2" + i,
                    "Name " + i,
                    "Lastname " + i,
                    "Birthdate " + i);
            emp.setDepartment(dept2);
            em.persist(emp);
        }

        em.getTransaction().commit();

        System.out.println("Elapsed time: " + ((System.nanoTime() - startTime) / 1000000) + " ms");

        TypedQuery<Department> q1 = em.createQuery("SELECT d FROM Department d", Department.class);
        List<Department> result = q1.getResultList();



        //EJERCICIO 1

        //


        em.close();
        emf.close();
    }
}
