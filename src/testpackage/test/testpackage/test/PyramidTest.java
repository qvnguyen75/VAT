package testpackage.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testpackage.VAT.MyDatabase;
import testpackage.VAT.Pyramid;
import testpackage.VAT.Register;
import testpackage.VAT.Shape;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PyramidTest {
    private final MyDatabase myDatabase = new MyDatabase();

    private Register register;

    private Pyramid pyramid = new Pyramid(4, 6, 10);

    @BeforeEach
    void beforeEach(){
        register = new Register();
        myDatabase.deleteAll();
    }

    @Test
    void testCalculateVolume(){
        // Arrange

        // Act
        double result = pyramid.calculateVolume();
        System.out.println("Result: " + result);

        // Assert
        double breuk = (double) 1 / 3;
        double expectedResult = breuk * 4 * 6 * 10;
        System.out.println("Expected result: "+ expectedResult);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSaveToDatabase(){
        // Arrange

        // Act
        pyramid.saveToDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(1, shapeList.size());
    }

    @Test
    void testDeleteFromDatabase(){
        // Arrange
        pyramid.saveToDatabase();

        // Act
        pyramid.deleteFromDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(0, shapeList.size());
    }
}