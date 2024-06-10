package leetcode.problems;

/*
Given an integer num, return a string of its base 7 representation.

Example 1:
Input: num = 100
Output: "202"

Example 2:
Input: num = -7
Output: "-10"
*/
class ConvertToBase7 {
  // Runtime: 1 ms, faster than 60.58%
  public String convertToBase7(int num) {
      if (num == 0) return "0";

      StringBuilder result = new StringBuilder();
      boolean isNegative = false;
      if (num < 0) {
          isNegative = true;
          num = -num;
      }

      while (num > 0) {
          int digit = num % 7;
          result.insert(0, digit);
          num /= 7;
      }

      if (isNegative) {
          result.insert(0, '-');
      }

      return result.toString();
  }
}
