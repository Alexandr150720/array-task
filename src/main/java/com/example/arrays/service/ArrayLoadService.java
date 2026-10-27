package com.example.arrays.service;

import com.example.arrays.entity.CustomArray;
import com.example.arrays.exception.CustomArrayException;
import java.util.List;

public interface ArrayLoadService {

    List<CustomArray> loadArrays(String filePath) throws CustomArrayException;
}
