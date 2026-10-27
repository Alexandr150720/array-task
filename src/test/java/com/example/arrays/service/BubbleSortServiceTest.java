package com.example.arrays.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.example.arrays.entity.CustomArray;
import org.junit.jupiter.api.Test;

class BubbleSortServiceTest {

    private final ArraySortService service = new BubbleSortService();
    private final int[] unsorted = {5, -2, 9, 0, 5, 1};
    private final int[] sorted = {-2, 0, 1, 5, 5, 9};
    private final int[] descending = {9, 5, 5, 1, 0, -2};
    private final int[] single = {42};
    private final int[] noElements = {};

    @Test
    void sortShouldArrangeElementsInAscendingOrder() {
        // given
        CustomArray array = new CustomArray(unsorted);
        // when
        service.sort(array);
        // then
        assertArrayEquals(sorted, array.getElements());
    }

    @Test
    void sortShouldKeepSortedElementsUnchanged() {
        // given
        CustomArray array = new CustomArray(sorted);
        // when
        service.sort(array);
        // then
        assertArrayEquals(sorted, array.getElements());
    }

    @Test
    void sortShouldReverseDescendingElements() {
        // given
        CustomArray array = new CustomArray(descending);
        // when
        service.sort(array);
        // then
        assertArrayEquals(sorted, array.getElements());
    }

    @Test
    void sortShouldKeepSingleElement() {
        // given
        CustomArray array = new CustomArray(single);
        // when
        service.sort(array);
        // then
        assertArrayEquals(single, array.getElements());
    }

    @Test
    void sortShouldAcceptEmptyArray() {
        // given
        CustomArray array = new CustomArray(noElements);
        // when
        service.sort(array);
        // then
        assertArrayEquals(noElements, array.getElements());
    }
}
