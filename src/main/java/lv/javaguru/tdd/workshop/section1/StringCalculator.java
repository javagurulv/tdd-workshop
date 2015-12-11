package lv.javaguru.tdd.workshop.section1;

public class StringCalculator {

    private static final String EMPTY_STRING = "";

    public int add(String numbers) {

        if (isEmptyString(numbers)) {
            return 0;
        } else {
            String[] separatedNumbers = numbers.split(",");
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
