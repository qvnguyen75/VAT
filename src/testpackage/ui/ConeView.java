package testpackage.ui;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import testpackage.VAT.Cone;
import testpackage.VAT.Cube;
import testpackage.VAT.Register;

public class ConeView {

    private final Register register;

    public ConeView(Register register) {
        this.register = register;
    }

    public Node getView(){
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        Label instructionRadius = new Label("Radius:");
        Label instructionHeight = new Label("Height:");
        TextField radiusField = new TextField();
        TextField heightField = new TextField();
        Button addButton = new Button("Add");

        addButton.setOnAction((event) -> {
            String radiusInput = radiusField.getText();
            String heightInput = heightField.getText();

            double radius = Double.parseDouble(radiusInput);
            double height = Double.parseDouble(heightInput);

            Cone cone = new Cone(radius, height);

            cone.saveToDatabase();

            heightField.clear();
            radiusField.clear();
        });

        gridpane.add(instructionRadius,0,0);
        gridpane.add(radiusField,1,0);
        gridpane.add(instructionHeight,0,1);
        gridpane.add(heightField,1,1);
        gridpane.add(addButton,0,2);

        Scene squareScene = new Scene(gridpane,300,300);
        Stage squareStage = new Stage();
        squareStage.setTitle("Add Cone");
        squareStage.setScene(squareScene);
        squareStage.show();

        return gridpane;
    }
}
