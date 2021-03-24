package runner;

import comparator.DescendingAreaComparator;
import exception.FigureParametersException;
import exception.NoSuchFigureException;
import model.GeometricFigure;
import service.SrtingConsts;
import service.factory.FigureManager;
import service.factory.FigureManagerFactory;
import service.messenger.Messenger;

import java.util.*;

public class Application {
    private FigureManager manager;
    private final Messenger messenger;

    public Application(Messenger messenger) {
        this.messenger = messenger;
    }

    public void run() {

        initFigureManager();

        TreeSet<GeometricFigure> figures = createFigures(new DescendingAreaComparator<>());
        messenger.sendMessage(manager.figuresToString(figures));
    }

    private TreeSet<GeometricFigure> createFigures(Comparator<GeometricFigure> comp) {
        TreeSet<GeometricFigure> figures = new TreeSet<>(comp);
        String answer = SrtingConsts.YES;
        while (doesUserSayYes(answer)) {
            messenger.sendMessage(String.format(SrtingConsts.ENTER_PARAMETERS, manager.getFigureName()));
            messenger.sendMessage(manager.getParamsExample());
            try {
                figures.add(manager.createGeometricFigure(messenger.getMessage()));
            } catch (FigureParametersException | IllegalArgumentException exception) {
                messenger.sendMessage(exception.getMessage());
                continue;
            }
            messenger.sendMessage(String.format(SrtingConsts.WOULD_YOU_LIKE_TO_CONTINUE, manager.getFigureName()));
            answer = messenger.getMessage();
        }
        return figures;
    }

    private boolean doesUserSayYes(String answer) {
        return answer.equalsIgnoreCase(SrtingConsts.YES)
                || answer.equalsIgnoreCase(SrtingConsts.Y);
    }

    private void initFigureManager() {
        while (manager == null) {
            messenger.sendMessage(SrtingConsts.CHOOSE_FIGURE);
            try {
                manager = FigureManagerFactory.makeFigureManager(messenger.getMessage().trim());
            } catch (NoSuchFigureException e) {
                messenger.sendMessage(e.getMessage());
            }
        }
    }
}
