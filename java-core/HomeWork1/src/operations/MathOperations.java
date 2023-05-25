package operations;

public class MathOperations {
    private static final String DIVISION_BY_ZERO_ERROR = "На ноль делить нельзя.";

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException(DIVISION_BY_ZERO_ERROR);
        }
        return (double) a / b;
    }
}