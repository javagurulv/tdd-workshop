package lv.javaguru.tdd.workshop.section2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class SplitNumbersLine {

    private static final String DELIMITERS_REGEXP = "[,\n]";

    private StringUtils stringUtils;

    public SplitNumbersLine(StringUtils stringUtils) {
        this.stringUtils = stringUtils;
    }

    public List<Integer> splitNumbers(String numbers) {
        String[] separatedNumbers = numbers.split(DELIMITERS_REGEXP);
        return Arrays.asList(separatedNumbers).stream()
                .filter(number -> !stringUtils.isEmptyString(number))
                .map(Integer::parseInt)
                .collect(toList());
    }

}
