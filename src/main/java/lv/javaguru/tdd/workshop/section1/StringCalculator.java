package lv.javaguru.tdd.workshop.section1;

public class StringCalculator {

    public int add(String numbers) {

        if ("".equals(numbers)) {
            return 0;
        }

        throw new IllegalArgumentException();
    }

}
