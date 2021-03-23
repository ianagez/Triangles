package service.factory;

import exception.FigureParametersException;
import model.GeometricFigure;

import java.util.List;
import java.util.Set;

public abstract class FigureManager {
    private final String figureName;
    private final String paramsExample;

    public FigureManager(String figureName, String paramsExample){
        this.figureName=figureName;
        this.paramsExample=paramsExample;

    }
    public String getFigureName() {
        return figureName;
    }
    public String getParamsExample(){ return paramsExample; }

    public abstract GeometricFigure createGeometricFigure(String figureParams) throws FigureParametersException;

    public String figuresToString(List<GeometricFigure> figures) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("============= %ss list: ===============", getFigureName()));
        sb.append("\n");
        int i = 1;
        for (GeometricFigure figure : figures) {
            sb.append(i);
            sb.append(".");
            sb.append(figure.toString());
            if (i <= figures.size()) {
                sb.append("\n");
            }
            i++;
        }
        return sb.toString();
    }
}
