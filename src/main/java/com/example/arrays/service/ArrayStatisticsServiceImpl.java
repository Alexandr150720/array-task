package com.example.arrays.service;

import com.example.arrays.entity.CustomArray;
import java.util.Optional;

public class ArrayStatisticsServiceImpl implements ArrayStatisticsService {

    @Override
    public Optional<Integer> findMin(CustomArray array) {
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return Optional.empty();
        }
        int min = elements[0];
        for (int element : elements) {
            if (element < min) {
                min = element;
            }
        }
        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMax(CustomArray array) {
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return Optional.empty();
        }
        int max = elements[0];
        for (int element : elements) {
            if (element > max) {
                max = element;
            }
        }
        return Optional.of(max);
    }

    @Override
    public Optional<Long> calculateSum(CustomArray array) {
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return Optional.empty();
        }
        long sum = 0;
        for (int element : elements) {
            sum += element;
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverage(CustomArray array) {
        Optional<Long> sum = calculateSum(array);
        if (sum.isPresent()) {
            long total = sum.get();
            int length = array.getLength();
            double average = (double) total / length;
            return Optional.of(average);
        } else {
            return Optional.empty();
        }
    }
}
