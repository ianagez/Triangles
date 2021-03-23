package service.factory;

import exception.FigureParametersException;
import exception.WrongParametersLength;
import model.Rectangle;
import service.Validator;
import java.util.Arrays;


public class RectangleManager extends FigureManager {

    public RectangleManager() {
        super("Rectangle", "Example: name, side1, side2");
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
    public Rectangle createGeometricFigure(String params) throws FigureParametersException {
        String[] paramArr = params.split(",");
        if (paramArr.length != 3) {
            throw new WrongParametersLength("It should be 3 parameters to build a rectangle.");
        }

        String nameParam = Validator.getFormattedNameParam(paramArr[0]);
        double[] numericParams = Validator.getFormattedNumericParams(Arrays.copyOfRange(paramArr, 1, paramArr.length));
        return new Rectangle(nameParam, numericParams[0], numericParams[1]);
    }
}
