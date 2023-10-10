package com.oop.hw3.ex2;

public class DateUtils {
    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"};

    public static void main(String[] args) {
        System.out.println(isLeapYear(1900)); // false
        System.out.println(isLeapYear(2000)); // true
        System.out.println(isLeapYear(2011)); // false
        System.out.println(isLeapYear(2012)); // true
        System.out.println();

        System.out.println(isValidDate(2012, 2, 29)); // true
        System.out.println(isValidDate(2011, 2, 29)); // false
        System.out.println(isValidDate(2099, 12, 32)); // false
        System.out.println(isValidDate(2054, 8, 30)); // true
        System.out.println();

        System.out.println(getDayOfWeek(1975, 4, 30)); // 3: Wed
        System.out.println(getDayOfWeek(2312, 6, 25)); // 2: Tue
        System.out.println(getDayOfWeek(202, 2, 19)); // 5: Fri
        System.out.println(getDayOfWeek(2112, 8, 7)); // 0: Sun
        System.out.println();

        System.out.println(toString(1975, 4, 30)); // Wednesday 30 Apr 1975
    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Year is out of range 1 to 9999!");
        }

        // Check if the year is divisible by 4 and not divisible by 100, or divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (year < 1 || year > 9999 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        // Adjust February for leap years
        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        return day <= daysInMonth[month];
    }

    public static int getDayOfWeek(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            return -1;
        }

        // The year is assumed to begin in March.
        // For example, January 1995 is to be treated as month 13 of 1994.
        if (month < 3) {
            month += 12;
            year -= 1;
        }

        // get the first 2 number of year
        int century = year / 100;
        // get the last 2 number of year
        year = year % 100;
        // Using Zeller's congruent algorithms - phép đồng dư Zeller
        return (century / 4 - 2 * century + year + year / 4 + 13 * (month + 1) / 5 + day - 1) % 7;
    }

    public static String toString(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            int dayOfWeek = getDayOfWeek(year, month, day);
            return DAYS_OF_WEEK[dayOfWeek] + " " + day + " " + MONTHS[month - 1] + " " + year;
        } else {
            return "Invalid date!";
        }
    }
}
