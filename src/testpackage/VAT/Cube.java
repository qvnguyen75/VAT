package testpackage.VAT;

import java.util.Objects;

public class Cube implements Shape {

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
        return this.name;
    }


    @Override
    public boolean equals(Object comparedShape) {
        // if the variables are located in the same place, they're the same
        if (this == comparedShape) {
            return true;
        }
        // if comparedShape is not of type Book, the objects aren't the same
        if (!(comparedShape instanceof Cube)) {
            return false;
        }
        // let's convert the object to a Shape-olioksi
        Cube comparedCube = (Cube) comparedShape;
        // if the instance variables of the objects are the same, so are the objects
        if (this.name.equals(comparedCube.name) && calculateVolume() == comparedCube.calculateVolume()){
            return true;
        }
        // otherwise, the objects aren't the same
        return false;
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
