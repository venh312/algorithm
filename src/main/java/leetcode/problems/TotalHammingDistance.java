/*
https://leetcode.com/problems/total-hamming-distance/description/

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

두 정수 사이의 해밍 거리는 해당 비트가 서로 다른 위치의 수입니다.
정수 배열 숫자가 주어졌을 때, 모든 정수 쌍 사이의 해밍 거리의 합을 숫자로 반환하세요.

Example 1:
Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 */
class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;

        for (int i = 0; i < 32; i++) {
            int bitCount = 0;

            for (int num : nums) {
                bitCount += (num >> i) & 1; // i번째 비트가 1이면 1 더함
            }

            total += bitCount * (n - bitCount);
        }

        return total;
    }
}
