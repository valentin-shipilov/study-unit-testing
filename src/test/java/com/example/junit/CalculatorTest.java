package com.example.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator testee = new Calculator();

    @Test
    public void given_two_numbers_when_add_then_should_get_sum() {
        // given
        int first = 2;
        int second = 3;

        // when
        int actualResult = testee.add(first, second);

        // then
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult, "sum");
    }

    @Test
    public void given_two_numbers_when_mul_then_should_get_product() {
        // given
        int first = 2;
        int second = 3;

        // when
        int actualResult = testee.mul(first, second);

        // then
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult, "mul");
    }
}