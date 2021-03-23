package service;

import exception.InvalidNumberException;
import exception.InvalidParametersException;

public class Validator {
    public static String getFormattedNameParam(String nameParam) throws InvalidParametersException {
        nameParam = nameParam.toLowerCase();
        nameParam = nameParam.trim().replaceAll(" +", " ");
        if(nameParam.length()==0){
            throw new InvalidParametersException("It is impossible to create a figure without name.");
        }
        nameParam = nameParam.substring(0, 1).toUpperCase() + nameParam.substring(1);
        return nameParam;
    }

    public static double[] getFormattedNumericParams(String[] numberParamsString) throws InvalidNumberException {
        double[] numericParams = new double[numberParamsString.length];
        for (int i = 0; i < numericParams.length; i++) {
            numericParams[i]= convertToValidDoubleParam(numberParamsString[i]);
        }
        return numericParams;
    }

    public static double convertToValidDoubleParam(String stringParam) throws InvalidNumberException{
        stringParam = stringParam.trim().replaceAll(" +", "");
        double number =convertToDouble(stringParam);
        if (number <= 0) {
            throw new InvalidNumberException("Numeric parameters should be more than zero.");
        }
        return number;
    }

    public static double convertToDouble(String stringParam){
        double number;
        try{
            number = Double.parseDouble(stringParam);
        }catch (NumberFormatException e){
            throw new  NumberFormatException(e.getMessage()+" number is expected.");
        }
        return number;
    }
}
