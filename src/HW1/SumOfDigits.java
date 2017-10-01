package HW1;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        long number = Math.abs(scanner.nextLong());
        int amount = 0;

        do {
            amount += number % 10;
        } while ((number /= 10) != 0);
        System.out.println(amount);
    }
}
