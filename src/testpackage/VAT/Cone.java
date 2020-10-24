package testpackage.VAT;

import java.util.Objects;

public class Cone implements Shape{

    private String name = "Cone";
    private Shapes type = Shapes.CONE;
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getType(){ return type.name(); }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public double calculateVolume() {
        double breuk = (double) 1 / 3;
        return breuk * Math.PI * Math.pow(radius, 2) * height;
    }

    public void saveToDatabase(){
        MyDatabase db = new MyDatabase();
        db.insertCone(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Double.compare(cone.radius, radius) == 0 &&
                Double.compare(cone.height, height) == 0 &&
                Objects.equals(name, cone.name) &&
                type == cone.type;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name + " volume: " + calculateVolume();
    }
}
