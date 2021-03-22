package service.factory;

import exception.InvalidNumberException;
import exception.InvalidParametersException;
import exception.WrongParametersLength;
import model.GeometricFigure;
import model.Triangle;
import service.Validator;

import java.util.Arrays;
import java.util.Set;

public class TriangleManager extends FigureManager {
    public TriangleManager() {
        super("Triangle","Example: name, side1, side2, side3");
    }

    @Override
    public String getFigureName() {
        return super.getFigureName();
    }

    @Override
    public String getParamsExample() { return super.getParamsExample(); }

    @Override
    public Triangle createGeometricFigure(String params) throws WrongParametersLength,
            NumberFormatException, InvalidNumberException,InvalidParametersException {
        String[] paramArr = params.split(",");
        if (paramArr.length != 4) {
            throw new WrongParametersLength("It should be 4 parameters to build a triangle.");
        }
        String nameParam = Validator.getFormattedNameParam(paramArr[0]);
        double[] numericParams = Validator.getFormattedNumericParams(Arrays.copyOfRange(paramArr, 1, paramArr.length));
        Triangle triangle=new Triangle(nameParam, numericParams[0], numericParams[1], numericParams[2]);
        if(triangle.getArea()<=0){
            throw new InvalidParametersException("It is impossible to create a triangle with these sides.");
        }
        return triangle;
    }
}
