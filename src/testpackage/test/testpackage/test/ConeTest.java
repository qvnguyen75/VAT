package testpackage.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testpackage.VAT.Cone;
import testpackage.VAT.MyDatabase;
import testpackage.VAT.Register;
import testpackage.VAT.Shape;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConeTest {
    private final MyDatabase myDatabase = new MyDatabase();

    private Register register;

    private Cone cone = new Cone(5, 8);

    @BeforeEach
    void beforeEach(){
        register = new Register();
        myDatabase.deleteAll();
    }

    @Test
    void testCalculateVolume(){
        // Arrange

        // Act
        double result = cone.calculateVolume();
        System.out.println("Result: " + result);

        // Assert
        double breuk = (double) 1 / 3;
        double expectedResult = breuk * Math.PI * Math.pow(5, 2) * 8;
        System.out.println("Expected result: "+ expectedResult);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSaveToDatabase(){
        // Arrange

        // Act
        cone.saveToDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(1, shapeList.size());
    }

    @Test
    void testDeleteFromDatabase(){
        // Arrange
        cone.saveToDatabase();

        // Act
        cone.deleteFromDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(0, shapeList.size());
    }
}