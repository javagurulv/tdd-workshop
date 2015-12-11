package lv.javaguru.tdd.workshop.section1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    private StringCalculator calculator;


    @Before
    public void init() {
        calculator = new StringCalculator();
    }

    @Test
    public void whenNumbersStringIsEmptyThenResultMustBeZero() {
        int result = calculator.add("");
        assertThat(result, is(0));
    }

    @Test
    public void whenNumbersStringContainsOneNumberThenResultMustBeThatNumber() {
        int result = calculator.add("1");
        assertThat(result, is(1));
    }

}
