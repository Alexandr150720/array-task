package com.example.arrays.factory;

import com.example.arrays.entity.CustomArray;
import com.example.arrays.exception.CustomArrayException;

public interface CustomArrayFactory {

    CustomArray create(int[] elements) throws CustomArrayException;
}
