import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

Example 1:
Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.

Example 2:
Input: date = "2019-02-10"
Output: 41
*/
class DayOfYear {
    public int dayOfYear(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(date, formatter);
    return localDate.getDayOfYear();
    }
}
