package fizzbuzz;

public class FizzBuzzGame {
//    Schreibe ein Programm, das für die Zahlen von 1 bis 100 eine Ausgabe erstellt.
//    Bei jeder Zahl, die durch 3 teilbar ist, soll "fizz" ausgegeben werden und
//    bei jeder Zahl, die durch 5 teilbar ist, soll "buzz" ausgegeben werden.
//    Wenn die Zahl sowohl durch 3 als auch durch 5 teilbar ist,
//    soll "fizzbuzz" ausgegeben werden.
//    Andernfalls wird die Zahl selbst ausgegeben.
//    Das Ergebnis soll in einer Komma-separierten Zeile stehen. Nach dem letzten Element
//    soll kein Komma stehen.

    public static void main(String[] args) {
        new FizzBuzzGame().doFizzBuzz();
    }

    private void doFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(doOneNumber(i));
            if (i < 100) {
                System.out.print(", ");
            }
        }
    }

    String doOneNumber(int number) {
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
