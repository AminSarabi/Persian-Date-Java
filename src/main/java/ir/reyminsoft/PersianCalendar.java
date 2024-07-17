package ir.reyminsoft;

import static ir.reyminsoft.DateConverter.*;
import static ir.reyminsoft.Utils.*;

public class PersianCalendar {


    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int millis;

    public PersianCalendar(int[] fields) {
        this.setFields(fields);
    }

    public PersianCalendar(int year, int month, int day, int hour, int minute, int second, int millis) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.millis = millis;
    }

    public PersianCalendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public PersianCalendar(long epochMillis) {
        this.setFields(convertMillisToPersianDateTime(epochMillis));
    }

    private int[] getFields() {
        return new int[]{year, month, day, hour, minute, second, millis};
    }

    private void setFields(int[] values) {
        for (int x = 0; x != values.length; x++) {
            switch (x) {
                case 0:
                    year = values[x];
                    break;
                case 1:
                    month = values[x];
                    break;
                case 2:
                    day = values[x];
                    break;
                case 3:
                    hour = values[x];
                    break;
                case 4:
                    minute = values[x];
                    break;
                case 5:
                    second = values[x];
                    break;
                case 6:
                    millis = values[x];
                    break;
            }
        }
    }

    public long getTimeInMillis() {
        return convertPersianToMillis(getFields());
    }

    public PersianCalendar getStartOfTheMonth() {
        return new PersianCalendar(year, month, 1);
    }

    public PersianCalendar getStartOfTheNextMonth() {
        int[] values = addMonthsToPersianDate(getFields(), 1);
        values[2] = 1;
        return new PersianCalendar(values);
    }


    public PersianCalendar getStartOfTheWeek() {
        //todo
        return null;
    }

    public PersianCalendar getStartOfTheNextWeek() {
        //todo
        return null;
    }


    public PersianCalendar getTomorrow() {
        return new PersianCalendar(addDaysToPersianDate(getFields(), 1));
    }

    public PersianCalendar getYesterday() {
        return new PersianCalendar(addDaysToPersianDate(getFields(), -1));
    }

    public PersianCalendar getStartOfToday() {
        return new PersianCalendar(year, month, day);
    }

    public PersianCalendar getEndOfToday() {
        return new PersianCalendar(year, month, day, 23, 59, 59, 999);
    }

    public String toStringDateYYYYMMDD() {
        return fourDigitAtLeast(year) + "/" + twoDigitAtLeast(month) + "/" + twoDigitAtLeast(day);
    }

    public String toStringDateTimeYYYYMMDD_HHMM() {
        return toStringDateYYYYMMDD() + " " + toStringTimeHHMM();
    }

    public String toStringDateTimeYYYYMMDD_HHMMSS() {
        return toStringDateYYYYMMDD() + " " + toStringTimeHHMMSS();
    }

    public String toStringTimeHHMMSS() {
        return twoDigitAtLeast(hour) + ":" + twoDigitAtLeast(minute) + twoDigitAtLeast(second);
    }

    public String toStringTimeHHMM() {
        return twoDigitAtLeast(hour) + ":" + twoDigitAtLeast(minute);
    }

    @Override
    public String toString() {
        return toStringDateTimeYYYYMMDD_HHMMSS() + "." + threeDigitAtLeast(millis);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getMillis() {
        return millis;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PersianCalendar)) return false;
        return Utils.equals(this.getFields(), ((PersianCalendar) obj).getFields());
    }
}
