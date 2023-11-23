package fizzbuzz;

public class FizzBuzzGame {
    public static void main(String[] args) {
        new FizzBuzzGame().doFizzBuzz();
    }

    public void doFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(doSingleFizzBuzz(i));
            if (isNotLastNumber(i)) {
                System.out.print(", ");
            }
        }
    }

    boolean isNotLastNumber(int i) {
        return i < 100;
    }

    String doSingleFizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(number);
        }
    }
}
