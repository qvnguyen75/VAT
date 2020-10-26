package testpackage.ui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import testpackage.VAT.*;

import java.io.File;
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
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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
        Label totalVolume = new Label("Total volume");
        TextField totalVolumeField = new TextField();
        Label totalShapesLabel = new Label("Total shapes");
        TextField totalShapesField = new TextField();
        Label readFromFileLabel = new Label("read from text file");
        Button readFromFileButton = new Button("open");
        Label readObjFileLabel = new Label("read object file");
        Button readObjFileButton = new Button("open");
        Button serializeShapeButton = new Button("serialize");
        Label addShapeAsTextFile = new Label("Select shape to save as text file");
        Button addShapeAsTextButton = new Button("Add");

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
            totalShapesField.setText(String.valueOf(shapes.size()));

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

        readFromFileButton.setOnAction(e -> {
            Window stage = registerOverview.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose file:");
            fileChooser.setInitialDirectory(new File("C:\\"));
            File file = fileChooser.showOpenDialog(stage);
            if(file != null) {
                HashMap<String, Double> readShapes = RegisterTextIO.readShapesFromFile(file.getName());

                System.out.println("=================================== \n");
                System.out.println("shapes en volumes van bestand: " + file.getName() + "\n");
                readShapes.forEach((n,s) ->
                    System.out.println(n + " " + s)
                );
                System.out.println("=================================== \n");
            }

        });

        serializeShapeButton.setOnAction(e -> {
            Shape shape = listView.getSelectionModel().getSelectedItem();
            ShapeObjectIO.writeShapeToObj(shape.getName() + ".obj", shape);
            System.out.println("=================================== \n");
            System.out.println("Shape saved as .obj \n");
            System.out.println("=================================== \n");
        });

        readObjFileButton.setOnAction(e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose file:");
            fileChooser.setInitialDirectory(new File("C:\\"));
            File file = fileChooser.showOpenDialog(stage);
            if ( file != null ) {
                Shape shape = ShapeObjectIO.readShape(file.getName());
                shape.saveToDatabase();
                System.out.println("=================================== \n");
                System.out.println(shape + " volume: " + shape.calculateVolume() + "\n");
                System.out.println("=================================== \n");
            }

        });

        menu.getChildren().addAll(comboBox,
                addButton,
                deleteButton,
                deleteAllButton,
                serializeShapeButton,
                refreshButton,
                totalVolume,
                totalVolumeField,
                totalShapesLabel,
                totalShapesField,
                readFromFileLabel,
                readFromFileButton,
                readObjFileLabel,
                readObjFileButton,
                addShapeAsTextFile,
                addShapeAsTextButton
                );
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(menu);
        borderPane.setRight(registerOverview);
        return borderPane;

    }

}
