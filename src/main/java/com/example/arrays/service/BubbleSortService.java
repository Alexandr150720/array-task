package com.example.arrays.service;

import com.example.arrays.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSortService implements ArraySortService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void sort(CustomArray array) {
        int[] elements = array.getElements();
        int length = elements.length;
        boolean swapped = true;
        for (int pass = 0; swapped && pass < length - 1; pass++) {
            swapped = false;
            for (int i = 0; i < length - 1 - pass; i++) {
                if (elements[i] > elements[i + 1]) {
                    int buffer = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = buffer;
                    swapped = true;
                }
            }
        }
        array.setElements(elements);
        logger.debug("Bubble sort finished: {}", array);
    }
}
