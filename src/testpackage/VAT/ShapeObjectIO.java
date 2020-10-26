package testpackage.VAT;
import java.io.*;

public class ShapeObjectIO implements Serializable {

    public static void writeShapeToObj(String nameShape, Shape shape){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nameShape))) {
            objectOutputStream.writeObject(shape);
        } catch (IOException e) {
            System.out.println("exceptie hier");
            e.printStackTrace();
        }
    }

    public static Shape readShape(String fileName) {
        Shape shape = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            // leest object uit
            shape = (Shape)objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        // exceptie opvangen voor objectinputstream
        catch (IOException e) {
            System.out.println("Wrong file format. Use .txt");
            e.printStackTrace();
        }
        // we typecasten naar een Shape dus vang exceptie op als het niet van type Shape is
        catch (ClassNotFoundException e) {
            System.out.println("class must be a shape");
            e.printStackTrace();
        }

        return shape;
    }

}
