package testpackage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import testpackage.VAT.*;
import testpackage.ui.RegisterView;
import java.util.HashMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // test RegisterTextIO
        // read shapes from file
//        HashMap<String, Double> readShapes = RegisterTextIO.readShapesFromFile("shapes.txt");
//        readShapes.forEach((n,s) -> System.out.println(n + " " + s));

        // Test RegisterTextIO.writeShapesToFile
        // create hashmap first
//        HashMap<String, Integer> createdShapes = new HashMap<>();
//        createdShapes.put("Cube", 99);
//        createdShapes.put("Cylinder", 55);
//        createdShapes.put("Pyramid", 123);
//        createdShapes.put("Sphere", 75);
//        createdShapes.put("Square", 10000);
//        RegisterTextIO.writeShapesToFile("createdShapes.txt", createdShapes);

          // test writeToObj
//        Register testRegister = new Register();
//        testRegister.save(new Cube(5,5,5));

//        RegisterObjectIO.writeRegisterToObj("register.obj", register);
//        Register readRegister = RegisterObjectIO.readRegister("register.obj");

//        System.out.println(readRegister.totalVolume());

        Register register = new Register();
        primaryStage.setTitle("VAT");
        Parent registerView = new RegisterView(register).getView();
        primaryStage.setScene(new Scene(registerView));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
