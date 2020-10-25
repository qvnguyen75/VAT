package testpackage.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testpackage.VAT.Cube;
import testpackage.VAT.MyDatabase;
import testpackage.VAT.Register;
import testpackage.VAT.Shape;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CubeTest {
    private final MyDatabase myDatabase = new MyDatabase();

    private Register register;

    private Cube cube = new Cube(3.4, 4, 5);

    @BeforeEach
    void beforeEach(){
        register = new Register();
        myDatabase.deleteAll();
    }

    @Test
    void testCalculateVolume(){
        // Arrange

        // Act
        double result = cube.calculateVolume();
        System.out.println("Result: " + result);

        // Assert
        double expectedResult = 3.4 * 4 * 5;
        System.out.println("Expected result: "+ expectedResult);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSaveToDatabase(){
        // Arrange

        // Act
        cube.saveToDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(1, shapeList.size());
    }

    @Test
    void testDeleteFromDatabase(){
        // Arrange
        cube.saveToDatabase();

        // Act
        cube.deleteFromDatabase();
        List<Shape> shapeList = register.getAll();

        // Assert
        assertEquals(0, shapeList.size());
    }
}