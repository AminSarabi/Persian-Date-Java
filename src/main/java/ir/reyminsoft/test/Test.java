package ir.reyminsoft.test;

import ir.reyminsoft.DateConverter;
import ir.reyminsoft.Utils;

import static ir.reyminsoft.test.TestClassRunner.assertEquals;
import static ir.reyminsoft.test.TestClassRunner.print;

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
            Utils.print(dates[i]);
            assertEquals(expectedConversions[i], DateConverter.convertDate(dates[i]));
        }
    }
}
