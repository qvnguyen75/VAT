package testpackage.VAT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Cylinder implements Shape {

    private String name = "Cylinder";
    private Shapes type = Shapes.CYLINDER;
    private double height;
    private double radius;
    private MyDatabase myDatabase = new MyDatabase();

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
        myDatabase.insertCylinder(this);
    }

    public void deleteFromDatabase(){
        try (Connection connection = myDatabase.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM shapes WHERE type = ? AND height = ? AND radius = ?");
            statement.setString(1, type.name());
            statement.setDouble(2, height);
            statement.setDouble(3, radius);

            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL exceptie tijdens verwijderen vorm: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.height, height) == 0 &&
                Double.compare(cylinder.radius, radius) == 0 &&
                Objects.equals(name, cylinder.name) &&
                type == cylinder.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, height, radius);
    }

    @Override
    public String toString() {
        return this.name + " (h: " + getHeight() + ", r: " + getRadius() + ")";
    }

}
