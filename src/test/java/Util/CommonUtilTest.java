package Util;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonUtilTest {

    @ParameterizedTest
    @CsvSource({"20.123 , 20.12, 2", "2.9999 , 3.00, 2", "0.9999, 1.0, 2", "0,0,0",
                "20.12356 , 20.1236, 4", "30000.999999 , 30001, 4", "0.99999, 1.0, 4","0,0,4"})
    void roundNumber_PositiveValues(double input,double expected, int factorial) {
    double actual=CommonUtil.roundNumber(input,factorial);
        assertEquals(expected,actual);
    }
    @ParameterizedTest
    @CsvSource({"-20.12356 , -20.1236", "-30000.999999 , -30001", "-0.99999, -1.0","-0,0"})
    void roundNumberTest_NegativeValues(double input,double expected) {
        double actual=CommonUtil.roundNumber(input,4);
        assertEquals(expected,actual);
    }

    @Test
    void ZeroRoundNumberTest() {
        double input=0;
        int factorial=4;
        double expected=0.0;
        double actual=CommonUtil.roundNumber(input,factorial);
        assertEquals(expected,actual);
    }
    @ParameterizedTest
    @CsvSource({"-20.12356 , -20.1236", "-30000.999999 , -30001", "-0.9999, -1.0","-0,0"})
    void ZeroFactorialRoundNumberTest() {
        double input=12.9456;
        int factorial=0;
        double expected=13.0;
        double actual=CommonUtil.roundNumber(input,factorial);
        assertEquals(expected,actual);
    }
}