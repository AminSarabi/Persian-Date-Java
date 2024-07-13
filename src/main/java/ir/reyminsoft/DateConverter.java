package ir.reyminsoft;

import java.util.Calendar;

public class DateConverter {
    public static Calendar getGregorianCalendarOf(int year, int month, int day) {
        Calendar calendar = new Calendar.Builder().build();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1 /* january is 0 */);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }

    public static int getDaysOfMonthGregorian(int year /* might be a leap year */, int month) {
        Calendar calendar = getGregorianCalendarOf(year, month, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int getDaysOfMonthPersian(int year /* might be a leap year */, int month) {
        if (month <= 6) return 31;
        if (month <= 11) return 30;
        if (month == 12) return isPersianLeapYear(year) ? 30 : 29;
        throw new RuntimeException("index out of bounds " + month + " for a persian month.");
    }

    public static boolean isPersianLeapYear(int year) {
        //todo: implement.
        return false;
    }

    public static int[] convertDate(final int year, final int month, final int day) {
        Calendar calendar = getGregorianCalendarOf(year, month, day);
        int persianYear = calendar.get(Calendar.YEAR) - 621;
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int persianMonth, persianDayOfMonth = 0;
        boolean offsetMode = dayOfYear <= 79; /* the start of a Gregorian year coincides
        with 10th/11th of the 10th persian month (Dey دی). */
        if (offsetMode) {
            persianYear--;
            persianMonth = 10;
        } else {
            dayOfYear -= 79;
            persianMonth = 1;
        }
        boolean isGregorianLeapYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR) == 366;
        for (; persianMonth != 13; persianMonth++) {
            int daysOfMonth = getDaysOfMonthPersian(persianYear, persianMonth);
            int offset = offsetMode ? (persianMonth == 10 ? (isGregorianLeapYear ? 11 : 10) : 0) : 0;
            int remainingDaysOfMonth = (daysOfMonth - offset);
            if (dayOfYear > remainingDaysOfMonth) {
                dayOfYear -= remainingDaysOfMonth;
            } else {
                persianDayOfMonth = dayOfYear + offset;
                break;
            }
        }
        return new int[]{persianYear, persianMonth, persianDayOfMonth};
    }

    public static int[] convertDate(int[] ints) {
        if (ints.length != 3) throw new RuntimeException("invalid int[] length " + ints.length);
        int year = ints[0];
        int month = ints[1];
        int day = ints[2];
        return convertDate(year, month, day);
    }

}
