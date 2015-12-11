package lv.javaguru.tdd.workshop.section1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Rule
    public ExpectedException exception = ExpectedException.none();


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

    @Test
    public void whenNumbersStringContainsTwoNumbersSeparatedByCommaThenResultMustBeSumOfThisNumbers() {
        int result = calculator.add("1,2");
        assertThat(result, is(3));
    }

    @Test
    public void whenNumbersStringContainsThreeNumbersSeparatedByCommaThenResultMustBeSumOfThisNumbers() {
        int result = calculator.add("1,2,3");
        assertThat(result, is(6));
    }

    @Test
    public void whenNumbersSeparatedByNewLineSymbolThenResultMustBeSumOfThisNumbers() {
        int result = calculator.add("1\n2\n3");
        assertThat(result, is(6));
    }

    @Test
    public void whenNumbersSeparatedByNewLineAndCommaSymbolsThenResultMustBeSumOfThisNumbers() {
        int result = calculator.add("1\n2,3");
        assertThat(result, is(6));
    }

    @Test
    public void whenNumberIsNegativeThenThrowException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("negatives not allowed: -1");
        calculator.add("-1");
    }

    @Test
    public void whenMultipleNumbersIsNegativeThenThrowExceptionAndShowNegativeNumbersInTheMessage() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("negatives not allowed: -1, -2");
        calculator.add("-1,-2");
    }

    @Test
    public void whenNumberIsBiggerThen1000ThenJustIgnoreIt() {
        int result = calculator.add("1001");
        assertThat(result, is(0));
    }

}
