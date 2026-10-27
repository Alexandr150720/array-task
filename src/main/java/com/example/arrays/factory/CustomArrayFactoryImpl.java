package com.example.arrays.factory;

import com.example.arrays.entity.CustomArray;
import com.example.arrays.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray create(int[] elements) throws CustomArrayException {
        if (elements == null) {
            throw new CustomArrayException("Elements must not be null");
        }
        CustomArray array = new CustomArray(elements);
        logger.debug("Created {}", array);
        return array;
    }
}
