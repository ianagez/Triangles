package service.factory;

import exception.FigureParametersException;
import model.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleManagerTest {

    RectangleManager manager=new RectangleManager();
    @Test
    void getFigureNameTest() {
        String expected="Rectangle";
        String actual= manager.getFigureName();
        assertEquals(expected,actual);
    }
    @Test
    void getParamsExampleTest(){
        String expected="Example: name, side1, side2";
        String actual= manager.getParamsExample();
        assertEquals(expected,actual);
    }

    @Test
    void ValidParamsCreateGeometricFigureTest()  throws FigureParametersException {
        String input="Rectangle name, 2,3";
        Rectangle expected=new Rectangle("Rectangle name",2.0,3.0);
        Rectangle actual=manager.createGeometricFigure(input);
        assertEquals(expected,actual);
    }
    @Test
    void ToLongParamsCreateGeometricFigureTest()  {
        String input="Rectangle name, 2,3,9";
        assertThrows(FigureParametersException.class,()->manager.createGeometricFigure(input));
    }
    @Test
    void ToShortParamsCreateGeometricFigureTest()  {
        String input="Rectangle name, 2";
        assertThrows(FigureParametersException.class,()->manager.createGeometricFigure(input));
    }
}