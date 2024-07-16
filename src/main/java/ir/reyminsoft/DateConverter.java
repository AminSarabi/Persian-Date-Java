package ir.reyminsoft;

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

    public static int[] convertGregorianToPersian(int[] fields) {
        if (fields.length != 3)
            throw new RuntimeException("invalid fields length " + fields.length + " use [year,month,day]");
        int year = fields[0];
        int month = fields[1];
        int day = fields[2];
        return convertGregorianToPersian(year, month, day);
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

    public static int[] addDaysToPersianDate(int[] persianDate, int days) {
        assertValidPersianDateFields(persianDate);
        int year = persianDate[0];
        int month = persianDate[1];
        int day = persianDate[2] + days;
        while (day > getDaysOfMonthPersian(year, month)) {
            day -= getDaysOfMonthPersian(year, month);
            month++;
            if (month > 12) {
                year++;
                month = 1;
            }

        }
        while (day < 1) {
            month--;
            if (month == 0) {
                month = 12;
                year--;
            }
            day += getDaysOfMonthPersian(year, month); //todo forward backward
        }
        while (month < 1) {
            year--;
            month += 12;
            if (month == 0) {
                month = 12;
            }
        }
        while (month > 12) {
            year++;
            month -= 12;
        }
        LeapYearsCalculator.throwIfPersianYearIsNotSupported(year);
        return new int[]{year, month, day};
    }

    public static int[] addMonthsToPersianDate(int[] persianDate, int months) {
        assertValidPersianDateFields(persianDate);
        int year = persianDate[0];
        int month = persianDate[1] + months;
        int day = persianDate[2];
        while (month < 1) {
            year--;
            month += 12;
            if (month == 0) {
                month = 12;
            }
        }
        while (month > 12) {
            year++;
            month -= 12;
        }
        return new int[]{year, month, day};
    }

    public static int[] addYearsToPersianDate(int[] persianDate, int years) {
        assertValidPersianDateFields(persianDate);
        int year = persianDate[0] + years;
        int month = persianDate[1];
        int day = persianDate[2];
        return new int[]{year, month, day};
    }

    public static long[] convertMillisToPersianDateTime(long epochMillis) {
        long daysToAdd = epochMillis / (24 * 3600 * 1000);
        int[] conversion = addDaysToPersianDate(new int[]{1348, 10, 11}, (int) daysToAdd);
        long timeLeft = epochMillis % (24 * 3600 * 1000);
        long hours = timeLeft / (3600 * 1000);
        timeLeft %= (3600 * 1000);
        long minutes = timeLeft / (60 * 1000);
        timeLeft %= (60 * 1000);
        long seconds = timeLeft / 1000;
        timeLeft %= 1000;
        long millis = timeLeft;
        return new long[]{conversion[0], conversion[1], conversion[2], hours, minutes, seconds, millis};
    }

    public static long convertPersianToMillis(long[] persianDateTime) {
        int days = countPersianDaysSinceTheStartOfTheCalendar(
                (int) persianDateTime[0],
                (int) persianDateTime[1],
                (int) persianDateTime[2]);

        int days2 = countPersianDaysSinceTheStartOfTheCalendar(1348, 10, 11); //this is 1970/1/1 in persian

        long daysDifference = days - days2; //the last day is not finished yet so no need to add one.
        return (daysDifference) * 24L * 3600L * 1000L +
                persianDateTime[3] * 3600L * 1000L +
                persianDateTime[4] * 60L * 1000L +
                persianDateTime[5] * 1000L +
                persianDateTime[6];

    }


}
