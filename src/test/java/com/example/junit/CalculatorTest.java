package com.example.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator testee = new Calculator();

    @Test
    void given_two_numbers_when_add_then_should_get_sum() {
        // given
        int givenFirst = 2;
        int givenSecond = 3;

        // when
        int actualResult = testee.add(givenFirst, givenSecond);

        // then
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult, "sum");
    }

    @Test
    void given_two_numbers_when_mul_then_should_get_product() {
        // given
        int givenFirst = 2;
        int givenSecond = 3;

        // when
        int actualResult = testee.mul(givenFirst, givenSecond);

        // then
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult, "mul");
    }
}
