package service.factory;

import exception.FigureParametersException;
import model.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleManagerTest {
    CircleManager manager=new CircleManager();
    @Test
    void getFigureNameTest() {
        String expected="Circle";
        String actual= manager.getFigureName();
        assertEquals(expected,actual);
    }
    @Test
    void getParamsExampleTest(){
        String expected="Example: name, radius";
        String actual= manager.getParamsExample();
        assertEquals(expected,actual);
    }

    @Test
    void ValidParamsCreateGeometricFigureTest()  throws FigureParametersException {
        String input="Circle name, 10";
        Circle expected=new Circle("Circle name",10.0);
        Circle actual=manager.createGeometricFigure(input);
        assertEquals(expected,actual);
    }
    @Test
    void ToLongParamsCreateGeometricFigureTest()  {
        String input="Circle name, 2,3";
        assertThrows(FigureParametersException.class,()->manager.createGeometricFigure(input));
    }
    @Test
    void ToShortParamsCreateGeometricFigureTest()  {
        String input="Circle name";
        assertThrows(FigureParametersException.class,()->manager.createGeometricFigure(input));
    }
}