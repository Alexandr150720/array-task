package com.example.arrays.service;

import com.example.arrays.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSortService implements ArraySortService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void sort(CustomArray array) {
        int[] elements = array.getElements();
        for (int i = 1; i < elements.length; i++) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
        array.setElements(elements);
        logger.debug("Insertion sort finished: {}", array);
    }
}
