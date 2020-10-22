package testpackage.ui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import testpackage.VAT.Register;
import testpackage.VAT.Shape;
import java.util.HashMap;
import java.util.List;

public class RegisterView {

    private Register register;
    private List<Shape> shapes;

    public RegisterView(Register register, List<Shape> shapes) {
        this.register = register;
        this.shapes = shapes;
    }

    public Parent getView(){

        // RIGHTSIDE UI

        VBox registerOverview = new VBox();
        ListView<Shape> listView = new ListView<>();
        listView.setItems(FXCollections.observableList(register.getAll()));

        // opties voor rechter VBOX
        registerOverview.getChildren().addAll(listView);
        registerOverview.alignmentProperty().setValue(Pos.TOP_CENTER);
        registerOverview.setPadding(new Insets(10));
        registerOverview.setSpacing(10);

        // LEFTSIDE UI

        VBox menu = new VBox();

        //style
        menu.setPadding(new Insets(10));
        menu.setSpacing(10);

        // items for combobox in observableArrayList
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Cube",
                        "Sphere",
                        "Cylinder",
                        "Square",
                        "Pyramid"
                );

        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setValue("Cube");

        // ui buttons
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button refreshButton = new Button("Refresh");
        Label totalVolume = new Label("Total volume:");
        TextField totalVolumeField = new TextField();
        Label totalCubesLabel = new Label("Total cubes:");
        TextField totalCubesField = new TextField();
        HashMap<Shape, Integer> countShapes = register.getShapes();

        // delete functionality
        deleteButton.setOnAction(e -> {
            Shape shape = listView.getSelectionModel().getSelectedItem();
            int index = listView.getSelectionModel().getSelectedIndex();
            listView.getItems().remove(index);
        });

        // refresh functionality
        refreshButton.setOnAction(e -> {
            listView.setItems(FXCollections.observableList(register.getAll()));
            String sVolume = String.valueOf(register.totalVolume());
            totalVolumeField.setText(sVolume);

        });

        // add functionality
        addButton.setOnAction((event) -> {
            String choice = comboBox.getValue();
            switch (choice) {
                case "Cube" -> {
                    CubeView cv = new CubeView(register);
                    cv.getView();
                }
//                case "Sphere" -> {
//                    SphereView sv = new SphereView(dbShape);
//                    sv.getView();
//                }
//                case "Rectangle" -> {
//                    RectangleView rv = new RectangleView(dbShape);
//                    rv.getView();
//                }
//                case "Square" -> {
//                    SquareView sqv = new SquareView(dbShape);
//                    sqv.getView();
//                }
//                case "Pyramid" -> {
//                    PyramidView pv = new PyramidView(dbShape);
//                    pv.getView();
//                }
            }

        });

        menu.getChildren().addAll(comboBox,addButton,deleteButton,refreshButton,totalVolume,totalCubesLabel,totalCubesField);
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(menu);
        borderPane.setRight(registerOverview);
        return borderPane;

    }

    public void chooseShape(Shape shape){
        shapes.add(shape);
    }

}
