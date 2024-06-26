package leetcode.problems;

/*
Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

Example 2:
Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
*/
class CountBinarySubstrings {
    // Runtime: 10 ms, faster than 83.29%
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevLength = 0;
        int currLength = 1;


        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLength++;
            } else {
                count += Math.min(prevLength, currLength);
                prevLength = currLength;
                currLength = 1;
            }
        }

        count += Math.min(prevLength, currLength);

        return count;
    }
}
