package runner;

import comparator.DescendingAreaComparator;
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
        //TODO pass list to manager

        List<GeometricFigure> figures = new ArrayList<>();
        fillFiguresList(figures);
        figures.sort(new DescendingAreaComparator<>());
        messenger.sendMessage(manager.figuresToString(figures));
    }

    private void fillFiguresList(List<GeometricFigure> figures) {
        String answer=SrtingConsts.YES;
        while (answer.equalsIgnoreCase(SrtingConsts.YES) || answer.equalsIgnoreCase(SrtingConsts.Y)){
            messenger.sendMessage(String.format(SrtingConsts.ENTER_PARAMETERS, manager.getFigureName()));
            messenger.sendMessage(manager.getParamsExample());
            GeometricFigure figure=getFigureByUserParams();
            if(figure!=null){
                figures.add(figure);
                messenger.sendMessage(String.format(SrtingConsts.WOULD_YOU_LIKE_TO_CONTINUE, manager.getFigureName()));
                answer=messenger.getMessage();
            }
        }
    }

    private void initFigureManager(){
        while (manager==null){
            messenger.sendMessage(SrtingConsts.CHOOSE_FIGURE);
            try{
                manager = FigureManagerFactory.makeFigureManager(messenger.getMessage());
            }catch (NoSuchFigureException e){
                messenger.sendMessage(e.getMessage());
            }
        }
    }
    public GeometricFigure getFigureByUserParams(){
        GeometricFigure figure=null;
        try {
            figure = manager.createGeometricFigure(messenger.getMessage());
        } catch (Exception e) {
            messenger.sendMessage(e.getMessage());
        }
        return figure;
    }
}
