package testpackage.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testpackage.VAT.MyDatabase;
import testpackage.VAT.Register;
import testpackage.VAT.Sphere;
import testpackage.VAT.Shape;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SphereTest {
    private final MyDatabase myDatabase = new MyDatabase();

    private Register register;

    private Sphere sphere = new Sphere(8);

    @BeforeEach
    void beforeEach(){
        register = new Register();
        myDatabase.deleteAll();
    }

    @Test
    void testCalculateVolume(){
        // Arrange

        // Act
        double result = sphere.calculateVolume();
        System.out.println("Result: " + result);

        // Assert
        double breuk = (double) 4 / 3;
        double expectedResult = breuk * Math.PI * Math.pow(8, 3);
        System.out.println("Expected result: "+ expectedResult);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSaveToDatabase(){
        // Arrange

        // Act
        sphere.saveToDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(1, shapeList.size());
    }

    @Test
    void testDeleteFromDatabase(){
        // Arrange
        sphere.saveToDatabase();

        // Act
        sphere.deleteFromDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(0, shapeList.size());
    }
}