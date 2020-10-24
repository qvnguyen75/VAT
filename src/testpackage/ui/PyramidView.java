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
import testpackage.VAT.Pyramid;
import testpackage.VAT.Register;

public class PyramidView {

    private final Register register;

    public PyramidView(Register register) {
        this.register = register;
    }

    public Node getView(){
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        Label instructionLength = new Label("Base length:");
        Label instructionWidth = new Label("Base width:");
        Label instructionHeight = new Label("Height:");
        TextField lengthField = new TextField();
        TextField widthField = new TextField();
        TextField heightField = new TextField();
        Button addButton = new Button("Add");

        addButton.setOnAction((event) -> {
            String lengthInput = lengthField.getText();
            String widthInput = widthField.getText();
            String heightInput = heightField.getText();

            double length = Double.parseDouble(lengthInput);
            double width = Double.parseDouble(widthInput);
            double height = Double.parseDouble(heightInput);

            Pyramid pyramid = new Pyramid(length, width, height);

            pyramid.saveToDatabase();

            lengthField.clear();
            widthField.clear();
            heightField.clear();

        });

        gridpane.add(instructionLength,0,0);
        gridpane.add(lengthField,1,0);
        gridpane.add(instructionWidth,0,1);
        gridpane.add(widthField,1,1);
        gridpane.add(instructionHeight,0,2);
        gridpane.add(heightField,1,2);
        gridpane.add(addButton,0,3);

        Scene squareScene = new Scene(gridpane,300,300);
        Stage squareStage = new Stage();
        squareStage.setTitle("Add Pyramid");
        squareStage.setScene(squareScene);
        squareStage.show();

        return gridpane;
    }
}
