package calculator;

public class Calculator {
    public int multiply(int a, int b) {
        return a * b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new DoNotDivideByZero();
        }
        return ((double) a) / b;
    }

    public int modulo(int a, int b) {
        return a % b;
    }
}
