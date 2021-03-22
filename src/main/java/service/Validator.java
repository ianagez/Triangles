package service;

import exception.InvalidNumberException;

public class Validator {
    public static String getFormattedNameParam(String nameParam) {
        nameParam = nameParam.toLowerCase();
        nameParam = nameParam.trim().replaceAll(" +", " ");
        nameParam = nameParam.substring(0, 1).toUpperCase() + nameParam.substring(1);
        return nameParam;
    }

    public static double[] getFormattedNumericParams(String[] numberParamsString) throws
            InvalidNumberException, NumberFormatException {
        double[] numericParams = new double[numberParamsString.length];
        for (int i = 0; i < numberParamsString.length; i++) {
            numberParamsString[i] = numberParamsString[i].trim().replaceAll(" +", "");
            try{
                numericParams[i] = Double.parseDouble(numberParamsString[i]);
            }catch (NumberFormatException e){
                throw new  NumberFormatException(e.getMessage()+" number is expected.");
            }
            if (numericParams[i] <= 0) {
                throw new InvalidNumberException("Numeric parameters should be more than zero.");
            }
        }
        return numericParams;
    }
}
