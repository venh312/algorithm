package leetcode.problems;

/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:
Input: n = 2
Output: false
*/
public class IsHappy {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        while (n != 1) {
            String stringVal = String.valueOf(n); // 2
            int sum = 0;
            for (int i = 0; i < stringVal.length(); i++) {
                int value = stringVal.charAt(i) - '0';
                sum += value * value; // 4
            }
            if (sum == 1) return true;
            else if (sum == 4) return false;
            n = sum;
        }
        return false;
    }
}
