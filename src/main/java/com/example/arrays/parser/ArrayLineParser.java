package com.example.arrays.parser;

import com.example.arrays.exception.CustomArrayException;

public interface ArrayLineParser {

    int[] parse(String line) throws CustomArrayException;
}
