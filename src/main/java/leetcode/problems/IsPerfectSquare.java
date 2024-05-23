package leetcode.problems;
/*
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.

Example 1:
Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

Example 2:
Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

Result:
Runtime: 0 ms, faster than 100.00% 

주어진 숫자가 완전 제곱수인지 확인하는 문제
long을 사용한 이유는 mid * mid 계산 시 정수 오버플로우를 피하기 위함
*/
class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        
        long left = 1, right = num;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
 
}
