package Models;

import javax.persistence.Entity;

@Entity
public class Square extends Shape {

    private double side;

    public Square() {

    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return this.side * 4;
    }

    public double getSide() {
        return this.side;
    }
}
