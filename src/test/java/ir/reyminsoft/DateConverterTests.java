package ir.reyminsoft;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Random;

import static ir.reyminsoft.TestClassRunner.assertEquals;

public class DateConverterTests implements TestClass {


    static Random random = new Random();

    public static void main(String[] args) {
        TestClassRunner.run(DateConverterTests.class);
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
            assertEquals(expectedConversions[i], DateConverter.convertGregorianToPersian(dates[i]));
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
            int[] conversion = DateConverter.convertGregorianToPersian(dates[i]);
            assertEquals(expectedConversions[i], conversion);
        }
    }


    //these are a bunch of random conversions I have extracted from accurate sources.

    //these are a set of edge cases chosen and calculated by hand.
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
            int[] conversion = DateConverter.convertGregorianToPersian(date);
            assertEquals(expectedConversion, conversion);
        }
    }

    /*
     * a brute force internal-consistency check.
     * This is an interesting test that discovered 1582/10/5 incident in which time moved forward!
     * */

    public static void test_random_dates2() {
        int[][] datesAndExpectedConversions = new int[][]{
                new int[]{623, 5, 29}, new int[]{2, 3, 7},
                new int[]{623, 7, 26}, new int[]{2, 5, 3},
                new int[]{623, 10, 15}, new int[]{2, 7, 22},
                new int[]{623, 6, 19}, new int[]{2, 3, 28},
                new int[]{624, 9, 12}, new int[]{3, 6, 21},
                new int[]{624, 10, 30}, new int[]{3, 8, 8},
                new int[]{624, 4, 24}, new int[]{3, 2, 4},
                new int[]{624, 6, 7}, new int[]{3, 3, 17},
                new int[]{625, 8, 12}, new int[]{4, 5, 21},
                new int[]{625, 2, 5}, new int[]{3, 11, 16},
                new int[]{625, 4, 4}, new int[]{4, 1, 15},
                new int[]{625, 5, 10}, new int[]{4, 2, 20},
                new int[]{626, 4, 23}, new int[]{5, 2, 2},
                new int[]{626, 9, 10}, new int[]{5, 6, 18},
                new int[]{626, 2, 23}, new int[]{4, 12, 4},
                new int[]{626, 1, 3}, new int[]{4, 10, 13},
                new int[]{627, 7, 12}, new int[]{6, 4, 20},
                new int[]{627, 10, 8}, new int[]{6, 7, 15},
                new int[]{627, 6, 27}, new int[]{6, 4, 5},
                new int[]{627, 11, 8}, new int[]{6, 8, 16},
                new int[]{628, 9, 3}, new int[]{7, 6, 12},
                new int[]{628, 8, 6}, new int[]{7, 5, 15},
                new int[]{628, 12, 12}, new int[]{7, 9, 21},
                new int[]{628, 9, 14}, new int[]{7, 6, 23},
                new int[]{629, 7, 12}, new int[]{8, 4, 21},
                new int[]{629, 1, 30}, new int[]{7, 11, 10},
                new int[]{629, 4, 3}, new int[]{8, 1, 14},
                new int[]{629, 8, 30}, new int[]{8, 6, 8},
                new int[]{1900, 12, 23}, new int[]{1279, 10, 2},
                new int[]{1900, 7, 1}, new int[]{1279, 4, 10}, new int[]{1901, 2, 27}, new int[]{1279, 12, 8},
                new int[]{1901, 10, 26}, new int[]{1280, 8, 4}, new int[]{1902, 2, 17}, new int[]{1280, 11, 28},
                new int[]{1902, 2, 27}, new int[]{1280, 12, 8}, new int[]{1903, 3, 26}, new int[]{1282, 1, 5},
                new int[]{1903, 8, 22}, new int[]{1282, 5, 30}, new int[]{1904, 4, 25}, new int[]{1283, 2, 5},
                new int[]{1904, 8, 2}, new int[]{1283, 5, 11}, new int[]{1905, 7, 22}, new int[]{1284, 4, 31},
                new int[]{1905, 7, 18}, new int[]{1284, 4, 27}, new int[]{1906, 10, 22}, new int[]{1285, 7, 29},
                new int[]{1906, 12, 2}, new int[]{1285, 9, 10}, new int[]{1907, 5, 25}, new int[]{1286, 3, 3},
                new int[]{1907, 1, 28}, new int[]{1285, 11, 7}, new int[]{1908, 5, 31}, new int[]{1287, 3, 10},
                new int[]{1908, 10, 10}, new int[]{1287, 7, 18}, new int[]{1909, 2, 7}, new int[]{1287, 11, 18},
                new int[]{1909, 2, 26}, new int[]{1287, 12, 7}, new int[]{1910, 6, 29}, new int[]{1289, 4, 7},
                new int[]{1910, 1, 4}, new int[]{1288, 10, 14}, new int[]{1911, 2, 16}, new int[]{1289, 11, 26},
                new int[]{1911, 1, 25}, new int[]{1289, 11, 4}, new int[]{1912, 9, 29}, new int[]{1291, 7, 7},
                new int[]{1912, 9, 9}, new int[]{1291, 6, 18}, new int[]{1913, 3, 17}, new int[]{1291, 12, 26},
                new int[]{1913, 1, 24}, new int[]{1291, 11, 4}, new int[]{1914, 1, 13}, new int[]{1292, 10, 23},
                new int[]{1914, 2, 12}, new int[]{1292, 11, 23}, new int[]{1915, 11, 18}, new int[]{1294, 8, 26},
                new int[]{1915, 4, 24}, new int[]{1294, 2, 3}, new int[]{1916, 9, 21}, new int[]{1295, 6, 30},
                new int[]{1916, 11, 13}, new int[]{1295, 8, 22}, new int[]{1917, 12, 8}, new int[]{1296, 9, 17},
                new int[]{1917, 9, 18}, new int[]{1296, 6, 27}, new int[]{1918, 12, 10}, new int[]{1297, 9, 18},
                new int[]{1918, 11, 15}, new int[]{1297, 8, 23}, new int[]{1919, 6, 13}, new int[]{1298, 3, 22},
                new int[]{1919, 12, 18}, new int[]{1298, 9, 26}, new int[]{1920, 2, 17}, new int[]{1298, 11, 27},
                new int[]{1920, 1, 2}, new int[]{1298, 10, 11}, new int[]{1921, 12, 30}, new int[]{1300, 10, 9},
                new int[]{1921, 11, 7}, new int[]{1300, 8, 16}, new int[]{1922, 11, 21}, new int[]{1301, 8, 29},
                new int[]{1922, 1, 24}, new int[]{1300, 11, 4}, new int[]{1923, 11, 9}, new int[]{1302, 8, 17},
                new int[]{1923, 10, 21}, new int[]{1302, 7, 28}, new int[]{1924, 6, 11}, new int[]{1303, 3, 21},
                new int[]{1924, 10, 13}, new int[]{1303, 7, 21}, new int[]{1925, 6, 29}, new int[]{1304, 4, 8},
                new int[]{1925, 12, 22}, new int[]{1304, 10, 1}, new int[]{1926, 3, 23}, new int[]{1305, 1, 2},
                new int[]{1926, 9, 2}, new int[]{1305, 6, 10}, new int[]{1927, 3, 24}, new int[]{1306, 1, 3},
                new int[]{1927, 2, 6}, new int[]{1305, 11, 16}, new int[]{1928, 8, 14}, new int[]{1307, 5, 23},
                new int[]{1928, 2, 17}, new int[]{1306, 11, 27}, new int[]{1929, 8, 15}, new int[]{1308, 5, 24},
                new int[]{1929, 4, 2}, new int[]{1308, 1, 13}, new int[]{1930, 12, 27}, new int[]{1309, 10, 6},
                new int[]{1930, 2, 28}, new int[]{1308, 12, 9}, new int[]{1931, 1, 25}, new int[]{1309, 11, 5},
                new int[]{1931, 2, 12}, new int[]{1309, 11, 23}, new int[]{1932, 5, 14}, new int[]{1311, 2, 24},
                new int[]{1932, 4, 6}, new int[]{1311, 1, 17}, new int[]{1933, 1, 27}, new int[]{1311, 11, 7},
                new int[]{1933, 12, 15}, new int[]{1312, 9, 24}, new int[]{1934, 12, 2}, new int[]{1313, 9, 11},
                new int[]{1934, 11, 17}, new int[]{1313, 8, 26}, new int[]{1935, 4, 6}, new int[]{1314, 1, 16},
                new int[]{1935, 4, 24}, new int[]{1314, 2, 3}, new int[]{1936, 12, 8}, new int[]{1315, 9, 17},
                new int[]{1936, 5, 26}, new int[]{1315, 3, 5}, new int[]{1937, 1, 16}, new int[]{1315, 10, 26},
                new int[]{1937, 2, 19}, new int[]{1315, 11, 30}, new int[]{1938, 10, 13}, new int[]{1317, 7, 21},
                new int[]{1938, 7, 14}, new int[]{1317, 4, 23}, new int[]{1939, 3, 3}, new int[]{1317, 12, 12},
                new int[]{1939, 11, 18}, new int[]{1318, 8, 26}, new int[]{1940, 3, 28}, new int[]{1319, 1, 8},
                new int[]{1940, 5, 26}, new int[]{1319, 3, 5}, new int[]{1941, 8, 19}, new int[]{1320, 5, 28},
                new int[]{1941, 5, 22}, new int[]{1320, 3, 1}, new int[]{1942, 9, 28}, new int[]{1321, 7, 6},
                new int[]{1942, 3, 26}, new int[]{1321, 1, 6}, new int[]{1943, 5, 19}, new int[]{1322, 2, 28},
                new int[]{1943, 12, 1}, new int[]{1322, 9, 9}, new int[]{1944, 9, 3}, new int[]{1323, 6, 12},
                new int[]{1944, 3, 10}, new int[]{1322, 12, 19}, new int[]{1945, 8, 15}, new int[]{1324, 5, 24},
                new int[]{1945, 4, 20}, new int[]{1324, 1, 31}, new int[]{1946, 9, 16}, new int[]{1325, 6, 25},
                new int[]{1946, 5, 9}, new int[]{1325, 2, 19}, new int[]{1947, 2, 11}, new int[]{1325, 11, 22},
                new int[]{1947, 8, 4}, new int[]{1326, 5, 12}, new int[]{1948, 4, 7}, new int[]{1327, 1, 18},
                new int[]{1948, 2, 21}, new int[]{1326, 12, 1}, new int[]{1949, 1, 10}, new int[]{1327, 10, 20},
                new int[]{1949, 6, 28}, new int[]{1328, 4, 7}, new int[]{1950, 5, 6}, new int[]{1329, 2, 16},
                new int[]{1950, 3, 15}, new int[]{1328, 12, 24}, new int[]{1951, 10, 6}, new int[]{1330, 7, 13},
                new int[]{1951, 8, 9}, new int[]{1330, 5, 17}, new int[]{1952, 11, 20}, new int[]{1331, 8, 29},
                new int[]{1952, 4, 27}, new int[]{1331, 2, 7}, new int[]{1953, 3, 30}, new int[]{1332, 1, 10},
                new int[]{1953, 7, 14}, new int[]{1332, 4, 23}, new int[]{1954, 6, 24}, new int[]{1333, 4, 3},
                new int[]{1954, 1, 31}, new int[]{1332, 11, 11}, new int[]{1955, 2, 13}, new int[]{1333, 11, 24},
                new int[]{1955, 3, 14}, new int[]{1333, 12, 23}, new int[]{1956, 5, 9}, new int[]{1335, 2, 19},
                new int[]{1956, 2, 7}, new int[]{1334, 11, 17}, new int[]{1957, 4, 29}, new int[]{1336, 2, 9},
                new int[]{1957, 10, 30}, new int[]{1336, 8, 8}, new int[]{1958, 2, 3}, new int[]{1336, 11, 14},
                new int[]{1958, 11, 14}, new int[]{1337, 8, 23}, new int[]{1959, 1, 13}, new int[]{1337, 10, 23},
                new int[]{1959, 8, 22}, new int[]{1338, 5, 30}, new int[]{1960, 7, 23}, new int[]{1339, 5, 1},
                new int[]{1960, 1, 4}, new int[]{1338, 10, 13}, new int[]{1961, 1, 29}, new int[]{1339, 11, 9},
                new int[]{1961, 12, 24}, new int[]{1340, 10, 3}, new int[]{1962, 10, 11}, new int[]{1341, 7, 19},
                new int[]{1962, 2, 28}, new int[]{1340, 12, 9}, new int[]{1963, 5, 20}, new int[]{1342, 2, 30},
                new int[]{1963, 6, 20}, new int[]{1342, 3, 30}, new int[]{1964, 6, 14}, new int[]{1343, 3, 24},
                new int[]{1964, 2, 6}, new int[]{1342, 11, 17}, new int[]{1965, 12, 18}, new int[]{1344, 9, 27},
                new int[]{1965, 11, 22}, new int[]{1344, 9, 1}, new int[]{1966, 10, 14}, new int[]{1345, 7, 22},
                new int[]{1966, 8, 3}, new int[]{1345, 5, 12}, new int[]{1967, 12, 18}, new int[]{1346, 9, 27},
                new int[]{1967, 10, 28}, new int[]{1346, 8, 6}, new int[]{1968, 8, 10}, new int[]{1347, 5, 19},
                new int[]{1968, 7, 13}, new int[]{1347, 4, 22}, new int[]{1969, 9, 23}, new int[]{1348, 7, 1},
                new int[]{1969, 8, 16}, new int[]{1348, 5, 25}, new int[]{1970, 9, 11}, new int[]{1349, 6, 20},
                new int[]{1970, 3, 30}, new int[]{1349, 1, 10}, new int[]{1971, 3, 25}, new int[]{1350, 1, 5},
                new int[]{1971, 10, 29}, new int[]{1350, 8, 7}, new int[]{1972, 1, 3}, new int[]{1350, 10, 13},
                new int[]{1972, 1, 13}, new int[]{1350, 10, 23}, new int[]{1973, 9, 27}, new int[]{1352, 7, 5},
                new int[]{1973, 9, 22}, new int[]{1352, 6, 31}, new int[]{1974, 3, 16}, new int[]{1352, 12, 25},
                new int[]{1974, 1, 20}, new int[]{1352, 10, 30}, new int[]{1975, 10, 22}, new int[]{1354, 7, 30},
                new int[]{1975, 12, 16}, new int[]{1354, 9, 25}, new int[]{1976, 1, 3}, new int[]{1354, 10, 13},
                new int[]{1976, 8, 4}, new int[]{1355, 5, 13}, new int[]{1977, 4, 5}, new int[]{1356, 1, 16},
                new int[]{1977, 8, 21}, new int[]{1356, 5, 30}, new int[]{1978, 4, 11}, new int[]{1357, 1, 22},
                new int[]{1978, 9, 7}, new int[]{1357, 6, 16}, new int[]{1979, 1, 9}, new int[]{1357, 10, 19},
                new int[]{1979, 3, 24}, new int[]{1358, 1, 4}, new int[]{1980, 10, 1}, new int[]{1359, 7, 9},
                new int[]{1980, 11, 18}, new int[]{1359, 8, 27}, new int[]{1981, 2, 3}, new int[]{1359, 11, 14},
                new int[]{1981, 12, 26}, new int[]{1360, 10, 5}, new int[]{1982, 2, 23}, new int[]{1360, 12, 4},
                new int[]{1982, 5, 6}, new int[]{1361, 2, 16}, new int[]{1983, 5, 5}, new int[]{1362, 2, 15},
                new int[]{1983, 9, 25}, new int[]{1362, 7, 3}, new int[]{1984, 12, 13}, new int[]{1363, 9, 22},
                new int[]{1984, 4, 23}, new int[]{1363, 2, 3}, new int[]{1985, 3, 9}, new int[]{1363, 12, 18},
                new int[]{1985, 2, 7}, new int[]{1363, 11, 18}, new int[]{1986, 2, 23}, new int[]{1364, 12, 4},
                new int[]{1986, 5, 19}, new int[]{1365, 2, 29}, new int[]{1987, 11, 10}, new int[]{1366, 8, 19},
                new int[]{1987, 2, 7}, new int[]{1365, 11, 18}, new int[]{1988, 8, 10}, new int[]{1367, 5, 19},
                new int[]{1988, 11, 20}, new int[]{1367, 8, 29}, new int[]{1989, 7, 30}, new int[]{1368, 5, 8},
                new int[]{1989, 1, 4}, new int[]{1367, 10, 14}, new int[]{1990, 12, 29}, new int[]{1369, 10, 8},
                new int[]{1990, 7, 25}, new int[]{1369, 5, 3}, new int[]{1991, 11, 25}, new int[]{1370, 9, 4},
                new int[]{1991, 12, 14}, new int[]{1370, 9, 23}, new int[]{1992, 1, 22}, new int[]{1370, 11, 2},
                new int[]{1992, 9, 23}, new int[]{1371, 7, 1}, new int[]{1993, 2, 8}, new int[]{1371, 11, 19},
                new int[]{1993, 7, 12}, new int[]{1372, 4, 21}, new int[]{1994, 6, 4}, new int[]{1373, 3, 14},
                new int[]{1994, 1, 14}, new int[]{1372, 10, 24}, new int[]{1995, 1, 9}, new int[]{1373, 10, 19},
                new int[]{1995, 3, 29}, new int[]{1374, 1, 9}, new int[]{1996, 7, 8}, new int[]{1375, 4, 18},
                new int[]{1996, 3, 30}, new int[]{1375, 1, 11}, new int[]{1997, 3, 17}, new int[]{1375, 12, 27},
                new int[]{1997, 9, 5}, new int[]{1376, 6, 14}, new int[]{1998, 9, 5}, new int[]{1377, 6, 14},
                new int[]{1998, 6, 19}, new int[]{1377, 3, 29}, new int[]{1999, 8, 6}, new int[]{1378, 5, 15},
                new int[]{1999, 11, 10}, new int[]{1378, 8, 19}, new int[]{2000, 5, 30}, new int[]{1379, 3, 10},
                new int[]{2000, 9, 24}, new int[]{1379, 7, 3}, new int[]{2001, 5, 26}, new int[]{1380, 3, 5},
                new int[]{2001, 8, 12}, new int[]{1380, 5, 21}, new int[]{2002, 11, 12}, new int[]{1381, 8, 21},
                new int[]{2002, 10, 16}, new int[]{1381, 7, 24}, new int[]{2003, 3, 25}, new int[]{1382, 1, 5},
                new int[]{2003, 2, 11}, new int[]{1381, 11, 22}, new int[]{2004, 3, 20}, new int[]{1383, 1, 1},
                new int[]{2004, 3, 22}, new int[]{1383, 1, 3}, new int[]{2005, 12, 8}, new int[]{1384, 9, 17},
                new int[]{2005, 7, 15}, new int[]{1384, 4, 24}, new int[]{2006, 7, 21}, new int[]{1385, 4, 30},
                new int[]{2006, 3, 8}, new int[]{1384, 12, 17}, new int[]{2007, 10, 22}, new int[]{1386, 7, 30},
                new int[]{2007, 3, 12}, new int[]{1385, 12, 21}, new int[]{2008, 1, 5}, new int[]{1386, 10, 15},
                new int[]{2008, 5, 12}, new int[]{1387, 2, 23}, new int[]{2009, 4, 15}, new int[]{1388, 1, 26},
                new int[]{2009, 2, 17}, new int[]{1387, 11, 29}, new int[]{2010, 9, 22}, new int[]{1389, 6, 31},
                new int[]{2010, 10, 11}, new int[]{1389, 7, 19}, new int[]{2011, 8, 30}, new int[]{1390, 6, 8},
                new int[]{2011, 12, 11}, new int[]{1390, 9, 20}, new int[]{2012, 10, 16}, new int[]{1391, 7, 25},
                new int[]{2012, 10, 16}, new int[]{1391, 7, 25}, new int[]{2013, 10, 26}, new int[]{1392, 8, 4},
                new int[]{2013, 6, 10}, new int[]{1392, 3, 20}, new int[]{2014, 5, 21}, new int[]{1393, 2, 31},
                new int[]{2014, 1, 8}, new int[]{1392, 10, 18}, new int[]{2015, 3, 20}, new int[]{1393, 12, 29},
                new int[]{2015, 12, 29}, new int[]{1394, 10, 8}, new int[]{2016, 8, 13}, new int[]{1395, 5, 23},
                new int[]{2016, 8, 19}, new int[]{1395, 5, 29}, new int[]{2017, 11, 14}, new int[]{1396, 8, 23},
                new int[]{2017, 9, 9}, new int[]{1396, 6, 18}, new int[]{2018, 9, 5}, new int[]{1397, 6, 14},
                new int[]{2018, 11, 25}, new int[]{1397, 9, 4}, new int[]{2019, 9, 19}, new int[]{1398, 6, 28},
                new int[]{2019, 11, 11}, new int[]{1398, 8, 20}, new int[]{2020, 9, 24}, new int[]{1399, 7, 3},
                new int[]{2020, 4, 14}, new int[]{1399, 1, 26}, new int[]{2021, 1, 3}, new int[]{1399, 10, 14},
                new int[]{2021, 11, 2}, new int[]{1400, 8, 11}, new int[]{2022, 9, 23}, new int[]{1401, 7, 1},
                new int[]{2022, 10, 21}, new int[]{1401, 7, 29}, new int[]{2023, 12, 21}, new int[]{1402, 9, 30},
                new int[]{2023, 9, 24}, new int[]{1402, 7, 2}, new int[]{2024, 5, 19}, new int[]{1403, 2, 30},
                new int[]{2024, 5, 12}, new int[]{1403, 2, 23}, new int[]{2025, 12, 26}, new int[]{1404, 10, 5},
                new int[]{2025, 4, 30}, new int[]{1404, 2, 10}, new int[]{2026, 9, 13}, new int[]{1405, 6, 22},
                new int[]{2026, 7, 14}, new int[]{1405, 4, 23}, new int[]{2027, 6, 17}, new int[]{1406, 3, 27},
                new int[]{2027, 4, 10}, new int[]{1406, 1, 21}, new int[]{2028, 10, 7}, new int[]{1407, 7, 16},
                new int[]{2028, 1, 20}, new int[]{1406, 10, 30}, new int[]{2029, 12, 29}, new int[]{1408, 10, 9},
                new int[]{2029, 6, 24}, new int[]{1408, 4, 4}, new int[]{2030, 3, 10}, new int[]{1408, 12, 20},
                new int[]{2030, 8, 27}, new int[]{1409, 6, 5}, new int[]{2031, 7, 21}, new int[]{1410, 4, 30},
                new int[]{2031, 10, 17}, new int[]{1410, 7, 25}, new int[]{2032, 8, 31}, new int[]{1411, 6, 10},
                new int[]{2032, 9, 16}, new int[]{1411, 6, 26}, new int[]{2033, 10, 9}, new int[]{1412, 7, 18},
                new int[]{2033, 7, 5}, new int[]{1412, 4, 15}, new int[]{2034, 3, 11}, new int[]{1412, 12, 21},
                new int[]{2034, 12, 24}, new int[]{1413, 10, 3}, new int[]{2035, 12, 31}, new int[]{1414, 10, 10},
                new int[]{2035, 10, 26}, new int[]{1414, 8, 4}, new int[]{2036, 4, 8}, new int[]{1415, 1, 20},
                new int[]{2036, 6, 4}, new int[]{1415, 3, 15}, new int[]{2037, 11, 7}, new int[]{1416, 8, 17},
                new int[]{2037, 7, 31}, new int[]{1416, 5, 10}, new int[]{2038, 10, 29}, new int[]{1417, 8, 7},
                new int[]{2038, 8, 24}, new int[]{1417, 6, 2}, new int[]{2039, 11, 13}, new int[]{1418, 8, 22},
                new int[]{2039, 3, 4}, new int[]{1417, 12, 13}, new int[]{2040, 11, 22}, new int[]{1419, 9, 2},
                new int[]{2040, 9, 16}, new int[]{1419, 6, 26}, new int[]{2041, 8, 9}, new int[]{1420, 5, 19},
                new int[]{2041, 9, 11}, new int[]{1420, 6, 21}, new int[]{2042, 11, 19}, new int[]{1421, 8, 28},
                new int[]{2042, 7, 13}, new int[]{1421, 4, 22}, new int[]{2043, 9, 18}, new int[]{1422, 6, 27},
                new int[]{2043, 4, 18}, new int[]{1422, 1, 29}, new int[]{2044, 6, 24}, new int[]{1423, 4, 4},
                new int[]{2044, 3, 18}, new int[]{1422, 12, 28}, new int[]{2045, 9, 2}, new int[]{1424, 6, 12},
                new int[]{2045, 9, 2}, new int[]{1424, 6, 12}, new int[]{2046, 8, 26}, new int[]{1425, 6, 4},
                new int[]{2046, 12, 9}, new int[]{1425, 9, 18}, new int[]{2047, 5, 11}, new int[]{1426, 2, 21},
                new int[]{2047, 4, 19}, new int[]{1426, 1, 30}, new int[]{2048, 6, 7}, new int[]{1427, 3, 18},
                new int[]{2048, 12, 16}, new int[]{1427, 9, 26}, new int[]{2049, 10, 1}, new int[]{1428, 7, 10},
                new int[]{2049, 4, 15}, new int[]{1428, 1, 27}, new int[]{2050, 11, 29}, new int[]{1429, 9, 8},
                new int[]{2050, 4, 4}, new int[]{1429, 1, 15}, new int[]{2051, 9, 12}, new int[]{1430, 6, 21},
                new int[]{2051, 2, 10}, new int[]{1429, 11, 21}, new int[]{2052, 12, 12}, new int[]{1431, 9, 22},
                new int[]{2052, 4, 17}, new int[]{1431, 1, 29}, new int[]{2053, 4, 17}, new int[]{1432, 1, 29},
                new int[]{2053, 6, 13}, new int[]{1432, 3, 24}, new int[]{2054, 2, 20}, new int[]{1432, 12, 2},
                new int[]{2054, 1, 10}, new int[]{1432, 10, 21}, new int[]{2055, 9, 2}, new int[]{1434, 6, 11},
                new int[]{2055, 1, 20}, new int[]{1433, 10, 30}, new int[]{2056, 6, 4}, new int[]{1435, 3, 15},
                new int[]{2056, 5, 11}, new int[]{1435, 2, 22}, new int[]{2057, 10, 5}, new int[]{1436, 7, 14},
                new int[]{2057, 12, 9}, new int[]{1436, 9, 19}, new int[]{2058, 5, 19}, new int[]{1437, 2, 29},
                new int[]{2058, 10, 26}, new int[]{1437, 8, 4}, new int[]{2059, 7, 21}, new int[]{1438, 4, 30},
                new int[]{2059, 4, 16}, new int[]{1438, 1, 27}, new int[]{2060, 8, 31}, new int[]{1439, 6, 10},
                new int[]{2060, 4, 5}, new int[]{1439, 1, 17}, new int[]{2061, 5, 4}, new int[]{1440, 2, 15},
                new int[]{2061, 3, 12}, new int[]{1439, 12, 22}, new int[]{2062, 5, 20}, new int[]{1441, 2, 31},
                new int[]{2062, 4, 20}, new int[]{1441, 2, 1}, new int[]{2063, 1, 23}, new int[]{1441, 11, 4},
                new int[]{2063, 8, 23}, new int[]{1442, 6, 1}, new int[]{2064, 11, 14}, new int[]{1443, 8, 24},
                new int[]{2064, 8, 2}, new int[]{1443, 5, 12}, new int[]{2065, 7, 24}, new int[]{1444, 5, 3},
                new int[]{2065, 4, 16}, new int[]{1444, 1, 28}, new int[]{2066, 3, 13}, new int[]{1444, 12, 23},
                new int[]{2066, 1, 21}, new int[]{1444, 11, 2}, new int[]{2067, 1, 21}, new int[]{1445, 11, 2},
                new int[]{2067, 5, 30}, new int[]{1446, 3, 9}, new int[]{2068, 8, 25}, new int[]{1447, 6, 4},
                new int[]{2068, 6, 30}, new int[]{1447, 4, 10}, new int[]{2069, 5, 3}, new int[]{1448, 2, 14},
                new int[]{2069, 11, 10}, new int[]{1448, 8, 20}, new int[]{2070, 5, 18}, new int[]{1449, 2, 29},
                new int[]{2070, 1, 25}, new int[]{1448, 11, 6}, new int[]{2071, 11, 18}, new int[]{1450, 8, 27},
                new int[]{2071, 1, 7}, new int[]{1449, 10, 18}, new int[]{2072, 2, 10}, new int[]{1450, 11, 21},
                new int[]{2072, 9, 28}, new int[]{1451, 7, 7}, new int[]{2073, 8, 19}, new int[]{1452, 5, 29},
                new int[]{2073, 6, 11}, new int[]{1452, 3, 22}, new int[]{2074, 7, 22}, new int[]{1453, 5, 1},
                new int[]{2074, 3, 25}, new int[]{1453, 1, 6}, new int[]{2075, 10, 1}, new int[]{1454, 7, 9},
                new int[]{2075, 5, 13}, new int[]{1454, 2, 23}, new int[]{2076, 11, 10}, new int[]{1455, 8, 20},
                new int[]{2076, 11, 25}, new int[]{1455, 9, 5}, new int[]{2077, 12, 8}, new int[]{1456, 9, 18},
                new int[]{2077, 3, 26}, new int[]{1456, 1, 7}, new int[]{2078, 10, 14}, new int[]{1457, 7, 23},
                new int[]{2078, 12, 13}, new int[]{1457, 9, 23}, new int[]{2079, 1, 30}, new int[]{1457, 11, 11},
                new int[]{2079, 6, 6}, new int[]{1458, 3, 16}, new int[]{2080, 9, 3}, new int[]{1459, 6, 13},
                new int[]{2080, 2, 18}, new int[]{1458, 11, 29}, new int[]{2081, 3, 29}, new int[]{1460, 1, 10},
                new int[]{2081, 11, 2}, new int[]{1460, 8, 12}, new int[]{2082, 4, 5}, new int[]{1461, 1, 17},
                new int[]{2082, 7, 18}, new int[]{1461, 4, 28}, new int[]{2083, 7, 14}, new int[]{1462, 4, 23},
                new int[]{2083, 3, 18}, new int[]{1461, 12, 28}, new int[]{2084, 7, 11}, new int[]{1463, 4, 21},
                new int[]{2084, 11, 16}, new int[]{1463, 8, 26}, new int[]{2085, 11, 5}, new int[]{1464, 8, 15},
                new int[]{2085, 7, 5}, new int[]{1464, 4, 15}, new int[]{2086, 4, 20}, new int[]{1465, 2, 1},
                new int[]{2086, 11, 17}, new int[]{1465, 8, 27}, new int[]{2087, 6, 16}, new int[]{1466, 3, 26},
                new int[]{2087, 8, 5}, new int[]{1466, 5, 14}, new int[]{2088, 4, 10}, new int[]{1467, 1, 22},
                new int[]{2088, 1, 17}, new int[]{1466, 10, 27}, new int[]{2089, 8, 7}, new int[]{1468, 5, 17},
                new int[]{2089, 3, 21}, new int[]{1468, 1, 2}, new int[]{2090, 5, 4}, new int[]{1469, 2, 15},
                new int[]{2090, 2, 18}, new int[]{1468, 11, 30}, new int[]{2091, 9, 9}, new int[]{1470, 6, 18},
                new int[]{2091, 10, 25}, new int[]{1470, 8, 3}, new int[]{2092, 7, 13}, new int[]{1471, 4, 23},
                new int[]{2092, 6, 23}, new int[]{1471, 4, 3}, new int[]{2093, 8, 2}, new int[]{1472, 5, 12},
                new int[]{2093, 3, 5}, new int[]{1471, 12, 15}, new int[]{2094, 6, 24}, new int[]{1473, 4, 4},
                new int[]{2094, 3, 12}, new int[]{1472, 12, 22}, new int[]{2095, 5, 14}, new int[]{1474, 2, 25},
                new int[]{2095, 4, 2}, new int[]{1474, 1, 14}, new int[]{2096, 1, 2}, new int[]{1474, 10, 13},
                new int[]{2096, 2, 17}, new int[]{1474, 11, 29}, new int[]{2097, 4, 10}, new int[]{1476, 1, 22},
                new int[]{2097, 8, 19}, new int[]{1476, 5, 29}, new int[]{2098, 5, 24}, new int[]{1477, 3, 4},
                new int[]{2098, 4, 16}, new int[]{1477, 1, 28}, new int[]{2099, 6, 25}, new int[]{1478, 4, 5},
                new int[]{2099, 7, 13}, new int[]{1478, 4, 23}, new int[]{1400, 12, 17}, new int[]{779, 9, 26},
                new int[]{1400, 9, 27}, new int[]{779, 7, 5}, new int[]{1401, 1, 9}, new int[]{779, 10, 19},
                new int[]{1401, 2, 3}, new int[]{779, 11, 14}, new int[]{1402, 3, 17}, new int[]{780, 12, 26},
                new int[]{1402, 6, 7}, new int[]{781, 3, 16}, new int[]{1403, 12, 16}, new int[]{782, 9, 24},
                new int[]{1403, 12, 23}, new int[]{782, 10, 1}, new int[]{1404, 10, 7}, new int[]{783, 7, 15},
                new int[]{1404, 9, 24}, new int[]{783, 7, 2}, new int[]{1405, 4, 22}, new int[]{784, 2, 2},
                new int[]{1405, 6, 5}, new int[]{784, 3, 15}, new int[]{1406, 12, 26}, new int[]{785, 10, 4},
                new int[]{1406, 12, 3}, new int[]{785, 9, 11}, new int[]{1407, 5, 8}, new int[]{786, 2, 17},
                new int[]{1407, 12, 29}, new int[]{786, 10, 7}, new int[]{1408, 10, 9}, new int[]{787, 7, 17},
                new int[]{1408, 1, 11}, new int[]{786, 10, 20}, new int[]{1409, 8, 14}, new int[]{788, 5, 23},
                new int[]{1409, 6, 6}, new int[]{788, 3, 16}, new int[]{1410, 5, 20}, new int[]{789, 2, 30},
                new int[]{1410, 8, 31}, new int[]{789, 6, 9}, new int[]{1411, 4, 23}, new int[]{790, 2, 2},
                new int[]{1411, 9, 27}, new int[]{790, 7, 4}, new int[]{1412, 10, 15}, new int[]{791, 7, 23},
                new int[]{1412, 5, 17}, new int[]{791, 2, 27}, new int[]{1413, 12, 30}, new int[]{792, 10, 9},
                new int[]{1413, 8, 22}, new int[]{792, 5, 31}, new int[]{1414, 6, 8}, new int[]{793, 3, 18},
                new int[]{1414, 12, 13}, new int[]{793, 9, 22}, new int[]{1415, 10, 30}, new int[]{794, 8, 7},
                new int[]{1415, 6, 10}, new int[]{794, 3, 19}, new int[]{1416, 4, 5}, new int[]{795, 1, 16},
                new int[]{1416, 8, 24}, new int[]{795, 6, 2}, new int[]{1417, 6, 2}, new int[]{796, 3, 12},
                new int[]{1417, 4, 8}, new int[]{796, 1, 19}, new int[]{1418, 10, 27}, new int[]{797, 8, 5},
                new int[]{1418, 11, 17}, new int[]{797, 8, 26}, new int[]{1419, 8, 20}, new int[]{798, 5, 28},
                new int[]{1419, 3, 14}, new int[]{797, 12, 23}, new int[]{1420, 12, 11}, new int[]{799, 9, 20},
                new int[]{1420, 3, 8}, new int[]{798, 12, 17}, new int[]{1421, 12, 7}, new int[]{800, 9, 16},
                new int[]{1421, 12, 9}, new int[]{800, 9, 18}, new int[]{1422, 8, 23}, new int[]{801, 6, 1},
                new int[]{1422, 7, 17}, new int[]{801, 4, 26}, new int[]{1423, 2, 18}, new int[]{801, 11, 29},
                new int[]{1423, 5, 3}, new int[]{802, 2, 12}, new int[]{1424, 1, 27}, new int[]{802, 11, 6},
                new int[]{1424, 2, 22}, new int[]{802, 12, 2}, new int[]{1425, 7, 21}, new int[]{804, 4, 30},
                new int[]{1425, 11, 4}, new int[]{804, 8, 13}, new int[]{1426, 11, 3}, new int[]{805, 8, 12},
                new int[]{1426, 10, 15}, new int[]{805, 7, 23}, new int[]{1427, 3, 12}, new int[]{805, 12, 21},
                new int[]{1427, 3, 13}, new int[]{805, 12, 22}, new int[]{1428, 2, 21}, new int[]{806, 12, 1},
                new int[]{1428, 10, 28}, new int[]{807, 8, 6}, new int[]{1429, 3, 13}, new int[]{807, 12, 22},
                new int[]{1429, 10, 28}, new int[]{808, 8, 6}, new int[]{1430, 4, 5}, new int[]{809, 1, 16},
                new int[]{1430, 11, 24}, new int[]{809, 9, 3}, new int[]{1431, 11, 7}, new int[]{810, 8, 15},
                new int[]{1431, 1, 29}, new int[]{809, 11, 9}, new int[]{1432, 1, 3}, new int[]{810, 10, 12},
                new int[]{1432, 1, 22}, new int[]{810, 11, 1}, new int[]{1433, 3, 28}, new int[]{812, 1, 8},
                new int[]{1433, 11, 30}, new int[]{812, 9, 9}, new int[]{1434, 12, 8}, new int[]{813, 9, 17},
                new int[]{1434, 8, 9}, new int[]{813, 5, 18}, new int[]{1435, 8, 30}, new int[]{814, 6, 7},
                new int[]{1435, 8, 4}, new int[]{814, 5, 12}, new int[]{1436, 5, 7}, new int[]{815, 2, 17},
                new int[]{1436, 7, 13}, new int[]{815, 4, 22}, new int[]{1437, 8, 30}, new int[]{816, 6, 8},
                new int[]{1437, 4, 7}, new int[]{816, 1, 18}, new int[]{1438, 4, 11}, new int[]{817, 1, 22},
                new int[]{1438, 8, 28}, new int[]{817, 6, 6}, new int[]{1439, 7, 7}, new int[]{818, 4, 16},
                new int[]{1439, 3, 9}, new int[]{817, 12, 18}, new int[]{1440, 7, 18}, new int[]{819, 4, 27},
                new int[]{1440, 10, 16}, new int[]{819, 7, 24}, new int[]{1441, 3, 31}, new int[]{820, 1, 11},
                new int[]{1441, 4, 18}, new int[]{820, 1, 29}, new int[]{1442, 9, 13}, new int[]{821, 6, 22},
                new int[]{1442, 1, 17}, new int[]{820, 10, 27}, new int[]{1443, 4, 11}, new int[]{822, 1, 22},
                new int[]{1443, 6, 11}, new int[]{822, 3, 21}, new int[]{1444, 4, 3}, new int[]{823, 1, 14},
                new int[]{1444, 2, 10}, new int[]{822, 11, 21}, new int[]{1445, 9, 25}, new int[]{824, 7, 3},
                new int[]{1445, 1, 6}, new int[]{823, 10, 16}, new int[]{1446, 9, 24}, new int[]{825, 7, 2},
                new int[]{1446, 9, 20}, new int[]{825, 6, 29}, new int[]{1447, 8, 3}, new int[]{826, 5, 12},
                new int[]{1447, 1, 8}, new int[]{825, 10, 18}, new int[]{1448, 1, 30}, new int[]{826, 11, 10},
                new int[]{1448, 9, 25}, new int[]{827, 7, 3}, new int[]{1449, 4, 13}, new int[]{828, 1, 24},
                new int[]{1449, 8, 28}, new int[]{828, 6, 6}, new int[]{1450, 8, 26}, new int[]{829, 6, 4},
                new int[]{1450, 4, 18}, new int[]{829, 1, 29}, new int[]{1451, 5, 9}, new int[]{830, 2, 19},
                new int[]{1451, 1, 22}, new int[]{829, 11, 2}, new int[]{1452, 8, 31}, new int[]{831, 6, 9},
                new int[]{1452, 1, 20}, new int[]{830, 10, 30}, new int[]{1453, 1, 28}, new int[]{831, 11, 8},
                new int[]{1453, 12, 3}, new int[]{832, 9, 12}, new int[]{1454, 6, 7}, new int[]{833, 3, 17},
                new int[]{1454, 12, 23}, new int[]{833, 10, 2}, new int[]{1455, 2, 7}, new int[]{833, 11, 18},
                new int[]{1455, 2, 19}, new int[]{833, 11, 30}, new int[]{1456, 5, 11}, new int[]{835, 2, 21},
                new int[]{1456, 3, 15}, new int[]{834, 12, 25}, new int[]{1457, 3, 12}, new int[]{835, 12, 21},
                new int[]{1457, 11, 6}, new int[]{836, 8, 15}, new int[]{1458, 3, 28}, new int[]{837, 1, 8},
                new int[]{1458, 8, 11}, new int[]{837, 5, 20}, new int[]{1459, 3, 16}, new int[]{837, 12, 25},
                new int[]{1459, 9, 11}, new int[]{838, 6, 20}, new int[]{1460, 5, 3}, new int[]{839, 2, 13},
                new int[]{1460, 10, 15}, new int[]{839, 7, 23}, new int[]{1461, 9, 19}, new int[]{840, 6, 28},
                new int[]{1461, 11, 22}, new int[]{840, 9, 1}, new int[]{1462, 7, 18}, new int[]{841, 4, 27},
                new int[]{1462, 3, 28}, new int[]{841, 1, 8}, new int[]{1463, 9, 2}, new int[]{842, 6, 11},
                new int[]{1463, 12, 5}, new int[]{842, 9, 14}, new int[]{1464, 6, 23}, new int[]{843, 4, 2},
                new int[]{1464, 10, 28}, new int[]{843, 8, 6}, new int[]{1465, 5, 12}, new int[]{844, 2, 22},
                new int[]{1465, 5, 27}, new int[]{844, 3, 6}, new int[]{1466, 2, 23}, new int[]{844, 12, 4},
                new int[]{1466, 7, 17}, new int[]{845, 4, 26}, new int[]{1467, 8, 26}, new int[]{846, 6, 4},
                new int[]{1467, 6, 20}, new int[]{846, 3, 30}, new int[]{1468, 3, 7}, new int[]{846, 12, 17},
                new int[]{1468, 9, 7}, new int[]{847, 6, 16}, new int[]{1469, 8, 16}, new int[]{848, 5, 25},
                new int[]{1469, 4, 21}, new int[]{848, 2, 1}, new int[]{1470, 7, 24}, new int[]{849, 5, 2},
                new int[]{1470, 11, 4}, new int[]{849, 8, 13}, new int[]{1471, 10, 18}, new int[]{850, 7, 26},
                new int[]{1471, 7, 11}, new int[]{850, 4, 20}, new int[]{1472, 10, 1}, new int[]{851, 7, 10},
                new int[]{1472, 3, 25}, new int[]{851, 1, 6}, new int[]{1473, 10, 21}, new int[]{852, 7, 29},
                new int[]{1473, 9, 1}, new int[]{852, 6, 10}, new int[]{1474, 8, 10}, new int[]{853, 5, 19},
                new int[]{1474, 4, 2}, new int[]{853, 1, 13}, new int[]{1475, 5, 24}, new int[]{854, 3, 3},
                new int[]{1475, 4, 26}, new int[]{854, 2, 6}, new int[]{1476, 4, 18}, new int[]{855, 1, 30},
                new int[]{1476, 2, 9}, new int[]{854, 11, 20}, new int[]{1477, 3, 11}, new int[]{855, 12, 21},
                new int[]{1477, 5, 8}, new int[]{856, 2, 18}, new int[]{1478, 6, 22}, new int[]{857, 4, 1},
                new int[]{1478, 8, 2}, new int[]{857, 5, 11}, new int[]{1479, 4, 16}, new int[]{858, 1, 27},
                new int[]{1479, 8, 24}, new int[]{858, 6, 2}, new int[]{1480, 3, 25}, new int[]{859, 1, 6},
                new int[]{1480, 9, 18}, new int[]{859, 6, 28}, new int[]{1481, 5, 10}, new int[]{860, 2, 20},
                new int[]{1481, 9, 28}, new int[]{860, 7, 6}, new int[]{1482, 10, 6}, new int[]{861, 7, 14},
                new int[]{1482, 5, 20}, new int[]{861, 2, 30}, new int[]{1483, 2, 7}, new int[]{861, 11, 18},
                new int[]{1483, 1, 8}, new int[]{861, 10, 18}, new int[]{1484, 1, 28}, new int[]{862, 11, 8},
                new int[]{1484, 5, 29}, new int[]{863, 3, 9}, new int[]{1485, 8, 25}, new int[]{864, 6, 3},
                new int[]{1485, 2, 20}, new int[]{863, 12, 2}, new int[]{1486, 10, 11}, new int[]{865, 7, 19},
                new int[]{1486, 9, 12}, new int[]{865, 6, 21}, new int[]{1487, 2, 22}, new int[]{865, 12, 3},
                new int[]{1487, 1, 29}, new int[]{865, 11, 9}, new int[]{1488, 7, 20}, new int[]{867, 4, 30},
                new int[]{1488, 2, 11}, new int[]{866, 11, 22}, new int[]{1489, 1, 20}, new int[]{867, 11, 1},
                new int[]{1489, 9, 4}, new int[]{868, 6, 13}, new int[]{1490, 12, 25}, new int[]{869, 10, 4},
                new int[]{1490, 1, 31}, new int[]{868, 11, 11}, new int[]{1491, 12, 29}, new int[]{870, 10, 8},
                new int[]{1491, 11, 20}, new int[]{870, 8, 29}, new int[]{1492, 3, 26}, new int[]{871, 1, 7},
                new int[]{1492, 12, 2}, new int[]{871, 9, 12}, new int[]{1493, 11, 22}, new int[]{872, 9, 1},
                new int[]{1493, 5, 29}, new int[]{872, 3, 8}, new int[]{1494, 9, 1}, new int[]{873, 6, 10},
                new int[]{1494, 10, 12}, new int[]{873, 7, 20}, new int[]{1495, 6, 3}, new int[]{874, 3, 13},
                new int[]{1495, 11, 12}, new int[]{874, 8, 21}, new int[]{1496, 9, 9}, new int[]{875, 6, 19},
                new int[]{1496, 9, 4}, new int[]{875, 6, 14}, new int[]{1497, 6, 8}, new int[]{876, 3, 18},
                new int[]{1497, 7, 2}, new int[]{876, 4, 11}, new int[]{1498, 5, 9}, new int[]{877, 2, 19},
                new int[]{1498, 12, 6}, new int[]{877, 9, 15}, new int[]{1499, 12, 27}, new int[]{878, 10, 6},
                new int[]{1499, 9, 1}, new int[]{878, 6, 10}, new int[]{1500, 5, 8}, new int[]{879, 2, 18},
                new int[]{1500, 4, 7}, new int[]{879, 1, 18}, new int[]{1501, 5, 9}, new int[]{880, 2, 18},
                new int[]{1501, 12, 2}, new int[]{880, 9, 10}, new int[]{1502, 1, 15}, new int[]{880, 10, 24},
                new int[]{1502, 5, 2}, new int[]{881, 2, 11}, new int[]{1503, 4, 14}, new int[]{882, 1, 24},
                new int[]{1503, 4, 2}, new int[]{882, 1, 12}, new int[]{1504, 12, 2}, new int[]{883, 9, 11},
                new int[]{1504, 8, 17}, new int[]{883, 5, 26}, new int[]{1505, 12, 12}, new int[]{884, 9, 21},
                new int[]{1505, 9, 23}, new int[]{884, 7, 1}, new int[]{1506, 8, 24}, new int[]{885, 6, 1},
                new int[]{1506, 4, 10}, new int[]{885, 1, 20}, new int[]{1507, 8, 23}, new int[]{886, 5, 31},
                new int[]{1507, 10, 19}, new int[]{886, 7, 26}, new int[]{1508, 6, 15}, new int[]{887, 3, 25},
                new int[]{1508, 10, 28}, new int[]{887, 8, 6}, new int[]{1509, 1, 25}, new int[]{887, 11, 5},
                new int[]{1509, 7, 27}, new int[]{888, 5, 5}, new int[]{1510, 1, 2}, new int[]{888, 10, 12},
                new int[]{1510, 10, 12}, new int[]{889, 7, 19}, new int[]{1511, 1, 3}, new int[]{889, 10, 12},
                new int[]{1511, 8, 9}, new int[]{890, 5, 17}, new int[]{1512, 11, 12}, new int[]{891, 8, 21},
                new int[]{1512, 11, 28}, new int[]{891, 9, 7}, new int[]{1513, 11, 18}, new int[]{892, 8, 27},
                new int[]{1513, 7, 17}, new int[]{892, 4, 26}, new int[]{1514, 5, 25}, new int[]{893, 3, 3},
                new int[]{1514, 11, 5}, new int[]{893, 8, 13}, new int[]{1515, 10, 3}, new int[]{894, 7, 10},
                new int[]{1515, 2, 9}, new int[]{893, 11, 19}, new int[]{1516, 11, 9}, new int[]{895, 8, 18},
                new int[]{1516, 2, 17}, new int[]{894, 11, 27}, new int[]{1517, 8, 1}, new int[]{896, 5, 10},
                new int[]{1517, 6, 5}, new int[]{896, 3, 15}, new int[]{1518, 6, 13}, new int[]{897, 3, 22},
                new int[]{1518, 7, 21}, new int[]{897, 4, 29}, new int[]{1519, 12, 3}, new int[]{898, 9, 11},
                new int[]{1519, 12, 4}, new int[]{898, 9, 12}, new int[]{1520, 8, 23}, new int[]{899, 6, 1},
                new int[]{1520, 7, 14}, new int[]{899, 4, 23}, new int[]{1521, 7, 25}, new int[]{900, 5, 3},
                new int[]{1521, 1, 1}, new int[]{899, 10, 11}, new int[]{1522, 11, 10}, new int[]{901, 8, 18},
                new int[]{1522, 11, 14}, new int[]{901, 8, 22}, new int[]{1523, 9, 1}, new int[]{902, 6, 9},
                new int[]{1523, 6, 28}, new int[]{902, 4, 6}, new int[]{1524, 8, 3}, new int[]{903, 5, 12},
                new int[]{1524, 1, 23}, new int[]{902, 11, 2}, new int[]{1525, 12, 11}, new int[]{904, 9, 20},
                new int[]{1525, 12, 25}, new int[]{904, 10, 4}, new int[]{1526, 6, 1}, new int[]{905, 3, 10},
                new int[]{1526, 7, 12}, new int[]{905, 4, 20}, new int[]{1527, 8, 30}, new int[]{906, 6, 7},
                new int[]{1527, 2, 22}, new int[]{905, 12, 2}, new int[]{1528, 2, 14}, new int[]{906, 11, 24},
                new int[]{1528, 6, 25}, new int[]{907, 4, 4}, new int[]{1529, 6, 11}, new int[]{908, 3, 21},
                new int[]{1529, 5, 8}, new int[]{908, 2, 18}, new int[]{1530, 7, 24}, new int[]{909, 5, 1},
                new int[]{1530, 7, 16}, new int[]{909, 4, 24}, new int[]{1531, 1, 13}, new int[]{909, 10, 22},
                new int[]{1531, 12, 15}, new int[]{910, 9, 23}, new int[]{1532, 5, 16}, new int[]{911, 2, 26},
                new int[]{1532, 1, 7}, new int[]{910, 10, 16}, new int[]{1533, 8, 3}, new int[]{912, 5, 12},
                new int[]{1533, 10, 20}, new int[]{912, 7, 28}, new int[]{1534, 4, 30}, new int[]{913, 2, 9},
                new int[]{1534, 6, 20}, new int[]{913, 3, 29}, new int[]{1535, 2, 2}, new int[]{913, 11, 12},
                new int[]{1535, 7, 19}, new int[]{914, 4, 27}, new int[]{1536, 11, 21}, new int[]{915, 8, 30},
                new int[]{1536, 10, 7}, new int[]{915, 7, 15}, new int[]{1537, 2, 24}, new int[]{915, 12, 5},
                new int[]{1537, 6, 8}, new int[]{916, 3, 18}, new int[]{1538, 11, 16}, new int[]{917, 8, 25},
                new int[]{1538, 12, 25}, new int[]{917, 10, 4}, new int[]{1539, 10, 15}, new int[]{918, 7, 22},
                new int[]{1539, 2, 10}, new int[]{917, 11, 21}, new int[]{1540, 8, 17}, new int[]{919, 5, 26},
                new int[]{1540, 12, 8}, new int[]{919, 9, 17}, new int[]{1541, 7, 19}, new int[]{920, 4, 28},
                new int[]{1541, 7, 16}, new int[]{920, 4, 25}, new int[]{1542, 12, 23}, new int[]{921, 10, 2},
                new int[]{1542, 3, 13}, new int[]{920, 12, 22}, new int[]{1543, 10, 20}, new int[]{922, 7, 27},
                new int[]{1543, 7, 16}, new int[]{922, 4, 24}, new int[]{1544, 10, 26}, new int[]{923, 8, 4},
                new int[]{1544, 12, 31}, new int[]{923, 10, 10}, new int[]{1545, 2, 7}, new int[]{923, 11, 18},
                new int[]{1545, 3, 2}, new int[]{923, 12, 11}, new int[]{1546, 5, 15}, new int[]{925, 2, 25},
                new int[]{1546, 7, 14}, new int[]{925, 4, 23}, new int[]{1547, 10, 31}, new int[]{926, 8, 8},
                new int[]{1547, 10, 20}, new int[]{926, 7, 27}, new int[]{1548, 4, 19}, new int[]{927, 1, 30},
                new int[]{1548, 3, 6}, new int[]{926, 12, 15}, new int[]{1549, 7, 2}, new int[]{928, 4, 11},
                new int[]{1549, 4, 25}, new int[]{928, 2, 5}, new int[]{1550, 12, 13}, new int[]{929, 9, 22},
                new int[]{1550, 12, 3}, new int[]{929, 9, 12}, new int[]{1551, 8, 11}, new int[]{930, 5, 19},
                new int[]{1551, 5, 9}, new int[]{930, 2, 18}, new int[]{1552, 10, 18}, new int[]{931, 7, 26},
                new int[]{1552, 8, 23}, new int[]{931, 6, 1}, new int[]{1553, 5, 7}, new int[]{932, 2, 17},
                new int[]{1553, 7, 18}, new int[]{932, 4, 27}, new int[]{1554, 6, 23}, new int[]{933, 4, 2},
                new int[]{1554, 3, 13}, new int[]{932, 12, 22}, new int[]{1555, 12, 31}, new int[]{934, 10, 9},
                new int[]{1555, 10, 11}, new int[]{934, 7, 18}, new int[]{1556, 7, 4}, new int[]{935, 4, 13},
                new int[]{1556, 10, 9}, new int[]{935, 7, 17}, new int[]{1557, 11, 24}, new int[]{936, 9, 3},
                new int[]{1557, 5, 2}, new int[]{936, 2, 12}, new int[]{1558, 3, 15}, new int[]{936, 12, 24},
                new int[]{1558, 12, 2}, new int[]{937, 9, 11}, new int[]{1559, 11, 21}, new int[]{938, 8, 29},
                new int[]{1559, 6, 25}, new int[]{938, 4, 3}, new int[]{1560, 12, 30}, new int[]{939, 10, 9},
                new int[]{1560, 10, 20}, new int[]{939, 7, 28}, new int[]{1561, 4, 18}, new int[]{940, 1, 29},
                new int[]{1561, 11, 22}, new int[]{940, 9, 1}, new int[]{1562, 12, 28}, new int[]{941, 10, 7},
                new int[]{1562, 2, 2}, new int[]{940, 11, 13}, new int[]{1563, 9, 18}, new int[]{942, 6, 26},
                new int[]{1563, 11, 29}, new int[]{942, 9, 7}, new int[]{1564, 5, 12}, new int[]{943, 2, 22},
                new int[]{1564, 4, 21}, new int[]{943, 2, 1}, new int[]{1565, 2, 14}, new int[]{943, 11, 25},
                new int[]{1565, 6, 19}, new int[]{944, 3, 29}, new int[]{1566, 8, 18}, new int[]{945, 5, 27},
                new int[]{1566, 9, 22}, new int[]{945, 6, 31}, new int[]{1567, 7, 6}, new int[]{946, 4, 14},
                new int[]{1567, 6, 6}, new int[]{946, 3, 15}, new int[]{1568, 2, 12}, new int[]{946, 11, 22},
                new int[]{1568, 2, 8}, new int[]{946, 11, 18}, new int[]{1569, 5, 23}, new int[]{948, 3, 2},
                new int[]{1569, 5, 8}, new int[]{948, 2, 18}, new int[]{1570, 4, 3}, new int[]{949, 1, 14},
                new int[]{1570, 3, 9}, new int[]{948, 12, 18}, new int[]{1571, 10, 30}, new int[]{950, 8, 8},
                new int[]{1571, 11, 2}, new int[]{950, 8, 11}, new int[]{1572, 8, 31}, new int[]{951, 6, 9},
                new int[]{1572, 5, 21}, new int[]{951, 2, 31}, new int[]{1573, 7, 19}, new int[]{952, 4, 28},
                new int[]{1573, 9, 24}, new int[]{952, 7, 2}, new int[]{1574, 3, 29}, new int[]{953, 1, 9},
                new int[]{1574, 7, 15}, new int[]{953, 4, 24}, new int[]{1575, 7, 4}, new int[]{954, 4, 13},
                new int[]{1575, 9, 24}, new int[]{954, 7, 2}, new int[]{1576, 12, 25}, new int[]{955, 10, 4},
                new int[]{1576, 4, 21}, new int[]{955, 2, 1}, new int[]{1577, 11, 10}, new int[]{956, 8, 19},
                new int[]{1577, 4, 7}, new int[]{956, 1, 18}, new int[]{1578, 8, 20}, new int[]{957, 5, 29},
                new int[]{1578, 2, 1}, new int[]{956, 11, 12}, new int[]{1579, 4, 11}, new int[]{958, 1, 22},
                new int[]{1579, 4, 1}, new int[]{958, 1, 12}, new int[]{1580, 2, 16}, new int[]{958, 11, 27},
                new int[]{1580, 10, 24}, new int[]{959, 8, 2}, new int[]{1581, 9, 18}, new int[]{960, 6, 27},
                new int[]{1581, 11, 29}, new int[]{960, 9, 8}, new int[]{1582, 10, 15}, new int[]{961, 7, 23},
                new int[]{1582, 5, 29}, new int[]{961, 3, 8}, new int[]{1583, 6, 18}, new int[]{962, 3, 28},
                new int[]{1583, 8, 12}, new int[]{962, 5, 21}, new int[]{1584, 9, 7}, new int[]{963, 6, 16},
                new int[]{1584, 4, 12}, new int[]{963, 1, 23}, new int[]{1585, 5, 3}, new int[]{964, 2, 13},
                new int[]{1585, 6, 27}, new int[]{964, 4, 6}, new int[]{1586, 3, 20}, new int[]{964, 12, 29},
                new int[]{1586, 7, 12}, new int[]{965, 4, 21}, new int[]{1587, 8, 20}, new int[]{966, 5, 29},
                new int[]{1587, 10, 10}, new int[]{966, 7, 18}, new int[]{1588, 6, 2}, new int[]{967, 3, 12},
                new int[]{1588, 5, 10}, new int[]{967, 2, 20}, new int[]{1589, 4, 1}, new int[]{968, 1, 12},
                new int[]{1589, 8, 3}, new int[]{968, 5, 12}, new int[]{1590, 4, 27}, new int[]{969, 2, 7},
                new int[]{1590, 11, 30}, new int[]{969, 9, 9}, new int[]{1591, 7, 29}, new int[]{970, 5, 7},
                new int[]{1591, 8, 8}, new int[]{970, 5, 17}, new int[]{1592, 7, 10}, new int[]{971, 4, 19},
                new int[]{1592, 3, 18}, new int[]{970, 12, 28}, new int[]{1593, 3, 13}, new int[]{971, 12, 22},
                new int[]{1593, 11, 27}, new int[]{972, 9, 6}, new int[]{1594, 1, 30}, new int[]{972, 11, 10},
                new int[]{1594, 9, 16}, new int[]{973, 6, 25}, new int[]{1595, 4, 23}, new int[]{974, 2, 3},
                new int[]{1595, 6, 27}, new int[]{974, 4, 6}, new int[]{1596, 11, 21}, new int[]{975, 8, 30},
                new int[]{1596, 4, 19}, new int[]{975, 1, 30}, new int[]{1597, 2, 15}, new int[]{975, 11, 26},
                new int[]{1597, 1, 13}, new int[]{975, 10, 23}, new int[]{1598, 6, 2}, new int[]{977, 3, 12},
                new int[]{1598, 11, 15}, new int[]{977, 8, 24}, new int[]{1599, 5, 7}, new int[]{978, 2, 17},
                new int[]{1599, 4, 7}, new int[]{978, 1, 18},


        };
        for (int x = 0; x < datesAndExpectedConversions.length; ) {
            int[] date = datesAndExpectedConversions[x++];
            int[] expectedConversion = datesAndExpectedConversions[x++];
            int[] conversion = DateConverter.convertGregorianToPersian(date);
            assertEquals(expectedConversion, conversion);
        }
    }

    public static void test_brute_force_1() {
        //we basically check that for each 1 day increment in gregorian calendar, the conversion also increases by 1 day.
        int current = 0;
        for (int year = 623; year != 2000; year++) {
            for (int month = 1; month != 13; month++) {
                for (int day = 1; day <= DateConverter.getDaysOfMonthGregorian(year, month); day++) {
                    int[] conversion = DateConverter.convertGregorianToPersian(year, month, day);
                    int no = DateConverter.countPersianDaysSinceTheStartOfTheCalendar(conversion[0], conversion[1], conversion[2]);
                    if (current != 0) assertEquals(no, ++current);
                    current = no;
                }
            }
        }
    }

    /*
     * This is another brute force internal-consistency check. every date->millis must also be millis->date
     * */

    public static void test_brute_force_2() {
        //this test right here caused a lot of headache as it was written with java.calendar before.

        // java.calendar had 2 severe bugs:
        // GregorianCalendar would consider years like 700 or 500 a leap year. which are not leap years in
        // gregorian calendar but are in julian calendar.

        // GregorianCalendar would move from 1582/10/04 to 1582/10/15. 4th october was in julian calendar then they
        // switched to GregorianCalendar. it is not a jump, but a shift of all previous historical events and dates.
        // for example, 10th of october 1582 exists in gregorian calendar, and in julian calendar, but the julian did not make it!

        // I switched to java.time and this test passes with no patches
        LocalDateTime calendar = LocalDateTime.of(622, 3, 22, 0, 0, 0);
        for (int year = 1; year != 3000; year++) {
            for (int month = 1; month != 13; month++) {
                for (int day = 1; day <= DateConverter.getDaysOfMonthPersian(year, month); day++) {
                    int[] date = new int[]{year, month, day};
                    int[] conversion = DateConverter.convertGregorianToPersian(calendar.getYear(), calendar.getMonthValue(), calendar.getDayOfMonth());
                    assertEquals(conversion, date);
                    calendar = calendar.plusDays(1);

                    assertEquals(DateConverter.addDaysToPersianDate(new int[]{1, 1, 1},
                                    DateConverter.countPersianDaysSinceTheStartOfTheCalendar(date) - 1),
                            date);
                }
            }
        }

    }

    public static void test_millis_conversion() {
        for (int year = 623; year != LeapYearsCalculator.MAX_SUPPORTED_GREGORIAN_YEAR; year++) {
            for (int month = 1; month != 13; month++) {
                for (int day = 1; day <= DateConverter.getDaysOfMonthGregorian(year, month); day++) {
                    LocalDateTime localDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);
                    Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
                    long gregorian = instant.toEpochMilli();
                    int[] persianDateTimConversion = DateConverter.convertMillisToPersianDateTime(gregorian);
                    int[] expectedConversion = DateConverter.convertGregorianToPersian(new int[]{year, month, day});
                    long persian = DateConverter.convertPersianToMillis(persianDateTimConversion);
                    if (gregorian - persian != 0) {
                        //going to fail... log everything
                        long diff = (gregorian - persian) / (24 * 3600 * 1000);
                        Utils.print(localDateTime, expectedConversion, " but: ", persianDateTimConversion, gregorian, persian, diff);
                    }
                    assertEquals(gregorian, persian);
                }
            }
        }
    }

    public static void add_days_function() {
        int[][] values = new int[][]{
                new int[]{1, 1, 1}, new int[]{1}, new int[]{1, 1, 2},
                new int[]{1, 1, 1}, new int[]{31}, new int[]{1, 2, 1},
                new int[]{1, 1, 31}, new int[]{1}, new int[]{1, 2, 1},
                new int[]{1403, 12, 29}, new int[]{1}, new int[]{1403, 12, 30},
                new int[]{1403, 12, 30}, new int[]{1}, new int[]{1404, 1, 1},
                new int[]{1, 1, 1}, new int[]{365}, new int[]{2, 1, 1},
                new int[]{1, 1, 1}, new int[]{366}, new int[]{2, 1, 2},
        };
        for (int x = 0; x != values.length; ) {
            int[] date = values[x++];
            int add = values[x++][0];
            int[] expectedResult = values[x++];
            int[] result = DateConverter.addDaysToPersianDate(date, add);
            assertEquals(result, expectedResult);

            int[] negativeCaseResult = DateConverter.addDaysToPersianDate(expectedResult, -add);
            assertEquals(negativeCaseResult, date);
        }
    }

    public static void add_months_function() {
        int[][] values = new int[][]{
                new int[]{1, 1, 1}, new int[]{1}, new int[]{1, 2, 1},
                new int[]{1, 1, 1}, new int[]{12}, new int[]{2, 1, 1},
                new int[]{1, 1, 1}, new int[]{24}, new int[]{3, 1, 1},
                new int[]{2, 12, 5}, new int[]{1}, new int[]{3, 1, 5},
                new int[]{1403, 12, 5}, new int[]{1}, new int[]{1404, 1, 5},
        };
        for (int x = 0; x != values.length; ) {
            int[] date = values[x++];
            int add = values[x++][0];
            int[] expectedResult = values[x++];
            int[] result = DateConverter.addMonthsToPersianDate(date, add);
            assertEquals(result, expectedResult);

            int[] negativeCaseResult = DateConverter.addMonthsToPersianDate(expectedResult, -add);
            assertEquals(negativeCaseResult, date);
        }
    }

    public static void test_dates_difference_calculation() {
        int[][][] datesAddsAndExpectedConversions = new int[][][]{
                new int[][]{new int[]{1403, 1, 1}, new int[]{1402, 12, 29}, new int[]{0, 0, 2}},
                new int[][]{new int[]{1403, 1, 1}, new int[]{1404, 1, 1}, new int[]{-1, 0, 0}},
                new int[][]{new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{-1, -2, -4}},
                new int[][]{new int[]{2, 3, 4}, new int[]{1, 1, 1}, new int[]{1, 2, 4}},
                new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}},
                new int[][]{new int[]{1403, 1, 1}, new int[]{1, 1, 1}, new int[]{1402, 0, 0}},
        };
    }

    /*
     * This is the reverse mode of the above test
     * */
    public static void test_millis_conversion_2() {
        for (int year = 1; year != 3000; year++) {
            for (int month = 1; month != 13; month++) {
                for (int day = 1; day <= DateConverter.getDaysOfMonthPersian(year, month); day++) {
                    int[] date = new int[]{year, month, day};
                    long epochMillis = DateConverter.convertPersianToMillis(new int[]{year, month, day, 0, 0, 0, 0});
                    Instant instant = Instant.ofEpochMilli(epochMillis);
                    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                    int[] converted2 = DateConverter.convertGregorianToPersian(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
                    assertEquals(converted2, date);
                }
            }
        }
    }

    public static int[] getRandomGregorianDate() {
        int year = getRandomYear(), month = getRandomMonth();
        return new int[]{year, month, getRandomDay(year, month)};
    }

    public static int getRandomYear() {
        int min = 623;
        return min + random.nextInt(LeapYearsCalculator.MAX_SUPPORTED_GREGORIAN_YEAR - min);
    }

    public static int getRandomMonth() {
        return random.nextInt(12) + 1;
    }

    public static int getRandomDay(int year, int month) {
        return random.nextInt(DateConverter.getDaysOfMonthGregorian(year, month)) + 1;
    }


    @ThisTestOnly
    public static void test_get_day_of_week(){
        assertEquals(6,DateConverter.getDayOfWeek(1,1,1));
        assertEquals(0,DateConverter.getDayOfWeek(1,1,2));
        assertEquals(1,DateConverter.getDayOfWeek(1,1,3));
        assertEquals(2,DateConverter.getDayOfWeek(1,1,4));
        assertEquals(3,DateConverter.getDayOfWeek(1,1,5));
        assertEquals(4,DateConverter.getDayOfWeek(1,1,6));
        assertEquals(5,DateConverter.getDayOfWeek(1,1,7));
        assertEquals(6,DateConverter.getDayOfWeek(1,1,8));
        assertEquals(0,DateConverter.getDayOfWeek(1,1,9));
        assertEquals(1,DateConverter.getDayOfWeek(1403,4,31));
        assertEquals(0,DateConverter.getDayOfWeek(1403,4,30));
        assertEquals(6,DateConverter.getDayOfWeek(1403,4,29));
        assertEquals(5,DateConverter.getDayOfWeek(1403,4,28));
        assertEquals(4,DateConverter.getDayOfWeek(1403,4,27));
        assertEquals(3,DateConverter.getDayOfWeek(1403,4,26));
        assertEquals(2,DateConverter.getDayOfWeek(1403,4,25));
        assertEquals(1,DateConverter.getDayOfWeek(1403,4,24));
        assertEquals(0,DateConverter.getDayOfWeek(1403,4,23));
    }
}
