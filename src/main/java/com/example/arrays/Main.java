package com.example.arrays;

import com.example.arrays.entity.CustomArray;
import com.example.arrays.exception.CustomArrayException;
import com.example.arrays.factory.CustomArrayFactory;
import com.example.arrays.factory.CustomArrayFactoryImpl;
import com.example.arrays.parser.ArrayLineParser;
import com.example.arrays.parser.ArrayLineParserImpl;
import com.example.arrays.reader.ArrayFileReader;
import com.example.arrays.reader.ArrayFileReaderImpl;
import com.example.arrays.service.ArrayLoadService;
import com.example.arrays.service.ArrayLoadServiceImpl;
import com.example.arrays.service.ArraySortService;
import com.example.arrays.service.ArrayStatisticsService;
import com.example.arrays.service.ArrayStatisticsServiceImpl;
import com.example.arrays.service.BubbleSortService;
import com.example.arrays.service.InsertionSortService;
import com.example.arrays.validator.ArrayLineValidator;
import com.example.arrays.validator.ArrayLineValidatorImpl;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Loads arrays from a file, then logs their statistics and their sorted copies.
 */
public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final String DATA_FILE_PATH = "data/arrays.txt";
    private static final String NO_VALUE = "no value";

    private final CustomArrayFactory factory = new CustomArrayFactoryImpl();
    private final ArrayStatisticsService statisticsService = new ArrayStatisticsServiceImpl();
    private final ArraySortService bubbleSortService = new BubbleSortService();
    private final ArraySortService insertionSortService = new InsertionSortService();

    public static void main(String[] args) {
        Main application = new Main();
        application.run();
    }

    private void run() {
        ArrayFileReader reader = new ArrayFileReaderImpl();
        ArrayLineValidator validator = new ArrayLineValidatorImpl();
        ArrayLineParser parser = new ArrayLineParserImpl();
        ArrayLoadService loadService = new ArrayLoadServiceImpl(reader, validator, parser, factory);
        try {
            List<CustomArray> arrays = loadService.loadArrays(DATA_FILE_PATH);
            for (CustomArray array : arrays) {
                report(array);
            }
        } catch (CustomArrayException e) {
            logger.error("Cannot process arrays from '{}'", DATA_FILE_PATH, e);
        }
    }

    private void report(CustomArray array) throws CustomArrayException {
        Optional<Integer> min = statisticsService.findMin(array);
        Optional<Integer> max = statisticsService.findMax(array);
        Optional<Long> sum = statisticsService.calculateSum(array);
        Optional<Double> average = statisticsService.calculateAverage(array);
        logger.info("{}: min={}, max={}, sum={}, average={}",
                array, describe(min), describe(max), describe(sum), describe(average));

        int[] elements = array.getElements();
        CustomArray bubbleSorted = factory.create(elements);
        bubbleSortService.sort(bubbleSorted);
        logger.info("Bubble sort:    {}", bubbleSorted);

        CustomArray insertionSorted = factory.create(elements);
        insertionSortService.sort(insertionSorted);
        logger.info("Insertion sort: {}", insertionSorted);
    }

    private String describe(Optional<?> value) {
        if (value.isPresent()) {
            Object content = value.get();
            return content.toString();
        } else {
            return NO_VALUE;
        }
    }
}
