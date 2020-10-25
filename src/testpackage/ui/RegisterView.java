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

    public RegisterView(Register register) {
        this.register = register;

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
                        "Cone",
                        "Cube",
                        "Cylinder",
                        "Sphere",
                        "Pyramid"
                );

        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setValue("Cone");

        // ui buttons
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button deleteAllButton = new Button("Delete all");
        Button refreshButton = new Button("Refresh");
        Label totalVolume = new Label("Total volume:");
        TextField totalVolumeField = new TextField();
        Label totalCubesLabel = new Label("Total cubes:");
        TextField totalCubesField = new TextField();

        // delete functionality
        deleteButton.setOnAction(e -> {
            Shape shape = listView.getSelectionModel().getSelectedItem();
            shape.deleteFromDatabase();

            int index = listView.getSelectionModel().getSelectedIndex();
            try {
                listView.getItems().remove(index);
            }catch (IndexOutOfBoundsException exception){
                System.out.println("Exceptie tijdens verwijderen vorm!" + exception.getMessage());
            }
        });

        // Delete All functionality
        deleteAllButton.setOnAction(e -> {
            register.deleteAll();
        });

        // refresh functionality
        refreshButton.setOnAction(e -> {
            List<Shape> shapes = register.getAll();
            listView.setItems(FXCollections.observableList(shapes));
            totalVolumeField.setText(String.valueOf(register.totalVolume()));
            totalCubesField.setText(String.valueOf(shapes.size()));

        });



        // add functionality
        addButton.setOnAction((event) -> {
            String choice = comboBox.getValue();
            switch (choice) {
                case "Cube" -> {
                    CubeView cv = new CubeView(register);
                    cv.getView();
                }
                case "Sphere" -> {
                    SphereView sv = new SphereView(register);
                    sv.getView();
                }
                case "Cylinder" -> {
                    CylinderView rv = new CylinderView(register);
                    rv.getView();
                }
                case "Cone" -> {
                    ConeView coneView = new ConeView(register);
                    coneView.getView();
                }
                case "Pyramid" -> {
                    PyramidView pv = new PyramidView(register);
                    pv.getView();
                }
            }

        });

        menu.getChildren().addAll(comboBox, addButton, deleteButton, deleteAllButton, refreshButton, totalVolume, totalVolumeField, totalCubesLabel, totalCubesField);
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(menu);
        borderPane.setRight(registerOverview);
        return borderPane;

    }
}
