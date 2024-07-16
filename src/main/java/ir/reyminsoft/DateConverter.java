package ir.reyminsoft;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static ir.reyminsoft.LeapYearsCalculator.*;

public class DateConverter {


    public static int[] convertGregorianToPersian(final int year, final int month, final int day) {
        assertValidGregorianDateFields(year, month, day);
        int dayOfYear = day;
        for (int m = 1; m != month; m++) {
            dayOfYear += getDaysOfMonthGregorian(year, m);
        }
        int persianYear = year - 622;
        boolean offsetMode;
        int coincide;
        int remaining = 0;
        if (persianYear != 0) {
            int prevGregLeapCount = getPreviousGregorianLeapYearsCount(year) - getPreviousGregorianLeapYearsCount(623);
            int prevPersianLeapCount = getPreviousPersianLeapYearCount(persianYear);
            int leapDiff = prevGregLeapCount - prevPersianLeapCount;
            coincide = 10 + leapDiff;
            remaining = 90 - coincide;
            if (isPersianLeapYear(persianYear)) remaining++;
            offsetMode = remaining >= dayOfYear; /* the start of a Gregorian year coincides
        with 10th/11th/12th of the 10th persian month (Dey دی). */
        } else {
            offsetMode = false;
            coincide = 0;
            dayOfYear -= 80;
        }
        int persianMonth, persianDayOfMonth = 0;
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

    public static int[] convertGregorianToPersian(Calendar calendar) {
        return convertGregorianToPersian(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, /* january is 0 */
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static int[] convertGregorianToPersian(int[] fields) {
        if (fields.length != 3)
            throw new RuntimeException("invalid fields length " + fields.length + " use [year,month,day]");
        int year = fields[0];
        int month = fields[1];
        int day = fields[2];
        return convertGregorianToPersian(year, month, day);
    }

    public static final String timezone = "Atlantic/Reykjavik";

    public static GregorianCalendar getGregorianCalendarOf(int year, int month, int day) {
        GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone(timezone));
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1 /* january is 0 */);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }

    public static GregorianCalendar getGregorianCalendarOf(long millis) {
        GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone(timezone));
        calendar.setTimeInMillis(millis);
        return calendar;
    }


    public static int getDaysOfMonthGregorian(int year /* might be a leap year */, int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isGregorianLeapYear(year) ? 29 : 28;
            default -> throw new RuntimeException("wtf " + month);
        };
    }

    public static int getDaysOfMonthPersian(int year /* might be a leap year */, int month) {
        if (month <= 6) return 31;
        if (month <= 11) return 30;
        if (month == 12) return isPersianLeapYear(year) ? 30 : 29;
        throw new RuntimeException("index out of bounds " + month + " for a persian month.");
    }

    public static int countPersianDaysSinceTheStartOfTheCalendar(final int year, final int month, final int day) {
        assertValidPersianDateFields(year, month, day);
        int sum = 0;
        sum += (year - 1) * 365;
        sum += getPreviousPersianLeapYearCount(year);
        for (int m = 1; m != month; m++) {
            sum += getDaysOfMonthPersian(year, m);
        }
        sum += day;
        return sum;

    }

    public static int countPersianDaysSinceTheStartOfTheCalendar(final int[] fields) {
        return countPersianDaysSinceTheStartOfTheCalendar(fields[0], fields[1], fields[2]);

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
        Calendar calendar = getGregorianCalendarOf(time);
        int[] dateConversion = convertGregorianToPersian(calendar);
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

    public static long convertPersianToMillis(long[] persianDateTime) {
        int days = countPersianDaysSinceTheStartOfTheCalendar(
                (int) persianDateTime[0],
                (int) persianDateTime[1],
                (int) persianDateTime[2]);

        int days2 = countPersianDaysSinceTheStartOfTheCalendar(1348, 10, 11); //this is 1970/1/1 in persian

        long daysDifference = subtractDaysCountConsidering1582(days, days2);
        return (daysDifference) * 24L * 3600L * 1000L + //the last day is not finished yet
                persianDateTime[3] * 3600L * 1000L +
                persianDateTime[4] * 60L * 1000L +
                persianDateTime[5] * 1000L +
                persianDateTime[6];

    }

    public static long subtractDaysCountConsidering1582(int days, int days2) {
        //in 1582 time moved 10 days forward in the calendar, but this does not affect timestamps.
        long daysDifference = days - days2;
        if (days <= 350840) {
            daysDifference += 10;
        }
        //these are all julian leap years that the stupid so called "GregorianCalendar" of java considers gregorian leap years.
        // this code tries to cancel those out.
        if (days <= 320662) daysDifference -= 1;
        if (days <= 284138) daysDifference -= 1;
        if (days <= 247614) daysDifference -= 1;
        if (days <= 174565) daysDifference -= 1;
        if (days <= 138041) daysDifference -= 1;
        if (days <= 101517) daysDifference -= 1;
        if (days <= 28468) daysDifference -= 1;
        return daysDifference;
    }

}
