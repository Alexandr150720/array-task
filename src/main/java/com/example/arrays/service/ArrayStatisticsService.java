package com.example.arrays.service;

import com.example.arrays.entity.CustomArray;
import java.util.Optional;

public interface ArrayStatisticsService {

    Optional<Integer> findMin(CustomArray array);

    Optional<Integer> findMax(CustomArray array);

    Optional<Long> calculateSum(CustomArray array);

    Optional<Double> calculateAverage(CustomArray array);
}
