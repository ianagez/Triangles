package service;

import exception.InvalidNumberException;
import exception.InvalidParametersException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    @Test
    void getFormattedNameParamTest() throws InvalidParametersException{
        String input="TRIANGLE";
        String expected="Triangle";
        String actual=Validator.getFormattedNameParam(input);
        assertEquals(expected,actual);
    }

    @Test
    void StringWithTabGetFormattedNameParamTest() throws InvalidParametersException {
        String input="  TRIANGLE      the best one  ";
        String expected="Triangle the best one";
        String actual=Validator.getFormattedNameParam(input);
        assertEquals(expected,actual);
    }

    @Test
    void EmptyStringGetFormattedNameParamTest() {
        String input="";
        assertThrows(InvalidParametersException.class,  ()->Validator.getFormattedNameParam(input));
    }

    @Test
    void ValidParamValueGetFormattedNumericParamsTest() throws InvalidNumberException{
        String[] input= {"2.0","5.7","3.2"};
        double[] expected= {2.0,5.7,3.2};
        double[] actual=Validator.getFormattedNumericParams(input);
        assertTrue(Arrays.equals(expected, actual));
    }
    @Test
    void ParamsWithTabsValueGetFormattedNumericParamsTest() throws InvalidNumberException{
        String[] input= {"2.    0","    5.7","  3.    2   "};
        double[] expected= {2.0,5.7,3.2};
        double[] actual=Validator.getFormattedNumericParams(input);
        assertTrue(Arrays.equals(expected, actual));
    }
    @Test
    void NegativeValueTabsValueGetFormattedNumericParamsTest() {
        String[] input= {"-2.0","5.7","3.2"};
        assertThrows(InvalidNumberException.class,  ()->Validator.getFormattedNumericParams(input));
    }
    @Test
    void ZeroParamValueGetFormattedNumericParamsTest() {
        String[] input= {"2","0","3"};
        assertThrows(InvalidNumberException.class,  ()->Validator.getFormattedNumericParams(input));
    }
    @Test
    void NumberFormatExceptionGetFormattedNumericParamsTest() {
        String[] input= {"2","a","3"};
        assertThrows(NumberFormatException.class,  ()->Validator.getFormattedNumericParams(input));
    }
}