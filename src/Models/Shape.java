package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public abstract class Shape implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    public Shape() {

    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
