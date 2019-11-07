package com.java.course.lab01;

public class FractionSimplifier {
    public static String simplify(String fraction) {
        String[] splitedFraction = fraction.split("/");
        int divisible = Integer.parseInt(splitedFraction[0]);
        int divider = Integer.parseInt(splitedFraction[1]);

        if (divider == 0 || divisible == 0) {
            return "0";
        }

        int gcd = greatestCommonDivisor(divider, divisible);

        divisible /= gcd;
        divider /= gcd;

        if (divider == 1) {
            return String.valueOf(divisible);
        }
        return divisible + "/" + divider;
    }

    private static int greatestCommonDivisor(int number1, int number2) {
        int gcd = 1;
        for (int i = 1; i <= number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
