package testpackage.VAT;

import java.util.Objects;

public class Pyramid implements Shape {

    private String name = "Pyramid";
    private double height;
    private double surfaceArea;

    public Pyramid(){}

    public Pyramid(double height, double surfaceArea) {
        this.height = height;
        this.surfaceArea = surfaceArea;
    }

    public double getHeight() {
        return height;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public String getName() {
        return name;
    }

    public double calculateVolume(){
        double breuk = (double) 1 / 3;
        return breuk * surfaceArea * height;
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
        Pyramid pyramid = (Pyramid) o;
        return name.equals(pyramid.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
