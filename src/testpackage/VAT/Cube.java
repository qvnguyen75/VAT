package testpackage.VAT;

import java.io.Serializable;

public class Cube implements Shape, Serializable {

    private String name = "Cube";
    private double width;
    private double height;
    private double depth;

    public Cube(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public double calculateVolume(){
        return getWidth() * getHeight() * getDepth();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return name.equals(cube.name);
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
