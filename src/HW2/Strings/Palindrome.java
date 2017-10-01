package HW2.Strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String stringToBeAnalyzed = scanner.nextLine();
        System.out.println(stringToBeAnalyzed + " - " + (isPalindrome(stringToBeAnalyzed)? "is palindrome" : "is not palindrome"));
    }

    public static boolean isPalindrome(String stringToBeAnalyzed) {
        int halfLength = stringToBeAnalyzed.length() / 2;
        for (int i = 0; i < halfLength; i++) {
            if (stringToBeAnalyzed.charAt(i) != stringToBeAnalyzed.charAt(stringToBeAnalyzed.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
