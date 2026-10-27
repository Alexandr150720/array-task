package com.example.arrays.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ArrayLineValidatorImplTest {

    private final ArrayLineValidator validator = new ArrayLineValidatorImpl();

    @ParameterizedTest
    @ValueSource(strings = {
        "1, 2, 3",
        "1; 2; 3",
        "1 - 2 - 3",
        "1 \u2013 2 - 3",
        "3 4 7",
        "11- 2 \u2013 42-",
        "  5  ",
        "7"
    })
    void isValidShouldReturnTrueForCorrectLine(String line) {
        // when
        boolean actual = validator.isValid(line);
        // then
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1y1 21 32",
        "1, 2, x3, 6..5, 77",
        "",
        "   ",
        "- ; ,",
        "1.5 2",
        "12345678901 3"
    })
    void isValidShouldReturnFalseForIncorrectLine(String line) {
        // when
        boolean actual = validator.isValid(line);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidShouldReturnFalseForNull() {
        // given
        String line = null;
        // when
        boolean actual = validator.isValid(line);
        // then
        assertFalse(actual);
    }
}
