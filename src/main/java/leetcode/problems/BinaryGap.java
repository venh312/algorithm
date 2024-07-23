package leetcode.problems;

/*
Given a positive integer n,
find and return the longest distance between
any two adjacent 1's in the binary representation of n.
If there are no two adjacent 1's, return 0.

양의 정수 n이 주어지면,
사이의 가장 먼 거리를 찾아서 반환합니다
n의 이진법 표현에서 임의의 2개의 인접한 1들.
인접한 2개의 1이 없으면 0을 반환합니다

Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
The distance between two 1's is the absolute difference between their bit positions.
For example, the two 1's in "1001" have a distance of 3.
두 개의 1은 분리되는 0만 있으면 인접합니다(0이 없을 수도 있습니다).
2개의 1 사이의 거리는 비트 위치 간의 절대적인 차이입니다.
예를 들어, "1001"에 있는 두 개의 1은 3의 거리를 갖습니다.

Example 1:
Input: n = 22
Output: 2
Explanation: 22 in binary is "10110".
The first adjacent pair of 1's is "10110" with a distance of 2.
The second adjacent pair of 1's is "10110" with a distance of 1.
The answer is the largest of these two distances, which is 2.
Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.

Example 2:
Input: n = 8
Output: 0
Explanation: 8 in binary is "1000".
There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.

Example 3:
Input: n = 5
Output: 2
Explanation: 5 in binary is "101".
*/
class BinaryGap {
  public int binaryGap(int n) {
      String binary = Integer.toBinaryString(n);
      int result = 0;
      int prev = -1;
      for (int i = 0; i < binary.length(); i++) {
          if (prev == -1 && binary.charAt(i) == '1') {
              prev = i;
          } else if (binary.charAt(i) == '1') {
              result = Math.max(result, Math.abs(prev - i));
              prev = i;
          }
      }
      return result;
  }
}
