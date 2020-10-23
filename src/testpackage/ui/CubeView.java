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

public class CubeView {

    private final Register register;

    public CubeView(Register register) {
        this.register = register;
    }

    public Node getView(){
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        Label instructionWidth = new Label("Width:");
        Label instructionHeight = new Label("Height:");
        Label instructionDepth = new Label("Depth:");
        TextField heightField = new TextField();
        TextField widthField = new TextField();
        TextField depthField = new TextField();
        Button addButton = new Button("Add");

        addButton.setOnAction((event) -> {
            String heightInput = heightField.getText();
            String widthInput = widthField.getText();
            String depthInput = depthField.getText();

            double length = Double.parseDouble(heightInput);
            double width = Double.parseDouble(widthInput);
            double depth = Double.parseDouble(depthInput);

            Cube cube = new Cube(length,width,depth);

            register.save(cube);

            heightField.clear();
            widthField.clear();
            depthField.clear();

        });

        gridpane.add(instructionHeight,0,0);
        gridpane.add(heightField,1,0);
        gridpane.add(instructionWidth,0,1);
        gridpane.add(widthField,1,1);
        gridpane.add(instructionDepth,0,2);
        gridpane.add(depthField,1,2);
        gridpane.add(addButton,0,3);

        Scene squareScene = new Scene(gridpane,300,300);
        Stage squareStage = new Stage();
        squareStage.setTitle("Cube");
        squareStage.setScene(squareScene);
        squareStage.show();

        return gridpane;
    }
}
