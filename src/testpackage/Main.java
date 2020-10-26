package testpackage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import testpackage.VAT.*;
import testpackage.ui.RegisterView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Register register = new Register();
        primaryStage.setTitle("VAT");
        Parent registerView = new RegisterView(register).getView();
        primaryStage.setScene(new Scene(registerView));
        primaryStage.show();

        // test RegisterTextIO
        // read shapes from file
//        HashMap<String, Double> readShapes = RegisterTextIO.readShapesFromFile("shapes.txt");
//        readShapes.forEach((n,s) -> System.out.println(n + " " + s));

        // Test RegisterTextIO.writeShapesToFile
        // create hashmap first
//        HashMap<String, Integer> createdShapes = new HashMap<>();
//        createdShapes.put("Cube", 1);
//        createdShapes.put("Cylinder", 2);
//        createdShapes.put("Pyramid", 3);
//        createdShapes.put("Sphere", 4);
//        createdShapes.put("Square", 5);
//        RegisterTextIO.writeShapesToFile("createdShapes.txt", createdShapes);

          // write to object file
//        Register objectRegister = new Register();
//        objectRegister.getAll();
//        RegisterObjectIO.writeRegisterToObj("register2.obj", objectRegister);

        // read from .obj file
//        Register readRegister = RegisterObjectIO.readRegister("register2.obj");
//        System.out.println(readRegister.totalVolume());



    }

    public static void main(String[] args) {
        launch(args);
    }
}
