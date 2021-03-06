package service.factory;

import exception.InvalidParametersException;
import exception.WrongParametersLength;
import model.GeometricFigure;
import model.Triangle;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.Validator;

import static org.junit.jupiter.api.Assertions.*;

class TriangleManagerTest {

   FigureManager manager = new TriangleManager();

    @Test
    void getFigureNameTest() {
        String expected="Triangle";
        String actual=manager.getFigureName();
        assertEquals(expected,actual);
    }
    @Test
    void getParamsExampleTest() {
        String expected="Example: name, side1, side2, side3";
        String actual=manager.getParamsExample();
        assertEquals(expected,actual);
    }

    @Test
    public void ValidValueCreateGeometricFigureTest() throws Exception {
        String input = "Triangle name1, 1,1,1";
        Triangle expected = new Triangle("Triangle name1", 1, 1, 1);
        GeometricFigure actual = manager.createGeometricFigure(input);
        assertEquals(expected, actual);
    }

    @Test
    public void LessParametersLengthCreateGeometricFigureTest(){
        String input = "Triangle name1, 1,1";
        assertThrows(WrongParametersLength.class, () -> manager.createGeometricFigure(input));
    }
    @Test
    public void MoreParametersLengthCreateGeometricFigureTest(){
        String input = "Triangle name1, 1,1,1,1";
        assertThrows(WrongParametersLength.class, () -> manager.createGeometricFigure(input));
    }
    @Test
    public void WrongTriangleSidesCreateGeometricFigureTest()  {
        String input = "name1, 1,1,4";
        assertThrows(IllegalArgumentException.class, () -> manager.createGeometricFigure(input));
    }
    @Test
    public void ZeroAreaTriangleSidesCreateGeometricFigureTest() {
        String input = "name1, 1,1,3";
        assertThrows(IllegalArgumentException.class, () -> manager.createGeometricFigure(input));
    }
}