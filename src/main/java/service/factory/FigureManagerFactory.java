package service.factory;

import exception.NoSuchFigureException;

public class FigureManagerFactory {

    public static FigureManager makeFigureManager(String figureName) throws NoSuchFigureException {
        FigureManager figureManager = null;
        if (figureName.equals("t")) {
            return new TriangleManager();
        } else if (figureName.equals("c")) {
            return new CircleManager();
        } else if (figureName.equals("r")) {
            return new RectangleManager();
        } else throw new NoSuchFigureException("Application doesn't work with this figure.");
    }
}
