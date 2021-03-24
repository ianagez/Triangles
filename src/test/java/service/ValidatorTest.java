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

    @Test
    void ValidPositiveValueConvertToDoubleTest() {
        String input="3";
        double expected=3.0;
        double actual=Validator.convertToDouble(input);
        assertEquals(expected,actual);
    }
    @Test
    void ValidNegativeValueConvertToDoubleTest() {
        String input="-3";
        double expected=-3.0;
        double actual=Validator.convertToDouble(input);
        assertEquals(expected,actual);
    }
    @Test
    void ZeroValueConvertToDoubleTest() {
        String input="0";
        double expected=0.0;
        double actual=Validator.convertToDouble(input);
        assertEquals(expected,actual);
    }
    @Test
    void NumberFormatExceptionValueConvertToDoubleTest() {
        String input="l";
        assertThrows(NumberFormatException.class,()->Validator.convertToDouble(input));
    }
    @Test
    void PositiveValueConvertToValidDoubleParamTest() throws InvalidNumberException{
        String input="10";
        double expected=10.0;
        double actual=Validator.convertToValidDoubleParam(input);
        assertEquals(expected,actual);
    }
    @Test
    void NegativeValueConvertToValidDoubleParamTest(){
        String input="-10";
        assertThrows(InvalidNumberException.class,()->Validator.convertToValidDoubleParam(input));
    }
    @Test
    void ZeroValueConvertToValidDoubleParamTest(){
        String input="0";
        assertThrows(InvalidNumberException.class,()->Validator.convertToValidDoubleParam(input));
    }
    @Test
    void StringValueWithTabsConvertToValidDoubleParamTest() throws InvalidNumberException{
        String input="  10  .   0 0 ";
        double expected=10.0;
        double actual=Validator.convertToValidDoubleParam(input);
        assertEquals(expected,actual);
    }
}