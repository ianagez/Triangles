package Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonUtilTest {

    @Test
    void PositiveRoundNumberTest() {
        double input=12.1234;
        int factorial=2;
        double expected=12.12;
        double actual=CommonUtil.roundNumber(input,factorial);
        assertEquals(expected,actual);
    }
    @Test
    void NegativeRoundNumberTest() {
        double input=-1234.56788;
        int factorial=4;
        double expected=-1234.5679;
        double actual=CommonUtil.roundNumber(input,factorial);
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
    @Test
    void ZeroFactorialRoundNumberTest() {
        double input=12.9456;
        int factorial=0;
        double expected=13.0;
        double actual=CommonUtil.roundNumber(input,factorial);
        assertEquals(expected,actual);
    }
}