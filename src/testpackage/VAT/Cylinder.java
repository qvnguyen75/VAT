package testpackage.VAT;

import java.util.Objects;

public class Cylinder implements Shape {

    private String name = "Cylinder";
    private double height;
    private double radius;
    private static double pi = 3.14;

    public Cylinder(){}

    public Cylinder(double height,double radius) {
        this.name = "Cylinder";
        this.height = height;
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public String getName() {
        return this.name;
    }

    public double calculateVolume() {
        double r2 = getRadius() * getRadius();
        return pi * r2 * getHeight();
    }

    public void order (){
        System.out.println(this.name + " created");
    }

    @Override
    public String toString() {
        return name;
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
}
