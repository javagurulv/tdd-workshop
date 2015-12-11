package lv.javaguru.tdd.workshop.section2;

enum Sign {

    POSITIVE,
    NEGATIVE;

    static Sign getSign(int number) {
        return number < 0 ? NEGATIVE : POSITIVE;
    }

}
