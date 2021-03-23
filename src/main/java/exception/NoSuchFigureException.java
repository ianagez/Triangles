package exception;

public class NoSuchFigureException extends FigureParametersException{
    public  NoSuchFigureException(String msg){
        super(msg);
    }
}
