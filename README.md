# Persian-Date-Java
An easy-to-use and accurate Persian-Gregorian date converter written in java.

Jalali / Shamsi / Persian / Iranian calendar is the official calendar used in iran which is considered by many to be the most accurate calendar in the world.


## Examples

`PersianCalendar calendar = new PersianCalendar(0) //millis`

`PersianCalendar calendar = new PersianCalendar(1403,4,29) //date`

`calendar.getStartOfTheNextMonth() //easily access common dates` 

`calendar.getYear()` 

`calendar.toStringDateYYYYMMDD() //returns formatted date`



## Why this code?

#### 1. it is accurate in a wide range (from the start of the persian calendar to its 3000th year )

#### 2. does not rely on invalid formulas to determine persian leap years (unlike most libraries)

#### 3. handles the 1582 time travel incident properly (unlike java.calendar)

#### 4. uses efficient calculations (preferring pre-determined low-calculation methods)

#### 5. is tested automatically with unit tests

#### 6. has zero dependencies and is pure java

#### 7. can be used in all android versions 


this code is not intended to be used for dates out of its supported range

Developed by Amin Sarabi at 2024/7/14