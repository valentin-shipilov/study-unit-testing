package com.example.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SiteCategoryCalculatorTest {
    private final SiteCategoryCalculator testee = new SiteCategoryCalculator();

    @ParameterizedTest
    @CsvSource({
            "0, CARTOONS",
            "5, CARTOONS",
            "9, CARTOONS",
            "10, GAMES",
            "11, GAMES",
            "15, GAMES",
            "17, GAMES",
            "18, IT",
            "19, IT",
            "20, IT",
            "24, IT",
            "25, PSYCHOLOGY",
            "26, PSYCHOLOGY",
            "35, PSYCHOLOGY",
            "49, PSYCHOLOGY",
            "50, CULTURE",
            "51, CULTURE",
            "65, CULTURE"
    })
    void given_valid_age_the_should_calculate_appropriate_site_category(
            int givenAge,
            SiteCategory expectedSiteCategory
    ){
        // when
        SiteCategory actualSiteCategory = testee.calculateCategoryByAge(givenAge);

        // then
        assertEquals(expectedSiteCategory, actualSiteCategory, "site category");
    }

    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            -5,
            -50
    })
    void given_negative_age_the_should_get_error(
            int givenAge
    ){
        // when/then
        assertThrows(IllegalArgumentException.class, () -> testee.calculateCategoryByAge(givenAge));
    }

}
