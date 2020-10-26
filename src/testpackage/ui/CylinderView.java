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
import testpackage.VAT.Cylinder;
import testpackage.VAT.Register;

public class CylinderView {

    private final Register register;

    public CylinderView(Register register) {
        this.register = register;
    }

    public Node getView(){
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        Label instructionHeight = new Label("Height:");
        Label instructionRadius = new Label("Radius:");
        TextField heightField = new TextField();
        TextField radiusField = new TextField();
        Button addButton = new Button("Add");

        addButton.setOnAction((event) -> {
            String heightInput = heightField.getText();
            String radiusInput = radiusField.getText();

            double height = Double.parseDouble(heightInput);
            double radius = Double.parseDouble(radiusInput);

            Cylinder cylinder = new Cylinder(height, radius);

            cylinder.saveToDatabase();

            heightField.clear();
            radiusField.clear();

        });

        gridpane.add(instructionHeight,0,0);
        gridpane.add(heightField,1,0);
        gridpane.add(instructionRadius,0,1);
        gridpane.add(radiusField,1,1);
        gridpane.add(addButton,0,2);

        Scene squareScene = new Scene(gridpane,300,300);
        Stage squareStage = new Stage();
        squareStage.setTitle("Add Cylinder");
        squareStage.setScene(squareScene);
        squareStage.show();

        return gridpane;
    }
}
