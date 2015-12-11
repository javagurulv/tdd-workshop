package lv.javaguru.tdd.workshop.section2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class EnterpriseStringCalculator {

    private static final String DELIMITERS_REGEXP = "[,\n]";
    private static final int ONE_THOUSAND = 1000;
    private static final int ZERO = 0;

    private StringUtils stringUtils;


    public EnterpriseStringCalculator(StringUtils stringUtils) {
        this.stringUtils = stringUtils;
    }

    enum Sign {
        POSITIVE,
        NEGATIVE;

        static Sign getSign(int number) {
            return number < 0 ? NEGATIVE : POSITIVE;
        }

    }

    public int add(String lineWithNumbers) {
        Map<Sign, List<Integer>> signedNumbers = splitNumbers(lineWithNumbers).stream()
                .filter(this::isNumberLessThan1000)
                .collect(groupingBy(Sign::getSign));

        if (signedNumbers.containsKey(Sign.NEGATIVE)) {
            List<Integer> negativeNumbers = signedNumbers.get(Sign.NEGATIVE);
            String errorMessage = "negatives not allowed: "
                    + negativeNumbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(errorMessage);
        }

        if (signedNumbers.containsKey(Sign.POSITIVE)) {
            return signedNumbers.get(Sign.POSITIVE).stream()
                    .map(Function.identity())
                    .reduce(ZERO, (a, b) -> a + b);
        } else {
            return ZERO;
        }
    }

    private List<Integer> splitNumbers(String numbers) {
        String[] separatedNumbers = numbers.split(DELIMITERS_REGEXP);
        return Arrays.asList(separatedNumbers).stream()
                .filter(number -> !stringUtils.isEmptyString(number))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private boolean isNumberLessThan1000(int number) {
        return number <= ONE_THOUSAND;
    }

}
