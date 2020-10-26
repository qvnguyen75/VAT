package testpackage.VAT;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Register implements Serializable {

    // associatie hier vanwege deze list van shapes
    private List<Shape> chosenShapes;
    private MyDatabase myDatabase = new MyDatabase();

    public Register() {
        this.chosenShapes = new ArrayList<>();
    }
  
    public String totalVolume(){
        double total = 0.0;
        for (Shape chosenShape : chosenShapes) {
                total += chosenShape.calculateVolume();
        }

        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(total);
    }

    public List<Shape>getAll(){
        chosenShapes = myDatabase.getAll();
        return chosenShapes;
    }

    public void deleteAll(){
        myDatabase.deleteAll();
    }
}
