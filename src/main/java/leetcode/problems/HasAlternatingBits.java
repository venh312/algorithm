package leetcode.problems;

/*
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101

Example 2:
Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.

Example 3:
Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.
*/
class HasAlternatingBits {
    // Runtime: 0 ms, faster than 100.00%
    public boolean hasAlternatingBits(int n) {
        // 비트를 오른쪽으로 한 칸씩 이동하면서 이전 비트와 현재 비트를 비교
        int prevBit = n & 1;  // n의 가장 오른쪽 비트
        n >>= 1;  // n을 오른쪽으로 한 칸 이동

        while (n > 0) {
            int currentBit = n & 1;  // 현재 비트
            if (currentBit == prevBit) {
                return false;  // 인접한 비트가 같으면 false 반환
            }
            prevBit = currentBit;  // 이전 비트 업데이트
            n >>= 1;  // n을 오른쪽으로 한 칸 이동
        }

        return true;  // 모든 비트가 alternating인 경우 true 반환
    }
}
