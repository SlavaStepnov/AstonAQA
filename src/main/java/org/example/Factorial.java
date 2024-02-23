package org.example;

public class Factorial {
    public static int calculateFactorial (int n) {
        if (n < 0)
            throw new IllegalArgumentException("Нельзя взять факториал от отрицательного числа");
        if (n > 0) {
            int fact = 1;
            for (int i = n; i > 0; i--) {
                fact *= i;
            }
            return fact;
        } else return 1;
    }
}
