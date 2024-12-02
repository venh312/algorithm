/*
https://leetcode.com/problems/count-and-say/submissions/

카운트 앤 세이 시퀀스는 재귀 공식으로 정의되는 숫자 문자열 시퀀스입니다:
카운트 AndSay(1) = "1"
countAndSay(n)는 countAndSay(n - 1)의 실행 길이 인코딩입니다.
실행 길이 인코딩(RLE)은 연속된 동일한 문자(2회 이상 반복)를 문자와 문자 수를 표시하는 숫자(실행 길이)의 연결로 대체하여 작동하는 문자열 압축 방법입니다.
예를 들어, 문자열 "3322251"을 "23"으로 대체하고, "222"를 "32"로 대체하고, "5"를 "15"로 대체하고, "1"을 "11"로 대체합니다. 따라서 압축된 문자열은 "23321511"이 됩니다.
양의 정수 n이 주어지면 카운트 앤 세이 시퀀스의 n번째 요소를 반환합니다.

Input: n = 4
Output: "1211"
Input: n = 1
Output: "1"

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times)
with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251"
we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.
 */
class CountAndSay {
     public String countAndSay(int n) {
        if (n <= 0) return "";

        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = rle(result);
        }

        return result;
    }

    String rle(String current) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < current.length(); i++) {
            if (current.charAt(i-1) == current.charAt(i)) {
                count++;
            } else {
                result.append(count).append(current.charAt(i-1));
                count = 1;
            }
        }

        result.append(count).append(current.charAt(current.length() - 1));

        return result.toString();
    }
}
