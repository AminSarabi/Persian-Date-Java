package ir.reyminsoft;

import java.util.Calendar;

import static ir.reyminsoft.LeapYearsCalculator.*;

public class DateConverter {


    public static int[] convertGregorianToPersian(final int year, final int month, final int day) {
        assertValidGregorianDateFields(year, month, day);
        Calendar calendar = getGregorianCalendarOf(year, month, day);
        int persianYear = year - 622;
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        if (year == 1582 && month >= 10 && (month != 10 || day >= 15)) {
            //a historical incident in which the gregorian calendar replaced the julian calendar
            dayOfYear += 10;
            //as the julian calendar was off by 10 from seasons, time moved 10 days forward!
        }
        int persianMonth, persianDayOfMonth = 0;
        if (isNotGregorianLeapYear(year)
                && getGregorianCalendarOf(year, 2, 1).getActualMaximum(Calendar.DAY_OF_MONTH) == 29
                && dayOfYear >= 60) {
            //this is a bug in java's implementation of calendar where a non-leap year has a 29-day-long february
            dayOfYear--;
            //the bug increases the dayOfYears higher than 60 by 1. the code checks for bug's existence before applying the patch.

        }
        int prevGregLeapCount = getPreviousGregorianLeapYearsCount(year) - getPreviousGregorianLeapYearsCount(623);
        int prevPersianLeapCount = getPreviousPersianLeapYearCount(persianYear);
        int leapDiff = prevGregLeapCount - prevPersianLeapCount;
        int coincide = 10 + leapDiff;
        int remaining = 90 - coincide;
        if (isPersianLeapYear(persianYear)) remaining++;
        boolean offsetMode = remaining >= dayOfYear; /* the start of a Gregorian year coincides
        with 10th/11th/12th of the 10th persian month (Dey دی). */
        if (offsetMode) {
            persianMonth = 10;
        } else {
            persianYear++;
            dayOfYear -= remaining;
            persianMonth = 1;
        }
        for (; persianMonth != 13; persianMonth++) {
            int daysOfMonth = getDaysOfMonthPersian(persianYear, persianMonth);
            int offset = offsetMode ? (persianMonth == 10 ? coincide - 1 : 0) : 0;
            int remainingDaysOfMonth = daysOfMonth - offset;
            if (dayOfYear > remainingDaysOfMonth) {
                dayOfYear -= remainingDaysOfMonth;
            } else {
                persianDayOfMonth = dayOfYear + offset;
                break;
            }
        }
        return new int[]{persianYear, persianMonth, persianDayOfMonth};
    }

    public static int[] convertGregorianToPersian(int[] fields) {
        if (fields.length != 3)
            throw new RuntimeException("invalid fields length " + fields.length + " use [year,month,day]");
        int year = fields[0];
        int month = fields[1];
        int day = fields[2];
        assertValidGregorianDateFields(year, month, day);
        return convertGregorianToPersian(year, month, day);
    }


    public static Calendar getGregorianCalendarOf(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1 /* january is 0 */);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }

    public static int getDaysOfMonthGregorian(int year /* might be a leap year */, int month) {
        Calendar calendar = getGregorianCalendarOf(year, month, 1);
        if (month == 2) {
            if (isNotGregorianLeapYear(year)
                    && getGregorianCalendarOf(year, 2, 1).getActualMaximum(Calendar.DAY_OF_MONTH) == 29) {
                return 28;
                //this is a bug in java's implementation of calendar where a non-leap year has a 29-day-long february
            }
        }
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int getDaysOfMonthPersian(int year /* might be a leap year */, int month) {
        if (month <= 6) return 31;
        if (month <= 11) return 30;
        if (month == 12) return isPersianLeapYear(year) ? 30 : 29;
        throw new RuntimeException("index out of bounds " + month + " for a persian month.");
    }

    public static int countOfDays(final int year, final int month, final int day) {
        assertValidPersianDateFields(year, month, day);
        int sum = 0;
        for (int x = 1; x != year; x++) {
            sum += isPersianLeapYear(x) ? 366 : 365;
        }
        for (int m = 1; m != month; m++) {
            sum += getDaysOfMonthPersian(year, m);
        }
        sum += day;
        return sum;

    }

    private static void assertValidPersianDateFields(int... ints) {
        for (int x = 0; x != ints.length; x++) {
            switch (x) {
                case 0:
                    LeapYearsCalculator.throwIfPersianYearIsNotSupported(ints[x]);
                    break;
                case 1:
                    if (ints[x] > 12 || ints[x] <= 0) {
                        throw new RuntimeException("invalid month value: " + ints[x]);
                    }
                    break;
                case 2:
                    if (ints[x] > getDaysOfMonthPersian(ints[0], ints[1]) || ints[x] <= 0) {
                        throw new RuntimeException("invalid day value: " + ints[x] + " in " + ints[0] + "/" + ints[1] + "/" + ints[2]);
                    }
            }
        }
    }

    private static void assertValidGregorianDateFields(int... ints) {
        for (int x = 0; x != ints.length; x++) {
            switch (x) {
                case 0:
                    LeapYearsCalculator.throwIfGregorianYearIsNotSupported(ints[x]);
                    break;
                case 1:
                    if (ints[x] > 12 || ints[x] <= 0) {
                        throw new RuntimeException("invalid month value: " + ints[x]);
                    }
                    break;
                case 2:
                    if (ints[x] > getDaysOfMonthGregorian(ints[0], ints[1]) || ints[x] <= 0) {
                        throw new RuntimeException("invalid day value: " + ints[x] + " in " + ints[0] + "/" + ints[1] + "/" + ints[2]);
                    }
            }
        }
    }

    public static long[] convertMillisToPersian(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeInMillis(time);
        int[] dateConversion = convertGregorianToPersian(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        return new long[]{
                dateConversion[0],
                dateConversion[1],
                dateConversion[2],
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND),
                calendar.get(Calendar.MILLISECOND)
        };
    }
}
