package lv.javaguru.tdd.workshop.section1;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    @Test
    public void whenNumbersStringIsEmptyThenResultMustBeZero() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertThat(result, is(0));
    }

}
