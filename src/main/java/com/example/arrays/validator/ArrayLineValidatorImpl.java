package com.example.arrays.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayLineValidatorImpl implements ArrayLineValidator {

    private static final String DELIMITER_REGEX = "[,;\\-\\u2013\\u2014\\s]";
    private static final String NUMBER_REGEX = "\\d{1,9}";
    private static final String LINE_REGEX = DELIMITER_REGEX + "*" + NUMBER_REGEX
            + "(?:" + DELIMITER_REGEX + "+" + NUMBER_REGEX + ")*" + DELIMITER_REGEX + "*";
    private static final Pattern LINE_PATTERN = Pattern.compile(LINE_REGEX);

    @Override
    public boolean isValid(String line) {
        if (line == null) {
            return false;
        }
        Matcher matcher = LINE_PATTERN.matcher(line);
        return matcher.matches();
    }
}
