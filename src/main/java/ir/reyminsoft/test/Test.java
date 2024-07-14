package ir.reyminsoft.test;

import ir.reyminsoft.DateConverter;

import static ir.reyminsoft.test.TestClassRunner.assertEquals;

public class Test implements TestClass {


    public static void main(String[] args) {
        TestClassRunner.run(Test.class);
    }


    public static void test_non_leap_conversions() { /*none of the persian or gregorian years is a leap year.*/
        int[][] dates = new int[][]{
                (new int[]{2023, 1, 1}),
                (new int[]{2023, 1, 31}),
                (new int[]{2023, 2, 1}),
                (new int[]{2023, 2, 28}),
                (new int[]{2023, 3, 1}),
                (new int[]{2023, 3, 31}),
                (new int[]{2023, 4, 1}),
                (new int[]{2023, 4, 30}),
                (new int[]{2023, 5, 1}),
                (new int[]{2023, 5, 31}),
                (new int[]{2023, 6, 1}),
                (new int[]{2023, 6, 30}),
                (new int[]{2023, 7, 1}),
                (new int[]{2023, 7, 31}),
                (new int[]{2023, 8, 1}),
                (new int[]{2023, 8, 31}),
                (new int[]{2023, 9, 1}),
                (new int[]{2023, 9, 30}),
                (new int[]{2023, 10, 1}),
                (new int[]{2023, 10, 31}),
                (new int[]{2023, 11, 1}),
                (new int[]{2023, 11, 30}),
                (new int[]{2023, 12, 1}),
                (new int[]{2023, 12, 31}),
        };
        int[][] expectedConversions = new int[][]{
                (new int[]{1401, 10, 11}),
                (new int[]{1401, 11, 11}),
                (new int[]{1401, 11, 12}),
                (new int[]{1401, 12, 9}),
                (new int[]{1401, 12, 10}),
                (new int[]{1402, 1, 11}),
                (new int[]{1402, 1, 12}),
                (new int[]{1402, 2, 10}),
                (new int[]{1402, 2, 11}),
                (new int[]{1402, 3, 10}),
                (new int[]{1402, 3, 11}),
                (new int[]{1402, 4, 9}),
                (new int[]{1402, 4, 10}),
                (new int[]{1402, 5, 9}),
                (new int[]{1402, 5, 10}),
                (new int[]{1402, 6, 9}),
                (new int[]{1402, 6, 10}),
                (new int[]{1402, 7, 8}),
                (new int[]{1402, 7, 9}),
                (new int[]{1402, 8, 9}),
                (new int[]{1402, 8, 10}),
                (new int[]{1402, 9, 9}),
                (new int[]{1402, 9, 10}),
                (new int[]{1402, 10, 10}),
                (new int[]{1402, 10, 11}),
                (new int[]{1402, 11, 11}),
                (new int[]{1402, 11, 12}),
                (new int[]{1402, 12, 9}),
        };
        for (int i = 0; i != dates.length; i++) {
            assertEquals(expectedConversions[i], DateConverter.convertDate(dates[i]));
        }
    }


    public static void test_persian_leap_year() {
        int[][] dates = new int[][]{
                (new int[]{2025, 3, 20}),

                (new int[]{2024, 1, 1}),
                (new int[]{2024, 1, 31}),

                (new int[]{2024, 2, 1}),
                (new int[]{2024, 2, 29}),

                (new int[]{2024, 3, 1}),
                (new int[]{2024, 3, 31}),

                (new int[]{2024, 4, 1}),
                (new int[]{2024, 4, 30}),

                (new int[]{2024, 5, 1}),
                (new int[]{2024, 5, 31}),

                (new int[]{2024, 6, 1}),
                (new int[]{2024, 6, 30}),

                (new int[]{2024, 7, 1}),
                (new int[]{2024, 7, 31}),

                (new int[]{2024, 8, 1}),
                (new int[]{2024, 8, 31}),

                (new int[]{2024, 9, 1}),
                (new int[]{2024, 9, 30}),

                (new int[]{2024, 10, 1}),
                (new int[]{2024, 10, 31}),

                (new int[]{2024, 11, 1}),
                (new int[]{2024, 11, 30}),

                (new int[]{2024, 12, 1}),
                (new int[]{2024, 12, 31}),
        };
        int[][] expectedConversions = new int[][]{
                (new int[]{1403, 12, 30}),

                (new int[]{1402, 10, 11}),
                (new int[]{1402, 11, 11}),

                (new int[]{1402, 11, 12}),
                (new int[]{1402, 12, 10}),

                (new int[]{1402, 12, 11}),
                (new int[]{1403, 1, 12}),

                (new int[]{1403, 1, 13}),
                (new int[]{1403, 2, 11}),

                (new int[]{1403, 2, 12}),
                (new int[]{1403, 3, 11}),

                (new int[]{1403, 3, 12}),
                (new int[]{1403, 4, 10}),

                (new int[]{1403, 4, 11}),
                (new int[]{1403, 5, 10}),

                (new int[]{1403, 5, 11}),
                (new int[]{1403, 6, 10}),

                (new int[]{1403, 6, 11}),
                (new int[]{1403, 7, 9}),

                (new int[]{1403, 7, 10}),
                (new int[]{1403, 8, 10}),

                (new int[]{1403, 8, 11}),
                (new int[]{1403, 9, 10}),

                (new int[]{1403, 9, 11}),
                (new int[]{1403, 10, 11}),

                (new int[]{1403, 10, 12}),
                (new int[]{1403, 11, 12}),

                (new int[]{1403, 11, 13}),
                (new int[]{1403, 12, 10}),
        };
        for (int i = 0; i != dates.length; i++) {
            int[] conversion = DateConverter.convertDate(dates[i]);
            assertEquals(expectedConversions[i], conversion);
        }
    }


    public static void test_random_dates() {
        int[][] datesAndExpectedConversions = new int[][]{
                (new int[]{1970, 1, 1}),
                (new int[]{1348, 10, 11}),

                (new int[]{1970, 7, 9}),
                (new int[]{1349, 4, 18}),

                (new int[]{1996, 11, 19}), //both are leap years
                (new int[]{1375, 8, 29}),

                (new int[]{1700, 4, 30}),
                (new int[]{1079, 2, 10}),

                (new int[]{700, 1, 1}),
                (new int[]{78, 10, 11}),

                (new int[]{700, 2, 1}),
                (new int[]{78, 11, 12}),

                (new int[]{700, 2, 1}),
                (new int[]{78, 11, 12}),

                (new int[]{700, 4, 30}),
                (new int[]{79, 2, 10}),

        };

        for (int x = 0; x < datesAndExpectedConversions.length; ) {
            int[] date = datesAndExpectedConversions[x++];
            int[] expectedConversion = datesAndExpectedConversions[x++];
            int[] conversion = DateConverter.convertDate(date);
            assertEquals(expectedConversion, conversion);
        }
    }

    //this is an interesting test that discovered 1582/10/5 incident in which time moved forward!
    public static void test_brute_force() {
        //we basically check that for each 1 day increment in gregorian calendar, the conversion also increases by 1 day.
        int current = 0;
        for (int year = 623; year != 2000; year++) {
            for (int month = 1; month != 13; month++) {
                for (int day = 1; day <= DateConverter.getDaysOfMonthGregorian(year, month); day++) {
                    int[] conversion = DateConverter.convertDate(year, month, day);
                    int no = DateConverter.countOfDays(conversion[0], conversion[1], conversion[2]);
                    if (current != 0) assertEquals(no, ++current);
                    current = no;
                }
            }
        }
    }


}
