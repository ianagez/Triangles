package service.factory;

import exception.FigureParametersException;
import exception.WrongParametersLength;
import model.Triangle;
import service.Validator;
import java.util.Arrays;


public class TriangleManager extends FigureManager {
    public TriangleManager() {
        super("Triangle","Example: name, side1, side2, side3");
    }

    @Override
    public String getFigureName() { return super.getFigureName(); }

    @Override
    public String getParamsExample() { return super.getParamsExample(); }

    @Override
    public Triangle createGeometricFigure(String params) throws FigureParametersException {
        String[] paramArr = params.split(","); //getValidParaArrFor(getFigureName(), getParamsExample());
        if (paramArr.length != 4) {
            throw new WrongParametersLength("It should be 4 parameters to build a triangle.");
        }
        String nameParam = Validator.getFormattedNameParam(paramArr[0]);
        double[] numericParams = Validator.getFormattedNumericParams(Arrays.copyOfRange(paramArr, 1, paramArr.length));
        return new Triangle(nameParam, numericParams[0], numericParams[1], numericParams[2]);
    }
}
