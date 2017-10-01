package HW1;

import java.util.Scanner;

public class ShowNextDate {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        System.out.println(getNextdate(day, month, year));
    }

    public static String getNextdate(int day, int month, int year) {
        if (!isCorrect(month,1,12)) {
            return "Incorrect Input";
        }
        int daysInMonth = getDaysInMonth(month, year);
        if (!isCorrect(day, 1, daysInMonth)) {
            return "Incorrect Input";
        }
        if (isLastDayOfMonth(day, daysInMonth) && isLastMonthOfYear(month)) {
            return "1.1." +  (year + 1);
        } else if (isLastDayOfMonth(day, daysInMonth)){
            return "1." + (month + 1) + "." + year;
        } else {
            return (day + 1) + "." + month + "." + year;
        }
    }

    public static boolean isLastDayOfMonth(int day, int daysInMonth) {
        return day == daysInMonth;
    }

    public static boolean isLastMonthOfYear(int month) {
        return month == 12;
    }

    public static boolean isCorrect(int partOfDate, int from, int to) {
        return partOfDate >= from && partOfDate <= to;
    }

    public static int getDaysInMonth(int month,int year) {
        int daysInMonth;
        switch (month) {
            case  6:
            case  9:
            case 11:
            case  4:
                daysInMonth = 30;
                break;
            case  2:
                daysInMonth = isLeapYear(year) ? 29 : 28;
                break;
            default:
                daysInMonth = 31;
        }
        return daysInMonth;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
