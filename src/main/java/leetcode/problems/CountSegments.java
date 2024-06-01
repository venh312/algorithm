package leetcode.problems;
/*
Given a string s, return the number of segments in the string.

A segment is defined to be a contiguous sequence of non-space characters.

Example 1:
Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]

Example 2:
Input: s = "Hello"
Output: 1
*/
class CountSegments {
    // Runtime: 0 ms, faster than 100.00%
    public int countSegments(String s) {
        if (s.isEmpty()) return 0;
        String[] arr = s.split(" ");
        int count = 0;
        for (String str : arr) {
            if (!str.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
