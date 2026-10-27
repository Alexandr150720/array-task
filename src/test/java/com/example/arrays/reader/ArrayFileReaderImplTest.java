package com.example.arrays.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.arrays.exception.CustomArrayException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ArrayFileReaderImplTest {

    private static final String EXISTING_FILE = "data/test/arrays.txt";
    private static final String MISSING_FILE = "data/test/missing.txt";
    private static final String BLANK_PATH = "  ";
    private static final int LINES_COUNT = 8;
    private static final String FIRST_LINE = "1; 2; 3";

    private final ArrayFileReader reader = new ArrayFileReaderImpl();

    @Test
    void readLinesShouldReturnAllLinesIncludingEmptyOnes() throws CustomArrayException {
        // when
        List<String> actual = reader.readLines(EXISTING_FILE);
        // then
        assertEquals(LINES_COUNT, actual.size());
    }

    @Test
    void readLinesShouldKeepOrderOfLines() throws CustomArrayException {
        // when
        List<String> actual = reader.readLines(EXISTING_FILE);
        // then
        assertEquals(FIRST_LINE, actual.get(0));
    }

    @Test
    void readLinesShouldThrowExceptionWhenFileIsMissing() {
        // when
        Executable action = () -> reader.readLines(MISSING_FILE);
        // then
        assertThrows(CustomArrayException.class, action);
    }

    @Test
    void readLinesShouldThrowExceptionWhenPathIsBlank() {
        // when
        Executable action = () -> reader.readLines(BLANK_PATH);
        // then
        assertThrows(CustomArrayException.class, action);
    }
}
