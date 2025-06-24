package com.comarch.szkolenia.spring.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void divideTest() {
        Calculator calculator = new Calculator();
        int a = 6;
        int b = 3;
        int expectedResult = 2;

        int actual = calculator.divide(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }
}
