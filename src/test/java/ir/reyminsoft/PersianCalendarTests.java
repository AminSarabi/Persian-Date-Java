package ir.reyminsoft;

import static ir.reyminsoft.TestClassRunner.assertEquals;

public class PersianCalendarTests implements TestClass {

    public static void main(String[] args) {
        TestClassRunner.run(PersianCalendarTests.class);
    }

    public static void zero_is_zero() {
        assertEquals(new PersianCalendar(0).getTimeInMillis(), 0);
        assertEquals(new PersianCalendar(0).getYear(), 1348);
        assertEquals(new PersianCalendar(0).getMonth(), 10);
        assertEquals(new PersianCalendar(0).getDay(), 11);
        assertEquals(new PersianCalendar(0).getHour(), 0);
        assertEquals(new PersianCalendar(0).getMinute(), 0);
        assertEquals(new PersianCalendar(0).getSecond(), 0);
        assertEquals(new PersianCalendar(0).getMillis(), 0);
    }

    public static void consistency_check() {
        PersianCalendar previousDay = new PersianCalendar(1, 1, 1);
        int daysPassed = 0;
        for (int year = 1; year != 2999; year++) {
            for (int month = 1; month != 13; month++) {
                for (int day = 1; day <= DateConverter.getDaysOfMonthPersian(year, month); day++) {
                    PersianCalendar today = new PersianCalendar(year, month, day);
                    assertEquals(today, new PersianCalendar(today.getTimeInMillis()));
                    assertEquals(today, today.getTomorrow().getYesterday());
                    assertEquals(today, new PersianCalendar(today.getYear(), today.getMonth(), today.getDay(),
                            today.getHour(), today.getMinute(), today.getSecond(), today.getMillis()));
                    if (daysPassed > 0) {
                        assertEquals(today, previousDay.getTomorrow());
                        assertEquals(today, today.getYesterday().getTomorrow());
                        previousDay = today;
                    }
                    daysPassed++;
                    if (daysPassed > 21)
                        assertEquals(today.getStartOfTheNextWeek().getStartOfTheWeek().getStartOfThePreviousWeek()
                                , today.getStartOfTheWeek());
                }
            }
        }
    }


}
