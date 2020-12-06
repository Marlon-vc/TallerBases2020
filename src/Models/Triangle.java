package Models;

import javax.persistence.Entity;

@Entity
public class Triangle extends Shape {

    private double side;

    public Triangle() {

    }

    public Triangle(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (this.side * 3) / 2;
    }

    @Override
    public double getPerimeter() {
        return this.side * 3;
    }
}
