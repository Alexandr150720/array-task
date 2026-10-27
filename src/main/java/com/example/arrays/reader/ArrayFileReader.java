package com.example.arrays.reader;

import com.example.arrays.exception.CustomArrayException;
import java.util.List;

public interface ArrayFileReader {

    List<String> readLines(String filePath) throws CustomArrayException;
}
