package com.example.arrays.service;

import com.example.arrays.entity.CustomArray;
import com.example.arrays.exception.CustomArrayException;
import com.example.arrays.factory.CustomArrayFactory;
import com.example.arrays.parser.ArrayLineParser;
import com.example.arrays.reader.ArrayFileReader;
import com.example.arrays.validator.ArrayLineValidator;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayLoadServiceImpl implements ArrayLoadService {

    private static final Logger logger = LogManager.getLogger();

    private final ArrayFileReader reader;
    private final ArrayLineValidator validator;
    private final ArrayLineParser parser;
    private final CustomArrayFactory factory;

    public ArrayLoadServiceImpl(ArrayFileReader reader, ArrayLineValidator validator,
            ArrayLineParser parser, CustomArrayFactory factory) {
        this.reader = reader;
        this.validator = validator;
        this.parser = parser;
        this.factory = factory;
    }

    @Override
    public List<CustomArray> loadArrays(String filePath) throws CustomArrayException {
        List<String> lines = reader.readLines(filePath);
        List<CustomArray> arrays = new ArrayList<>();
        for (String line : lines) {
            if (validator.isValid(line)) {
                int[] elements = parser.parse(line);
                CustomArray array = factory.create(elements);
                arrays.add(array);
            } else {
                logger.warn("Invalid line skipped: '{}'", line);
            }
        }
        int linesCount = lines.size();
        int arraysCount = arrays.size();
        logger.info("Created {} arrays from {} lines", arraysCount, linesCount);
        return arrays;
    }
}
