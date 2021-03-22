package service.factory;

import exception.InvalidNumberException;
import exception.WrongParametersLength;
import exception.InvalidParametersException;
import model.Circle;
import model.GeometricFigure;
import model.Rectangle;
import service.Validator;

import java.util.Arrays;
import java.util.Set;

public class CircleManager extends FigureManager {

    public CircleManager() {
        super("Circle", "Example: name, radius");
    }

    @Override
    public String getFigureName() {
        return super.getFigureName();
    }

    @Override
    public String getParamsExample() {
        return super.getParamsExample();
    }


    @Override
    public Circle createGeometricFigure(String params) throws WrongParametersLength,
            NumberFormatException, InvalidNumberException, InvalidParametersException{
        String[] paramArr = params.split(",");
        if (paramArr.length != 2) {
            throw new WrongParametersLength("It should be 2 parameters to build a circle.");
        }
        String nameParam = Validator.getFormattedNameParam(paramArr[0]);
        double[] numericParams = Validator.getFormattedNumericParams(Arrays.copyOfRange(paramArr, 1, paramArr.length));
        return new Circle(nameParam, numericParams[0]);
    }
}
