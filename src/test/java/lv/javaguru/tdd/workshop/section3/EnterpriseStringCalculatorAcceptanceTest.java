package lv.javaguru.tdd.workshop.section3;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:acceptance/section3/enterpriseStringCalculator.feature",
        format = "html:build/reports/cucumber-html-report",
        glue = "lv.javaguru.tdd.workshop.section3")
public class EnterpriseStringCalculatorAcceptanceTest {


}
