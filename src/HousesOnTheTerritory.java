import java.util.Scanner;

public class HousesOnTheTerritory {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Input dimensions of the territory");
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        System.out.println("Input dimensions of the first House");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Input dimensions of the second House");
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println(areHousesCanBePlaced(e, f, a, b, c, d) ? "Houses suit for territory" : "Houses don't suit for territory");
    }

    public static boolean areHousesCanBePlaced(int e, int f, int a, int b, int c, int d) {
        if (((b <= f && a <= e) && ((c <= f - b && d <= e) || (d <= f - b && c <= e) || (c <= f && d <= e - a) || (d <= f && c <= e - a))) ||
            ((a <= f && b <= e) && ((c <= f - a && d <= e) || (d <= f - a && c <= e) || (c <= f && d <= e - b) || (d <= f && c <= e - b)))) {
            return true;
        }
        return false;
      }
}
