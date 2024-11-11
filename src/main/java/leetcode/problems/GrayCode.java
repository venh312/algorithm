/* 89. Gray Code
https://leetcode.com/problems/gray-code/

An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],

The first integer is 0,

An integer appears no more than once in the sequence,

The binary representation of every pair of adjacent integers differs by exactly one bit,

and The binary representation of the first and last integers differs by exactly one bit.

Given an integer n, return any valid n-bit gray code sequence.

Example 1:
Input: n = 2
Output: [0,1,3,2]
Explanation:
The binary representation of [0,1,3,2] is [00,01,11,10].
- 00 and 01 differ by one bit
- 01 and 11 differ by one bit
- 11 and 10 differ by one bit
- 10 and 00 differ by one bit
[0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
- 00 and 10 differ by one bit
- 10 and 11 differ by one bit
- 11 and 01 differ by one bit
- 01 and 00 differ by one bit

Example 2:
Input: n = 1
Output: [0,1]
 */
class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);  // Gray Code 시퀀스의 첫 번째 숫자는 항상 0입니다.

        // Gray Code 생성 과정
        for (int i = 0; i < n; i++) {
            int currentSize = result.size();
            // 현재 크기의 시퀀스에 대해서, 각 숫자에 1을 앞에 붙인 새로운 숫자들을 생성
            for (int j = currentSize - 1; j >= 0; j--) {
                result.add(result.get(j) | (1 << i));  // 현재 숫자에 2^i을 더하여 1을 추가
            }
        }
        
        return result;
    }
}
