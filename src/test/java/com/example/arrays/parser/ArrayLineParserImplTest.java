package com.example.arrays.parser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.arrays.exception.CustomArrayException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ArrayLineParserImplTest {

    private static final String COMMA_LINE = "1, 2, 3";
    private static final String SPACE_LINE = "3 4 7";
    private static final String MIXED_LINE = "11- 2 \u2013 42-";
    private static final String EMPTY_LINE = "";
    private static final String TOO_BIG_LINE = "1, 99999999999";

    private final ArrayLineParser parser = new ArrayLineParserImpl();
    private final int[] commaNumbers = {1, 2, 3};
    private final int[] spaceNumbers = {3, 4, 7};
    private final int[] mixedNumbers = {11, 2, 42};
    private final int[] noNumbers = {};

    @Test
    void parseShouldSplitLineByCommas() throws CustomArrayException {
        // when
        int[] actual = parser.parse(COMMA_LINE);
        // then
        assertArrayEquals(commaNumbers, actual);
    }

    @Test
    void parseShouldSplitLineBySpaces() throws CustomArrayException {
        // when
        int[] actual = parser.parse(SPACE_LINE);
        // then
        assertArrayEquals(spaceNumbers, actual);
    }

    @Test
    void parseShouldHandleMixedAndTrailingDelimiters() throws CustomArrayException {
        // when
        int[] actual = parser.parse(MIXED_LINE);
        // then
        assertArrayEquals(mixedNumbers, actual);
    }

    @Test
    void parseShouldReturnNoNumbersForEmptyLine() throws CustomArrayException {
        // when
        int[] actual = parser.parse(EMPTY_LINE);
        // then
        assertArrayEquals(noNumbers, actual);
    }

    @Test
    void parseShouldThrowExceptionWhenNumberDoesNotFitIntoInt() {
        // when
        Executable action = () -> parser.parse(TOO_BIG_LINE);
        // then
        assertThrows(CustomArrayException.class, action);
    }

    @Test
    void parseShouldThrowExceptionWhenLineIsNull() {
        // given
        String line = null;
        // when
        Executable action = () -> parser.parse(line);
        // then
        assertThrows(CustomArrayException.class, action);
    }
}
