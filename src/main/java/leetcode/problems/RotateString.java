package leetcode.problems;

/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:
Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:
Input: s = "abcde", goal = "abced"
Output: false
*/
class RotateString {
    // Runtime: 3 ms, faster than 8.32%
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        
        String[] sArr = s.split("");
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = sArr.length-1; i >=0; i--) {
            sb.insert(0, sArr[i]);
            String subStr = sb.substring(0, sArr.length);
            //System.out.println(subStr);
            if (subStr.equals(goal)) return true;
        }
        
        return false;
    }

    // Runtime: 0 ms, faster than 100.00%
    public boolean rotateString2(String s, String goal) {
        // Check if both strings have the same length
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself (e.g., s = "abcde" -> doubledS = "abcdeabcde")
        String doubledS = s + s;
        
        // Check if goal is a substring of doubledS
        return doubledS.contains(goal);
    }
}
