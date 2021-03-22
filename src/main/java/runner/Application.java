package runner;

import comparator.DescendingAreaComparator;
import exception.InvalidNumberException;
import exception.InvalidParametersException;
import exception.NoSuchFigureException;
import exception.WrongParametersLength;
import model.GeometricFigure;
import service.SrtingConsts;
import service.factory.FigureManager;
import service.factory.FigureManagerFactory;
import service.messenger.Messenger;

import java.util.Set;
import java.util.TreeSet;

public class Application {
    private FigureManager manager;
    private final Messenger messenger;
    public Application(Messenger messenger) {
        this.messenger = messenger;
    }

    public void run() {

        initFigureManager();

        Set<GeometricFigure> figures = new TreeSet<>(new DescendingAreaComparator<>());
        fillFiguresSet(figures, "yes");
        System.out.println(manager.figuresToString(figures));
    }

    private Set<GeometricFigure> fillFiguresSet(Set<GeometricFigure> figures, String answer) {
        if (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))) {
            return figures;
        }
        messenger.sendMessage(String.format("Please enter parameters for %s.", manager.getFigureName()));
        messenger.sendMessage(manager.getParamsExample());
        GeometricFigure figure;
        try {
            figure = manager.createGeometricFigure(messenger.getMessage());
        } catch (WrongParametersLength | InvalidNumberException | NumberFormatException | InvalidParametersException e) {
            messenger.sendMessage(e.getMessage());
            return fillFiguresSet(figures, "yes");
        }
        figures.add(figure);
        messenger.sendMessage("Would you like to continue? (yes/y)");
        return fillFiguresSet(figures, messenger.getMessage());
    }

    private void initFigureManager(){
        messenger.sendMessage(SrtingConsts.CHOOSE_FIGURE);
        try{
            manager = FigureManagerFactory.makeFigureManager(messenger.getMessage());
        }catch (NoSuchFigureException e){
            messenger.sendMessage(e.getMessage());
             initFigureManager();
        }
    }
}
