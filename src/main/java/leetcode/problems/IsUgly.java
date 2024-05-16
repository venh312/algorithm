public leetcode.problems;
/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return true if n is an ugly number.

Example 1:
Input: n = 6
Output: true
Explanation: 6 = 2 × 3

Example 2:
Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

Example 3:
Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.
*/
class IsUgly {
    /*
    주어진 문제는 주어진 정수 n이 ugly number인지 확인하는 것입니다.
    ugly number는 소인수가 2, 3, 5로만 구성된 양의 정수를 의미합니다.
    즉, 주어진 숫자를 2, 3, 5로 나누어 최종적으로 1이 되는지 확인하면 됩니다.

    기본 조건: n이 1이면 true를 반환합니다. 1은 소인수가 없기 때문에 기본적으로 ugly number로 간주됩니다.
    음수 처리: n이 1보다 작으면 false를 반환합니다. ugly number는 양의 정수만 해당되기 때문입니다.
    반복적으로 나누기: n을 반복적으로 2, 3, 5로 나누면서 나눌 수 있을 만큼 나눕니다.
    최종 결과 확인: 최종적으로 n이 1이면 true, 그렇지 않으면 false를 반환합니다.
    예를 들어, 주어진 숫자 n이 30이라면 다음과 같이 처리할 수 있습니다:

    30은 2로 나누어 15가 됩니다.
    15는 3으로 나누어 5가 됩니다.
    5는 5로 나누어 1이 됩니다.
    최종적으로 1이 되었으므로 30은 ugly number입니다.
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        
        return n == 1;
    }
}
