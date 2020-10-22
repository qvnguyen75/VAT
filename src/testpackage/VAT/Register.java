package testpackage.VAT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Register {

    // associatie hier vanwege deze list van shapes
    private List<Shape> chosenShapes;
//    private HashMap<Shape, Integer> countShapes = new HashMap<>();

    public Register() {
        this.chosenShapes = new ArrayList<>();
    }

    // geeft hashmap terug van bovenstaande lijst !!
    public HashMap<Shape, Integer> getShapes(){
        // eerst zelf nieuwe hashmap aanmaken
        HashMap<Shape, Integer> count = new HashMap<>();
        // extraheer hashmap uit arraylist
        for (Shape chosenShape : chosenShapes) {
            if(count.containsKey(chosenShape)){
                int freq = count.get(chosenShape);
                count.put(chosenShape, freq + 1);
            } else {
                count.put(chosenShape,1);
            }
        }
        return count;
    }

    public void save(Shape shape) {
        chosenShapes.add(shape);
    }

    public double totalVolume(){
        double total = 0.0;
        for (Shape chosenShape : chosenShapes) {
                total += chosenShape.calculateVolume();
        }
        return total;
    }

    public List<Shape>getAll(){
        return chosenShapes;
    }

}
