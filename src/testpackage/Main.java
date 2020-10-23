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
