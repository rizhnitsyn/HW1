package HW2.Strings;

import java.util.Scanner;

public class ConvertNumbers {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String romeString = scanner.nextLine();
        char[] chars = romeString.toCharArray();
        int arabicNumber;
        int nextArabicNumber;
        int wholeArabicNumber = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            arabicNumber = getArabicNumber(chars[i]);
            nextArabicNumber = getArabicNumber(chars[i + 1]);
            if (arabicNumber == -1 || nextArabicNumber == -1) {
                System.out.println("Incorrect input");
                return;
            } else if (arabicNumber < nextArabicNumber && (arabicNumber * 5 == nextArabicNumber || arabicNumber * 10 == nextArabicNumber)) {
                arabicNumber = -arabicNumber;
            } else if (arabicNumber < nextArabicNumber && (arabicNumber * 5 != nextArabicNumber || arabicNumber * 10 != nextArabicNumber)) {
                System.out.println("Incorrect input");
                return;
            }
            wholeArabicNumber += arabicNumber;
        }
        wholeArabicNumber += getArabicNumber(chars[chars.length - 1]);
        System.out.println(wholeArabicNumber);
    }

    public static int getArabicNumber(char romeChar ) {
        int arabicNumber;
        switch (romeChar) {
            case 'M':
                arabicNumber = 1000;
                break;
            case 'D':
                arabicNumber = 500;
                break;
            case 'C':
                arabicNumber = 100;
                break;
            case 'L':
                arabicNumber = 50;
                break;
            case 'X':
                arabicNumber = 10;
                break;
            case 'V':
                arabicNumber = 5;
                break;
            case 'I':
                arabicNumber = 1;
                break;
            default:
                arabicNumber = -1;
                break;
        }
        return arabicNumber;
    }
}
