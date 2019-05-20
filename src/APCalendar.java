import java.util.Calendar;

public class APCalendar {
    public static void main(String[] args) {
        System.out.println(firstDayOfYear(2019)); // -> 2
        System.out.println(dayOfYear(3, 1, 2017)); // -> 60
        System.out.println(dayOfYear(3, 1, 2016)); // -> 61
        System.out.println(dayOfWeek(1, 10, 2019)); // -> 4
    }

    /**
     * Returns true if year is a leap year and false otherwise.
     */
    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2) {
        int sum = 0;
        for (int y = year1; y <= year2; y++) {
            if (isLeapYear(y))
                sum++;
        }
        return sum;
    }

    /**
     * Returns the value representing the day of the week for the first day of year,
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    private static int firstDayOfYear(int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.DAY_OF_YEAR, 0);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    private static int dayOfYear(int month, int day, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return c.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Returns the value representing the day of the week for the given date
     * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
     * and 6 denotes Saturday.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfWeek(int month, int day, int year) {
        return (firstDayOfYear(year) + dayOfYear(month, day, year) - 1) % 7;
    }

    // There may be instance variables, constructors, and other methods not shown.
}
