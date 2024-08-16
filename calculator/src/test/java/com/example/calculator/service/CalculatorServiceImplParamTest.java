package com.example.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplParamTest {

    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void shouldReturnCorrectPlus(int num1, int num2) {

        int result = num1 + num2;
        String expected = num1 + " + " + num2 + " = " + result;

        String actual = out.plus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void shouldReturnCorrectMinus(int num1, int num2) {

        int result = num1 - num2;
        String expected = num1 + " - " + num2 + " = " + result;

        String actual = out.minus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void shouldReturnCorrectMultiply(int num1, int num2) {

        int result = num1 * num2;
        String expected = num1 + " * " + num2 + " = " + result;

        String actual = out.multiply(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void shouldReturnCorrectDivide(int num1, int num2) {

        int result = num1 / num2;
        String expected = num1 + " / " + num2 + " = " + result;

        String actual = out.divide(num1, num2);
        Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("provideNullParamsForTest")
    public void shouldThrowExceptionIfParamIsNullForPlus(String message, Integer num1, Integer num2) {

        Assertions.assertThrows(NullPointerException.class, () -> out.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideNullParamsForTest")
    public void shouldThrowExceptionIfParamIsNullForMinus(String message, Integer num1, Integer num2) {

        Assertions.assertThrows(NullPointerException.class, () -> out.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideNullParamsForTest")
    public void shouldThrowExceptionIfParamIsNullForMultiply(String message, Integer num1, Integer num2) {

        Assertions.assertThrows(NullPointerException.class, () -> out.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideNullParamsForTest")
    public void shouldThrowExceptionIfParamIsNullForDivide(String message, Integer num1, Integer num2) {

        Assertions.assertThrows(NullPointerException.class, () -> out.divide(num1, num2));
    }

    public static Stream<Arguments> provideParamsForTest() {
        return Stream.of(Arguments.of(1, 2),
        Arguments.of(17, 62),
        Arguments.of(-1, 1000));
    }

    public static Stream<Arguments> provideNullParamsForTest() {
        return Stream.of(Arguments.of("Отсутствует первый параметр", null, 2),
                Arguments.of("Отсутствует второй параметр", 17, null),
                Arguments.of("Отсутствуют оба параметра", null, null));
    }

}