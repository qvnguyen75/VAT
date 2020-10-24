package testpackage.VAT;

import java.util.Objects;

public class Sphere implements Shape{

    private String name = "Sphere";
    private Shapes type = Shapes.SPHERE;
    private double radius;
    private static double pi = 3.14;

    public Sphere(){

    }

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getType(){ return type.name(); }

    //    public String getDescription() {
//        return name + " volume: " + calculateVolume();
//    }

    public void order (){
        System.out.println(this.name + " created");
    }

    public double calculateVolume() {
        double breuk = (double) 4 / 3;
        return breuk * pi * Math.pow(getRadius(),3);
    }

    @Override
    public void saveToDatabase() {
        MyDatabase db = new MyDatabase();
        db.insertSphere(this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return name.equals(sphere.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
