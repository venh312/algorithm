package leetcode.problems;

/*
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:
Input: s = "Hello"
Output: "hello"

Example 2:
Input: s = "here"
Output: "here"

Example 3:
Input: s = "LOVELY"
Output: "lovely"
*/
class ToLowerCase {
    // Runtime: 0 ms, faster than 100.00%
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char lowcase  = (char) (c + 32);
            if (c > 64 && c < 91) {
                sb.append(lowcase);
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
