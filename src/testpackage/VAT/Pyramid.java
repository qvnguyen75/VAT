package testpackage.VAT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Pyramid implements Shape {

    private String name = "Pyramid";
    private Shapes type = Shapes.PYRAMID;
    private double height;
    private double length;
    private double width;
    private MyDatabase myDatabase = new MyDatabase();

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
        myDatabase.insertPyramid(this);
    }

    public void deleteFromDatabase(){
        try (Connection connection = myDatabase.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM shapes WHERE type = ? AND length = ? AND width = ? AND height = ?");
            statement.setString(1, type.name());
            statement.setDouble(2, length);
            statement.setDouble(3, width);
            statement.setDouble(4, height);

            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL exceptie tijdens verwijderen vorm: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pyramid pyramid = (Pyramid) o;
        return Double.compare(pyramid.height, height) == 0 &&
                Double.compare(pyramid.length, length) == 0 &&
                Double.compare(pyramid.width, width) == 0 &&
                Objects.equals(name, pyramid.name) &&
                type == pyramid.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, height, length, width);
    }

    @Override
    public String toString() {
        return this.name + " (l: " + getLength() + ", w: " + getWidth() + ", h: " + getHeight() + ")";
    }
}
