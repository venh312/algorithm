package leetcode.problems;

/*
We have two special characters:

The first character can be represented by one bit 0.
The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.

Example 1:
Input: bits = [1,0,0]
Output: true
Explanation: The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.

Example 2:
Input: bits = [1,1,1,0]
Output: false
Explanation: The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character.
*/
class IsOneBitCharacter {
    // Runtime: 0 ms, faster than 100.00
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                // 2비트 문자 (10 또는 11)인 경우
                i += 2;
            } else {
                // 1비트 문자 (0)인 경우
                i += 1;
            }
        }
        // 마지막 위치가 배열의 끝 바로 앞인지 확인
        return i == bits.length - 1;
    }
}
