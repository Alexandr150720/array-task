package com.example.arrays.entity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CustomArrayTest {

    private static final int LENGTH = 3;
    private static final int CHANGED_VALUE = 100;
    private static final String EXPECTED_TEXT = "CustomArray[3, 1, 2]";

    private final int[] elements = {3, 1, 2};
    private final int[] originalElements = {3, 1, 2};
    private final int[] replacement = {7, 8};

    @Test
    void getLengthShouldReturnNumberOfElements() {
        // given
        CustomArray array = new CustomArray(elements);
        // when
        int actual = array.getLength();
        // then
        assertEquals(LENGTH, actual);
    }

    @Test
    void getElementsShouldReturnWrappedValues() {
        // given
        CustomArray array = new CustomArray(elements);
        // when
        int[] actual = array.getElements();
        // then
        assertArrayEquals(originalElements, actual);
    }

    @Test
    void constructorShouldNotShareArrayWithCaller() {
        // given
        CustomArray array = new CustomArray(elements);
        elements[0] = CHANGED_VALUE;
        // when
        int[] actual = array.getElements();
        // then
        assertArrayEquals(originalElements, actual);
    }

    @Test
    void getElementsShouldReturnCopyOfInnerArray() {
        // given
        CustomArray array = new CustomArray(elements);
        int[] leaked = array.getElements();
        leaked[0] = CHANGED_VALUE;
        // when
        int[] actual = array.getElements();
        // then
        assertArrayEquals(originalElements, actual);
    }

    @Test
    void setElementsShouldReplaceContent() {
        // given
        CustomArray array = new CustomArray(elements);
        // when
        array.setElements(replacement);
        // then
        assertArrayEquals(replacement, array.getElements());
    }

    @Test
    void toStringShouldContainElements() {
        // given
        CustomArray array = new CustomArray(elements);
        // when
        String actual = array.toString();
        // then
        assertEquals(EXPECTED_TEXT, actual);
    }
}
