package com.example.calculator;

import com.example.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

;

public class CalculatorServiceImplTest {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @Test
    public void shouldReturnCorrectResulForPlus() {
        int num1 = 5;
        int num2 = 7;
        int result = num1 + num2;
        String expected = num1 + " + " + num2 + " = " + result;

        String actual = out.plus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectResulFoMinus() {
        int num1 = 5;
        int num2 = 7;
        int result = num1 - num2;
        String expected = num1 + " - " + num2 + " = " + result;

        String actual = out.minus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectResulFoMultiply() {
        int num1 = 5;
        int num2 = 7;
        int result = num1 * num2;
        String expected = num1 + " * " + num2 + " = " + result;

        String actual = out.multiply(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectResulForDivide() {
        int num1 = 5;
        int num2 = 7;
        int result = num1 / num2;
        String expected = num1 + " / " + num2 + " = " + result;

        String actual = out.divide(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfParamIsNullForPlus() {
        Integer num1 = null;
        Integer num2 = 3;

        Assertions.assertThrows(NullPointerException.class, () -> out.plus(num1, num2));
    }

    @Test
    public void shouldThrowExceptionIfParamIsNullForMinus() {
        Integer num1 = null;
        Integer num2 = 3;

        Assertions.assertThrows(NullPointerException.class, () -> out.minus(num1, num2));
    }

    @Test
    public void shouldThrowExceptionIfParamIsNullForMultiply() {
        Integer num1 = null;
        Integer num2 = 3;

        Assertions.assertThrows(NullPointerException.class, () -> out.multiply(num1, num2));
    }

    @Test
    public void shouldThrowExceptionIfParamIsNullForDivide() {
        Integer num1 = null;
        Integer num2 = 3;

        Assertions.assertThrows(NullPointerException.class, () -> out.divide(num1, num2));
    }

    @Test
    public void shouldThrowExceptionIf2ParamIs0ForDivide() {
        Integer num1 = 5;
        Integer num2 = 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> out.divide(num1, num2));
    }

}
