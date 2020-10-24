package testpackage.VAT;

import java.util.Objects;

public class Pyramid implements Shape {

    private String name = "Pyramid";
    private Shapes type = Shapes.PYRAMID;
    private double height;
    private double length;
    private double width;

    public Pyramid(double length, double width, double height) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getSurfaceArea() {
        return length * width;
    }

    public String getType(){ return type.name(); }

    @Override
    public String getName() {
        return name;
    }

    public double calculateVolume(){
        double breuk = (double) 1 / 3;
        return breuk * getSurfaceArea() * height;
    }

    public void saveToDatabase(){
        MyDatabase db = new MyDatabase();
        db.insertPyramid(this);
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

    @Override
    public String toString() {
        return this.name + ": volume: " + calculateVolume();
    }
}
