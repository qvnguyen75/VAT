package testpackage.VAT;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDatabase {

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/VAT", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Shape> getAll() {
        List<Shape> shapes = new ArrayList<>();
        try (Connection connection = getConnection()){
            String getQuery = "SELECT * FROM shapes";
            PreparedStatement statement = connection.prepareStatement(getQuery);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                String shapeType = resultSet.getString("type");
                double shapeLength = resultSet.getDouble("length");
                double shapeWidth = resultSet.getDouble("width");
                double shapeHeight = resultSet.getDouble("height");
                double shapeRadius = resultSet.getDouble("radius");
                switch (shapeType) {
                    case "CONE" -> {
                        Cone cone = new Cone(shapeRadius, shapeHeight);
                        shapes.add(cone);
                    }
                    case "CUBE" -> {
                        Cube cube = new Cube(shapeLength, shapeWidth, shapeHeight);
                        shapes.add(cube);
                    }
                    case "CYLINDER" -> {
                        Cylinder cylinder = new Cylinder(shapeHeight, shapeRadius);
                        shapes.add(cylinder);
                    }
                    case "PYRAMID" -> {
                        Pyramid pyramid = new Pyramid(shapeLength, shapeWidth, shapeHeight);
                        shapes.add(pyramid);
                    }
                    case "SPHERE" -> {
                        Sphere sphere = new Sphere(shapeRadius);
                        shapes.add(sphere);
                    }
                    default -> System.out.println("Onbekend vormtype gevonden!");
                }
            }
        } catch (SQLException e){
            System.out.println("SQL exceptie tijdens ophalen van vormen: " + e.getMessage());
        }

        return shapes;
    }

    public void deleteAll(){
        try (Connection connection = getConnection()){
            String deleteQuery = "TRUNCATE shapes";
            try (PreparedStatement statement = connection.prepareStatement(deleteQuery)){
                statement.execute();
            }catch (SQLException e){
                System.out.println("SQL exceptie tijdens verwijderen vormen! " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("SQL exceptie tijdens verwijderen vormen! " + e.getMessage());
        }
    }

    public void insertCube(Cube cube){
        try (Connection connection = getConnection()){
            String insertQuery = "INSERT INTO shapes (type, length, width, height) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)){
                statement.setString(1, cube.getType());
                statement.setDouble(2, cube.getLength());
                statement.setDouble(3, cube.getWidth());
                statement.setDouble(4, cube.getHeight());

                statement.execute();
            } catch (SQLException e) {
                System.out.println("SQL exceptie tijdens invoegen van cube! " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertCone(Cone cone){
        try (Connection connection = getConnection()){
            String insertQuery = "INSERT INTO shapes (type, height, radius) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)){
                statement.setString(1, cone.getType());
                statement.setDouble(2, cone.getHeight());
                statement.setDouble(3, cone.getRadius());

                statement.execute();
            } catch (SQLException e) {
                System.out.println("SQL exceptie tijdens invoegen van kegel! " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertCylinder(Cylinder cylinder){
        try (Connection connection = getConnection()){
            String insertQuery = "INSERT INTO shapes (type, height, radius) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)){
                statement.setString(1, cylinder.getType());
                statement.setDouble(2, cylinder.getHeight());
                statement.setDouble(3, cylinder.getRadius());

                statement.execute();
            } catch (SQLException e) {
                System.out.println("SQL exceptie tijdens invoegen van kegel! " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertPyramid(Pyramid pyramid){
        try (Connection connection = getConnection()){
            String insertQuery = "INSERT INTO shapes (type, length, width, height) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)){
                statement.setString(1, pyramid.getType());
                statement.setDouble(2, pyramid.getLength());
                statement.setDouble(3, pyramid.getWidth());
                statement.setDouble(4, pyramid.getHeight());

                statement.execute();
            } catch (SQLException e) {
                System.out.println("SQL exceptie tijdens invoegen van pyramide! " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertSphere(Sphere sphere){
        try (Connection connection = getConnection()){
            String insertQuery = "INSERT INTO shapes (type, radius) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)){
                statement.setString(1, sphere.getType());
                statement.setDouble(2, sphere.getRadius());

                statement.execute();
            } catch (SQLException e) {
                System.out.println("SQL exceptie tijdens invoegen van bol! " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}