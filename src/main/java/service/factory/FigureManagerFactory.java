package service.factory;

import exception.NoSuchFigureException;

public class FigureManagerFactory {

    public static FigureManager makeFigureManager(String figureName) throws NoSuchFigureException {
        FigureManager figureManager = switch (figureName) {
            case "t" -> new TriangleManager();
            case "c" -> new CircleManager();
            case "r" -> new RectangleManager();
            default -> throw new NoSuchFigureException("Application doesn't work with this figure.");
        };
        return figureManager;
    }
}