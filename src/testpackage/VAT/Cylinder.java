package testpackage.VAT;

import java.util.Objects;

public class Cylinder implements Shape {

    private String name = "Cylinder";
    private Shapes type = Shapes.CYLINDER;
    private double height;
    private double radius;

    public Cylinder(){}

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getType(){ return type.name(); }

    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * getHeight();
    }

    public void saveToDatabase(){
        MyDatabase db = new MyDatabase();
        db.insertCylinder(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return name.equals(cylinder.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return this.name + ": volume: " + calculateVolume();
    }

}
