package testpackage.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testpackage.VAT.MyDatabase;
import testpackage.VAT.Register;
import testpackage.VAT.Cylinder;
import testpackage.VAT.Shape;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CylinderTest {
    private final MyDatabase myDatabase = new MyDatabase();

    private Register register;

    private Cylinder cylinder = new Cylinder(5, 9);

    @BeforeEach
    void beforeEach(){
        register = new Register();
        myDatabase.deleteAll();
    }

    @Test
    void testCalculateVolume(){
        // Arrange

        // Act
        double result = cylinder.calculateVolume();
        System.out.println("Result: " + result);

        // Assert
        double expectedResult = Math.PI * Math.pow(9, 2) * 5;
        System.out.println("Expected result: "+ expectedResult);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSaveToDatabase(){
        // Arrange

        // Act
        cylinder.saveToDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(1, shapeList.size());
    }

    @Test
    void testDeleteFromDatabase(){
        // Arrange
        cylinder.saveToDatabase();

        // Act
        cylinder.deleteFromDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(0, shapeList.size());
    }
}