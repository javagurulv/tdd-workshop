package lv.javaguru.tdd.workshop.section2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EnterpriseStringCalculator {

    private static final int ZERO = 0;

    private NumberUtils numberUtils;
    private SplitNumbersLine splitNumbersLine;


    public EnterpriseStringCalculator(NumberUtils numberUtils,
                                      SplitNumbersLine splitNumbersLine) {
        this.numberUtils = numberUtils;
        this.splitNumbersLine = splitNumbersLine;
    }

    public int add(String lineWithNumbers) {
        Map<Sign, List<Integer>> signedNumbers = splitNumbersLine.splitNumbers(lineWithNumbers).stream()
                .filter(numberUtils::isNumberLessThan1000)
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

}
