package com.example.arrays.reader;

import com.example.arrays.exception.CustomArrayException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFileReaderImpl implements ArrayFileReader {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readLines(String filePath) throws CustomArrayException {
        if (filePath == null || filePath.isBlank()) {
            throw new CustomArrayException("File path must not be empty");
        }
        Path path = Paths.get(filePath);
        try {
            List<String> lines = Files.readAllLines(path);
            int linesCount = lines.size();
            logger.info("Read {} lines from '{}'", linesCount, filePath);
            return lines;
        } catch (IOException e) {
            throw new CustomArrayException("Cannot read file: " + filePath, e);
        }
    }
}
