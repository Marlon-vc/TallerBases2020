package Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee implements Serializable {

    @Id
    private String Ssn;
    private String firstName;
    private String lastName;
    private String birthdate;

    @ManyToOne
    private Department department;

    @ManyToMany
    private List<Project> projects;

    public Employee() {}

    public Employee(String ssn, String firstName, String lastName, String birthdate) {
        Ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        projects = new ArrayList<>();
    }

    public String getSsn() {
        return Ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects  ) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
