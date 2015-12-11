package lv.javaguru.tdd.workshop.section3;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lv.javaguru.tdd.workshop.section2.EnterpriseStringCalculator;
import lv.javaguru.tdd.workshop.section2.EnterpriseStringCalculatorFactory;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class EnterpriseStringCalculatorSteps {

    private EnterpriseStringCalculator calculator;

    private String numbersLine;


    @Given("^initialize calculator$")
    public void initCalculator() {
        calculator = EnterpriseStringCalculatorFactory.create();
    }

    @When("^line number (.*) is$")
    public void numberLineIs(String numbersLine) {
        this.numbersLine = numbersLine;
    }

    @Then("^sum should be equal (\\d+)$")
    public void sum_should_be_equal(int sum) {
        int realSum = calculator.add(numbersLine);
        assertThat(realSum, equalTo(sum));
    }

    @Then("^should throw exception with message '(.*)'$")
    public void should_throw_exception_with_message(String errorMessage) {
        try {
            calculator.add(numbersLine);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo(errorMessage));
        }
    }

}
