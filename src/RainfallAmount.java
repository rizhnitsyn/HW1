import java.util.Scanner;

public class RainfallAmount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input amount of analyzed days:");
        int dayAmount = scanner.nextInt();
        System.out.println("Input rainfall amount for each day: ");
        int max = 0;
        int totalAmountOfRainfall = 0;

        for (int i = 0; i < dayAmount; i++) {
            int amountPerDay = scanner.nextInt();
            if (amountPerDay > max) {
                max = amountPerDay;
            }
            totalAmountOfRainfall +=amountPerDay;
        }

        System.out.println("Analyzed period: " + dayAmount);
        System.out.println("Total amount of rainfall: " + totalAmountOfRainfall);
        System.out.println("Average amount of rainfall per day: " + (totalAmountOfRainfall / dayAmount));
        System.out.println("Max amount of rainfall per day: " + max);


    }
}
