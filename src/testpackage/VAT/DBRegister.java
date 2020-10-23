//package testpackage.VAT;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DBRegister {
//
//    public List<Shape> getAll() {
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/VAT","root","")){
//            try (Statement statement = connection.createStatement()){
//                ResultSet resultSet = statement.executeQuery("select height, radius from cylinders");
//                List<Shape> result = new ArrayList<>();
//
//                while(resultSet.next()){
//                    String name = resultSet.getString(1);
//                    Double length = resultSet.getDouble(2);
//                    Double width = resultSet.getDouble(3);
//                    Double depth = resultSet.getDouble(4);
//                    Double radius = resultSet.getDouble(5);
//
//                    Shape shape = new Shape(name, length,width, depth, radius);
//
//                    result.add(shape);
//
//                }
//                return result;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//}
