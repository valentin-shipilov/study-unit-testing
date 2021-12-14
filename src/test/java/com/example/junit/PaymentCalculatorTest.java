package com.example.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentCalculatorTest {
    private static final long givenCostForMinute = 100;

    private final PaymentCalculator testee = new PaymentCalculator(givenCostForMinute);

    @ParameterizedTest
    @EnumSource(TestParams.class)
    void should_calculate_payment(TestParams testParams) {
        // when
        Long actualResult = testee.calculatePayment(testParams.givenCategory, testParams.givenNumberOfMinutes);

        // then
        assertEquals(testParams.expectedResult, actualResult, "payment");

    }

    public enum TestParams {
        GIVEN_REGULAR_CUSTOMER_AND_1_MINUTES(CustomerCategory.REGULAR_CUSTOMER, 1L, givenCostForMinute),
        GIVEN_REGULAR_CUSTOMER_AND_2_MINUTES(CustomerCategory.REGULAR_CUSTOMER, 2L, 2*givenCostForMinute),
        GIVEN_REGULAR_CUSTOMER_AND_3_MINUTES(CustomerCategory.REGULAR_CUSTOMER, 3L, 3*givenCostForMinute),
        GIVEN_REGULAR_CUSTOMER_AND_4_MINUTES(CustomerCategory.REGULAR_CUSTOMER, 4L, 4*givenCostForMinute),
        GIVEN_REGULAR_CUSTOMER_AND_5_MINUTES(CustomerCategory.REGULAR_CUSTOMER, 5L, 5*givenCostForMinute),
        GIVEN_REGULAR_CUSTOMER_AND_6_MINUTES(CustomerCategory.REGULAR_CUSTOMER, 6L, 6*givenCostForMinute),
        GIVEN_REGULAR_CUSTOMER_AND_7_MINUTES(CustomerCategory.REGULAR_CUSTOMER, 7L, 7*givenCostForMinute),
        GIVEN_SILVER_CUSTOMER_AND_1_MINUTES(CustomerCategory.SILVER_CUSTOMER, 1L, givenCostForMinute),
        GIVEN_SILVER_CUSTOMER_AND_2_MINUTES(CustomerCategory.SILVER_CUSTOMER, 2L, givenCostForMinute),
        GIVEN_SILVER_CUSTOMER_AND_3_MINUTES(CustomerCategory.SILVER_CUSTOMER, 3L, givenCostForMinute),
        GIVEN_SILVER_CUSTOMER_AND_4_MINUTES(CustomerCategory.SILVER_CUSTOMER, 4L, givenCostForMinute),
        GIVEN_SILVER_CUSTOMER_AND_5_MINUTES(CustomerCategory.SILVER_CUSTOMER, 5L, givenCostForMinute),
        GIVEN_SILVER_CUSTOMER_AND_6_MINUTES(CustomerCategory.SILVER_CUSTOMER, 6L, 2*givenCostForMinute),
        GIVEN_SILVER_CUSTOMER_AND_7_MINUTES(CustomerCategory.SILVER_CUSTOMER, 7L, 3*givenCostForMinute),
        GIVEN_GOLDEN_CUSTOMER_AND_1_MINUTES(CustomerCategory.GOLDEN_CUSTOMER, 1L, 0L),
        GIVEN_GOLDEN_CUSTOMER_AND_2_MINUTES(CustomerCategory.GOLDEN_CUSTOMER, 2L, 0L),
        GIVEN_GOLDEN_CUSTOMER_AND_3_MINUTES(CustomerCategory.GOLDEN_CUSTOMER, 3L, 0L),
        GIVEN_GOLDEN_CUSTOMER_AND_4_MINUTES(CustomerCategory.GOLDEN_CUSTOMER, 4L, givenCostForMinute),
        GIVEN_GOLDEN_CUSTOMER_AND_5_MINUTES(CustomerCategory.GOLDEN_CUSTOMER, 5L, 2*givenCostForMinute),
        GIVEN_GOLDEN_CUSTOMER_AND_6_MINUTES(CustomerCategory.GOLDEN_CUSTOMER, 6L, 3*givenCostForMinute),
        GIVEN_GOLDEN_CUSTOMER_AND_7_MINUTES(CustomerCategory.GOLDEN_CUSTOMER, 7L, 4*givenCostForMinute),
        ;

        final CustomerCategory givenCategory;
        final long givenNumberOfMinutes;
        final long expectedResult;

        TestParams(CustomerCategory givenCategory, long givenNumberOfMinutes, long expectedResult) {
            this.givenCategory = givenCategory;
            this.givenNumberOfMinutes = givenNumberOfMinutes;
            this.expectedResult = expectedResult;
        }
    }
}
