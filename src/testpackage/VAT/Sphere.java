package testpackage.VAT;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Sphere implements Shape, Serializable {

    private String name = "Sphere";
    private Shapes type = Shapes.SPHERE;
    private double radius;
    private MyDatabase myDatabase = new MyDatabase();

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

    public double calculateVolume() {
        double breuk = (double) 4 / 3;
        return breuk * Math.PI * Math.pow(getRadius(),3);
    }

    @Override
    public void saveToDatabase() {
        myDatabase.insertSphere(this);
    }

    public void deleteFromDatabase(){
        try (Connection connection = myDatabase.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM shapes WHERE type = ? AND radius = ?");
            statement.setString(1, type.name());
            statement.setDouble(2, radius);

            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL exceptie tijdens verwijderen vorm: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return name + "(r: " + getRadius() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                Objects.equals(name, sphere.name) &&
                type == sphere.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, radius);
    }
}
