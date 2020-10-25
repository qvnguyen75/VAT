package testpackage.VAT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.io.Serializable;

public class Cube implements Shape, Serializable {


    private String name = "Cube";
    private Shapes type = Shapes.CUBE;
    private double width;
    private double height;
    private double length;
    private MyDatabase myDatabase = new MyDatabase();

    public Cube(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() { return length; }

    public String getType(){ return type.name(); }

    public double calculateVolume(){
        return getWidth() * getHeight() * getLength();
    }

    public void saveToDatabase(){
        myDatabase.insertCube(this);
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
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.width, width) == 0 &&
                Double.compare(cube.height, height) == 0 &&
                Double.compare(cube.length, length) == 0 &&
                Objects.equals(name, cube.name) &&
                type == cube.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, width, height, length);
    }

    @Override
    public String toString() {
        return this.name + " (l: " + getLength() + ", w: " + getWidth() + ", h: " + getHeight() + ")";
    }
}
