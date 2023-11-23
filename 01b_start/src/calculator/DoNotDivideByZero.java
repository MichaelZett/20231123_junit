package calculator;

public class DoNotDivideByZero extends RuntimeException {
    DoNotDivideByZero() {
        super("Do not divide by zero");
    }
}
