package testpackage.VAT;

import java.io.*;
import java.util.List;

public class RegisterObjectIO implements Serializable {

//    private Register register;

    public static void writeRegisterToObj(String filename, Register register){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(register);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Register readRegister(String fileName) {
        Register register = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            // leest object uit
            register = (Register)objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // we typecasten naar een Register dus vang exceptie op als het niet van type Register is
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return register;
    }
}
