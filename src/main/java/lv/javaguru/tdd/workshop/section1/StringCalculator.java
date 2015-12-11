package lv.javaguru.tdd.workshop.section1;

public class StringCalculator {

    private static final String EMPTY_STRING = "";

    public int add(String numbers) {

        if (isEmptyString(numbers)) {
            return 0;
        } else {
            return Integer.parseInt(numbers);
        }

    }

    private boolean isEmptyString(String str) {
        return EMPTY_STRING.equals(str);
    }

}
