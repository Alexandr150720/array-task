package com.example.arrays.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.arrays.entity.CustomArray;
import com.example.arrays.exception.CustomArrayException;
import com.example.arrays.factory.CustomArrayFactoryImpl;
import com.example.arrays.parser.ArrayLineParserImpl;
import com.example.arrays.reader.ArrayFileReaderImpl;
import com.example.arrays.validator.ArrayLineValidatorImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ArrayLoadServiceImplTest {

    private static final String FILE_PATH = "data/test/arrays.txt";
    private static final String MISSING_FILE_PATH = "data/test/missing.txt";
    private static final int VALID_LINES_COUNT = 5;
    private static final int LAST_INDEX = 4;

    private final ArrayLoadService service = new ArrayLoadServiceImpl(
            new ArrayFileReaderImpl(),
            new ArrayLineValidatorImpl(),
            new ArrayLineParserImpl(),
            new CustomArrayFactoryImpl());
    private final int[] firstElements = {1, 2, 3};
    private final int[] lastElements = {10, 20, 30};

    @Test
    void loadArraysShouldSkipInvalidLines() throws CustomArrayException {
        // when
        List<CustomArray> actual = service.loadArrays(FILE_PATH);
        // then
        assertEquals(VALID_LINES_COUNT, actual.size());
    }

    @Test
    void loadArraysShouldCreateFirstArrayFromFirstValidLine() throws CustomArrayException {
        // when
        List<CustomArray> actual = service.loadArrays(FILE_PATH);
        // then
        CustomArray first = actual.get(0);
        assertArrayEquals(firstElements, first.getElements());
    }

    @Test
    void loadArraysShouldCreateLastArrayFromLastValidLine() throws CustomArrayException {
        // when
        List<CustomArray> actual = service.loadArrays(FILE_PATH);
        // then
        CustomArray last = actual.get(LAST_INDEX);
        assertArrayEquals(lastElements, last.getElements());
    }

    @Test
    void loadArraysShouldThrowExceptionWhenFileIsMissing() {
        // when
        Executable action = () -> service.loadArrays(MISSING_FILE_PATH);
        // then
        assertThrows(CustomArrayException.class, action);
    }
}
