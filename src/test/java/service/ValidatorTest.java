package service;

import exception.InvalidNumberException;
import exception.InvalidParametersException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ValidatorTest {

    @ParameterizedTest
    @CsvSource({"TRIANGLE, Triangle","CiRcLe, Circle", "circle, Circle ", "rectanglE, Rectangle "})
    void getFormattedNameParamTest_Case(String input,String expected) throws InvalidParametersException{
        String actual=Validator.getFormattedNameParam(input);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource({"Triangle       name , Triangle name","CiRcLe   the    best, Circle the best",
            "circle     TWO, Circle two ", "    rectanglE   name  , Rectangle name"})
    void getFormattedNameParamTest_Tab(String input,String expected) throws InvalidParametersException {
        String actual=Validator.getFormattedNameParam(input);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @EmptySource
    void getFormattedNameParam_TestEmptyString(String input) {
        assertThrows(InvalidParametersException.class,  ()->Validator.getFormattedNameParam(input));
    }

    @ParameterizedTest
    @CsvSource({"3,3","632.632,632.632","-20345.8976,-20345.8976", "-12345,-12345", "0,0"})
    void convertToDoubleTest_ValidValues(String input,double expected) {
        double actual=Validator.convertToDouble(input);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource({"l","try","H"})
    void convertToDoubleTest_NumberFormatException(String input) {
        assertThrows(NumberFormatException.class,()->Validator.convertToDouble(input));
    }

    @ParameterizedTest
    @CsvSource({"3,3","632.632,632.632","20345.8976,20345.8976", "12345,12345"})
    void convertToValidDoubleParamTest_PositiveValue(String input,double expected) throws InvalidNumberException{
        double actual=Validator.convertToValidDoubleParam(input);
        assertEquals(expected,actual);
    }
    @ParameterizedTest
    @CsvSource({"-3","-632.632","-20345.8976", "-12345"})
    void convertToValidDoubleParamTest_NegativeValueC(String input){
        assertThrows(InvalidNumberException.class,()->Validator.convertToValidDoubleParam(input));
    }
    @Test
    void convertToValidDoubleParamTest_ZeroValue(){
        String input="0";
        assertThrows(InvalidNumberException.class,()->Validator.convertToValidDoubleParam(input));
    }
    @ParameterizedTest
    @CsvSource({"3,3",
            "6    3   2. 632,    632.632",
            "  2   0   3   4   5   .   8   9  7    6, 20345.8976",
            "  1   2   3   4   5,12345",})
    void convertToValidDoubleParamTest_StringValueWithTabs(String input,double expected) throws InvalidNumberException{
        double actual=Validator.convertToValidDoubleParam(input);
        assertEquals(expected,actual);
    }
}