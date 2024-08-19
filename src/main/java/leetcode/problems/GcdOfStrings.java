package leetcode.problems;
/*
For two strings s and t, we say "t divides s"
if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
*/
class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int largestStringIndex = gcd(str1, str2);
        String largestString  = str2.substring(0, largestStringIndex);
        str1 = str1.replace(largestString, "");
        str2 = str2.replace(largestString, "");
        return str1.length() == 0 && str2.length() == 0 ? largestString : "";
    }

    public int gcd(String str1, String str2) {
        if (str1.length() % str2.length() == 0) {
            return str2.length();
        }
        return gcd(str2, str1.substring(0, str1.length() % str2.length()));
    }
}
