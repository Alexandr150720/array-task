package com.example.arrays.parser;

import com.example.arrays.exception.CustomArrayException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayLineParserImpl implements ArrayLineParser {

    private static final String NUMBER_REGEX = "\\d+";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    @Override
    public int[] parse(String line) throws CustomArrayException {
        if (line == null) {
            throw new CustomArrayException("Line must not be null");
        }
        List<Integer> numbers = new ArrayList<>();
        Matcher matcher = NUMBER_PATTERN.matcher(line);
        while (matcher.find()) {
            String token = matcher.group();
            int number = parseNumber(token);
            numbers.add(number);
        }
        int[] result = new int[numbers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    private int parseNumber(String token) throws CustomArrayException {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new CustomArrayException("Number does not fit into int: " + token, e);
        }
    }
}
