package testpackage.VAT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class RegisterTextIO {


    // READ FILE AND RETURN AS HASHMAP
    public static HashMap<String, Double> readShapesFromFile(String fileName){

        HashMap<String, Double> shapes = new HashMap<>();

        try(Scanner scanner = new Scanner(new File(fileName))) {
            while(scanner.hasNextLine()){
                String shapeLine = scanner.nextLine();
                String[] parts = shapeLine.split(";");

                // USE NUMBERFORMATTING
                NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
                double surface = format.parse(parts[1]).doubleValue();
                // INSTEAD OF NORMAL PARSING
//                double surface1 = Double.parseDouble(parts[1]);
                shapes.put(parts[0],surface);
            }
        }
        // laat weten dat file niet gevonden is
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        catch (ParseException e) {
            System.out.println("format of file incorrect");
        }
        return shapes;
    }


    public static void writeShapesToFile(String filename, HashMap<String, Integer> sales){
        try (PrintWriter printWriter = new PrintWriter(new File(filename))) {
            sales.forEach((shape, count) -> {
                // println doet automatisch nieuwe regel
                printWriter.println(shape + ";" + count);
            });
        }
        // bestand kan file of folder zijn daarom exceptie opvangen
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
