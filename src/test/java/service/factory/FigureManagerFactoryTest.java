package service.factory;

import exception.NoSuchFigureException;
import model.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureManagerFactoryTest {

    @Test
    void TriangleManagerMakeFigureManagerTest() throws NoSuchFigureException {
        String input = "t";
        TriangleManager expected = new TriangleManager();
        FigureManager actual =FigureManagerFactory.makeFigureManager(input);
        assertEquals(actual.getClass(),(expected.getClass()));
    }
    @Test
    void CircleManagerMakeFigureManagerTest() throws NoSuchFigureException {
        String input = "c";
        CircleManager expected = new CircleManager();
        FigureManager actual =FigureManagerFactory.makeFigureManager(input);
        assertEquals(actual.getClass(),(expected.getClass()));
    }
    @Test
    void RectangleManagerMakeFigureManagerTest() throws NoSuchFigureException {
        String input = "r";
        RectangleManager expected = new RectangleManager();
        FigureManager actual =FigureManagerFactory.makeFigureManager(input);
        assertEquals(actual.getClass(),(expected.getClass()));
    }
    @Test
    void NoSuchFigureExceptionMakeFigureManagerTest() {
        String input = "k";
        assertThrows(NoSuchFigureException.class,()->FigureManagerFactory.makeFigureManager(input));
    }
}