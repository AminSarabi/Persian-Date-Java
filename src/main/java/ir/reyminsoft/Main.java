package ir.reyminsoft;

import static ir.reyminsoft.DateConverter.convertDate;
import static ir.reyminsoft.DateConverter.getDaysOfMonthGregorian;
import static ir.reyminsoft.Utils.print;

public class Main {
    public static void main(String[] args) {
        for (int year = 2018; year != 2025; year++) {
            for (int month = 1; month != 12; month++) {
                for (int day = 0; day != getDaysOfMonthGregorian(year, month); day++) {
                    print((Object) convertDate(year, month, day));
                }
            }
        }
    }


}