package lv.javaguru.tdd.workshop.section1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;


public class StringCalculator {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITERS_REGEXP = "[,\n]";

    enum Sign {
        POSITIVE,
        NEGATIVE;

        static Sign getSign(int number) {
            return number < 0 ? NEGATIVE : POSITIVE;
        }

    }

    public int add(String lineWithNumbers) {
        Map<Sign, List<Integer>> signedNumbers = splitNumbers(lineWithNumbers).stream()
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
                    .reduce(0, (a, b) -> a + b);
        } else {
            return 0;
        }
    }

    private List<Integer> splitNumbers(String numbers) {
        String[] separatedNumbers = numbers.split(DELIMITERS_REGEXP);
        return Arrays.asList(separatedNumbers).stream()
                .filter(number -> !isEmptyString(number))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private boolean isEmptyString(String str) {
        return EMPTY_STRING.equals(str);
    }

}
