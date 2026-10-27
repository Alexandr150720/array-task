package com.example.arrays.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.arrays.entity.CustomArray;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ArrayStatisticsServiceImplTest {

    private static final int MIN = -7;
    private static final int MAX = 12;
    private static final long SUM = 10;
    private static final double AVERAGE = 2.0;
    private static final double DELTA = 0.0001;
    private static final long LARGE_SUM = 2147483648L;

    private final ArrayStatisticsService service = new ArrayStatisticsServiceImpl();
    private final int[] elements = {4, -7, 12, 0, 1};
    private final int[] largeElements = {Integer.MAX_VALUE, 1};
    private final int[] noElements = {};

    @Test
    void findMinShouldReturnSmallestElement() {
        // given
        CustomArray array = new CustomArray(elements);
        // when
        Optional<Integer> actual = service.findMin(array);
        // then
        assertEquals(Optional.of(MIN), actual);
    }

    @Test
    void findMinShouldReturnEmptyOptionalForEmptyArray() {
        // given
        CustomArray array = new CustomArray(noElements);
        // when
        Optional<Integer> actual = service.findMin(array);
        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void findMaxShouldReturnLargestElement() {
        // given
        CustomArray array = new CustomArray(elements);
        // when
        Optional<Integer> actual = service.findMax(array);
        // then
        assertEquals(Optional.of(MAX), actual);
    }

    @Test
    void findMaxShouldReturnEmptyOptionalForEmptyArray() {
        // given
        CustomArray array = new CustomArray(noElements);
        // when
        Optional<Integer> actual = service.findMax(array);
        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void calculateSumShouldAddAllElements() {
        // given
        CustomArray array = new CustomArray(elements);
        // when
        Optional<Long> actual = service.calculateSum(array);
        // then
        assertEquals(Optional.of(SUM), actual);
    }

    @Test
    void calculateSumShouldNotOverflowInt() {
        // given
        CustomArray array = new CustomArray(largeElements);
        // when
        Optional<Long> actual = service.calculateSum(array);
        // then
        assertEquals(Optional.of(LARGE_SUM), actual);
    }

    @Test
    void calculateSumShouldReturnEmptyOptionalForEmptyArray() {
        // given
        CustomArray array = new CustomArray(noElements);
        // when
        Optional<Long> actual = service.calculateSum(array);
        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void calculateAverageShouldDivideSumByLength() {
        // given
        CustomArray array = new CustomArray(elements);
        // when
        Optional<Double> actual = service.calculateAverage(array);
        // then
        assertEquals(AVERAGE, actual.get(), DELTA);
    }

    @Test
    void calculateAverageShouldReturnEmptyOptionalForEmptyArray() {
        // given
        CustomArray array = new CustomArray(noElements);
        // when
        Optional<Double> actual = service.calculateAverage(array);
        // then
        assertTrue(actual.isEmpty());
    }
}
