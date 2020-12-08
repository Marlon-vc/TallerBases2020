package Ejemplos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne
    private Department department;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> workers;

    public Project() {}

    public Project(String name) {
        this.name = name;
        workers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Employee> workers) {
        this.workers = workers;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
