import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input fibonacci limit: ");
        int limit = scanner.nextInt();
        int previousFib = 0;
        int currentFib = 1;
        useRecursion(limit, currentFib, previousFib);
        useCycle(limit, currentFib, previousFib);
    }

    public static void useCycle(int limit, int currentFib, int previousFib) {
        if (limit == 1) {
            System.out.println("Using cycle    : " + previousFib);
        } else if (limit >= 2) {
            System.out.print("\nUsing cycle    : " + previousFib + ", " + currentFib);
            int nextFib = currentFib + previousFib;

            while (nextFib < limit) {
                System.out.print(", " + nextFib);
                previousFib = currentFib;
                currentFib = nextFib;
                nextFib = previousFib + currentFib;
            }
        } else {
            System.out.println("Using cycle    : " + "Not found");
        }
    }

    public static void useRecursion(int limit, int currentFib, int previousFib) {
        if (limit == 1) {
            System.out.println("Using recursion: " + previousFib);
        } else if (limit >= 2) {
            System.out.print("Using recursion: " + previousFib + ", " + currentFib);
            displayFibonacciNumbers(limit, currentFib, previousFib);
        } else {
            System.out.println("Using recursion: " + "Not found");
        }
    }

    public static void displayFibonacciNumbers(int limit, int currentFib, int previousFib) {
        int nextFib = currentFib + previousFib;
        if (nextFib >= limit) {
            return;
        }
        System.out.print(", " + nextFib);
        displayFibonacciNumbers(limit, nextFib, currentFib);
    }

}
