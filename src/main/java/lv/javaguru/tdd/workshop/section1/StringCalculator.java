package lv.javaguru.tdd.workshop.section1;

public class StringCalculator {

    private static final String EMPTY_STRING = "";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_DELIMITER = "\n";

    public int add(String numbers) {

        if (isEmptyString(numbers)) {
            return 0;
        } else {
            String[] separatedNumbers = numbers.split(COMMA_DELIMITER + "|" + NEW_LINE_DELIMITER);
            int sum = 0;
            for (String number : separatedNumbers) {
                sum += Integer.parseInt(number);
            }
            return sum;
        }

    }

    private boolean isEmptyString(String str) {
        return EMPTY_STRING.equals(str);
    }

}
