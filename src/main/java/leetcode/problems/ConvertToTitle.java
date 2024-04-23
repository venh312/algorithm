package leetcode.problems;

/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 
Example 1:
Input: columnNumber = 1
Output: "A"
*/
class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // 현재 숫자를 26으로 나눈 나머지를 구합니다.
            int remainder = (columnNumber - 1) % 26;

            // 나머지에 해당하는 문자를 StringBuilder에 추가합니다.
            result.insert(0, (char) ('A' + remainder));

            // 다음 자리를 계산하기 위해 현재 숫자를 26으로 나눈 몫을 구합니다.
            columnNumber = (columnNumber - 1) / 26;
        }

        return result.toString();
    }
}
