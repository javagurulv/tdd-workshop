package lv.javaguru.tdd.workshop.section2;

public class EnterpriseStringCalculatorFactory {

    public static EnterpriseStringCalculator create() {
        StringUtils stringUtils = new StringUtils();
        NumberUtils numberUtils = new NumberUtils();
        SplitNumbersLine splitNumbersLine = new SplitNumbersLine(stringUtils);
        return new EnterpriseStringCalculatorImpl(numberUtils, splitNumbersLine);
    }

}
