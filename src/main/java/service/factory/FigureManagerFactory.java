package service.factory;

import exception.NoSuchFigureException;

public class FigureManagerFactory {

    public static FigureManager makeFigureManager(String figureName) throws NoSuchFigureException {
        FigureManager figureManager;
        switch (figureName) {
            case "t":
                figureManager = new TriangleManager();
                break;
            case "c":
                figureManager = new CircleManager();
                break;
            case "r":
                figureManager = new RectangleManager();
                break;
            default:
                throw new NoSuchFigureException("Sorry, there is no such figure.");
        }
        return figureManager;
    }
}