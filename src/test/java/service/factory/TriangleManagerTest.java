package service.factory;

import exception.InvalidParametersException;
import exception.WrongParametersLength;
import model.GeometricFigure;
import model.Triangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.Validator;

import static org.junit.jupiter.api.Assertions.*;

class TriangleManagerTest {

    FigureManager manager = new TriangleManager();

    @Test
    public void ValidValueCreateGeometricFigureTest() throws Exception {
        String input = "Triangle name1, 1,1,1";
        Triangle expected = new Triangle("Triangle name1", 1, 1, 1);
        GeometricFigure actual = manager.createGeometricFigure(input);
        assertEquals(expected, actual);
    }

    @Test
    public void WrongParametersLengthCreateGeometricFigureTest(){
        String input = "Triangle name1, 1,1";
        assertThrows(WrongParametersLength.class, () -> manager.createGeometricFigure(input));
    }
    @Test
    public void WrongTriangleSidesCreateGeometricFigureTest()  {
        String input = "name1, 1,1,4";
        assertThrows(NumberFormatException.class, () -> manager.createGeometricFigure(input));
    }
    @Test
    public void ZeroAreaTriangleSidesCreateGeometricFigureTest() {
        String input = "name1, 1,1,3";
        assertThrows(NumberFormatException.class, () -> manager.createGeometricFigure(input));
    }
}