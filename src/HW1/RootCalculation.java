package HW1;

import java.util.Scanner;

public class RootCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double discr = discriminant(a, b, c);
        System.out.println(discr);

        if (isPositive(discr)) {
            System.out.println("First root: " + ((-b) + Math.sqrt(discr)) / (2 * a));
            System.out.println("Second root: " + ((-b) - Math.sqrt(discr)) / (2 * a));

        } else if (isZero(discr)) {
            System.out.println("For zero discriminant only one root: " + (-b) / (2 * a));
        } else {
            System.out.println("No real roots for this combination of numbers");
        }
    }

    public static boolean isPositive(double number) {
        return number > 0;
    }

    public static boolean isZero(double number) {
        return number == 0;
    }

    public static double discriminant(int a, int b, int c) {
        return b * b - 4 * a * c;
    }
}
