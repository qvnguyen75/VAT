package testpackage.VAT;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDatabase {

    private Connection getConnection(){
        try (Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/VAT", "root", "")){
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertCube(Cube cube){
        try (Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/VAT", "root", "")){
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
        try (Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/VAT", "root", "")){
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
        try (Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/VAT", "root", "")){
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
        try (Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/VAT", "root", "")){
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
        try (Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/VAT", "root", "")){
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