/*
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

Example 2:
Input: num = 0
Output: 0
*/
class AddDigits {
    /*
    디지털 루트 공식 설명
    디지털 루트는 수학적으로 주어진 숫자 num의 모든 자릿수를 더한 결과입니다.
    0이 아닌 숫자의 경우, num을 9로 나눈 나머지는 그 숫자의 디지털 루트와 관련이 있습니다.
    수학적으로, num의 디지털 루트는 1 + (num - 1) % 9로 표현될 수 있습니다. 이 공식을 사용하면 한 자리 숫자를 얻기 위해 반복적으로 자릿수를 더하는 과정을 생략할 수 있습니다.
    이 방법은 매우 효율적이며, 주어진 문제를 O(1) 시간 복잡도로 해결할 수 있습니다.
    */
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else {
            return 1 + (num - 1) % 9;
        }
    }
}
