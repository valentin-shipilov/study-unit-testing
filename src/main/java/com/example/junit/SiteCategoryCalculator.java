package com.example.junit;

public class SiteCategoryCalculator {
    public SiteCategory calculateCategoryByAge(int age) {
        if (age >= 0 && age < 10) {
            return SiteCategory.CARTOONS;
        } else if (age >= 10 && age < 18) {
            return SiteCategory.GAMES;
        } else if (age >= 18 && age < 25) {
            return SiteCategory.IT;
        } else if (age >= 25 && age < 50) {
            return SiteCategory.PSYCHOLOGY;
        } else if (age >= 50) {
            return SiteCategory.CULTURE;
        } else {
            throw new IllegalArgumentException("Invalid age");
        }
    }
}
