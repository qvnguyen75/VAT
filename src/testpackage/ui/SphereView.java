package testpackage.ui;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import testpackage.VAT.Cube;
import testpackage.VAT.Register;
import testpackage.VAT.Sphere;

public class SphereView {

    private final Register register;

    public SphereView(Register register) {
        this.register = register;
    }

    public Node getView(){
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        Label instructionRadius = new Label("Radius:");
        TextField radiusField = new TextField();
        Button addButton = new Button("Add");

        addButton.setOnAction((event) -> {
            String radiusInput = radiusField.getText();

            double radius = Double.parseDouble(radiusInput);

            Sphere sphere = new Sphere(radius);

            sphere.saveToDatabase();

            radiusField.clear();
        });

        gridpane.add(instructionRadius,0,0);
        gridpane.add(radiusField,1,0);
        gridpane.add(addButton,0,1);

        Scene squareScene = new Scene(gridpane,300,300);
        Stage squareStage = new Stage();
        squareStage.setTitle("Add Sphere");
        squareStage.setScene(squareScene);
        squareStage.show();

        return gridpane;
    }
}
