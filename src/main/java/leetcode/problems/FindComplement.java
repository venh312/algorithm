package leetcode.problems;

/*
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

Example 1:
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
*/
class FindComplement {
    /*
    Integer.highestOneBit(num)은 num의 이진수 표현에서 가장 높은 비트 위치를 1로 설정한 값을 반환합니다.
    Integer.highestOneBit(num) << 1은 가장 높은 비트 위치보다 하나 높은 위치를 1로 설정한 값을 반환합니다.
    ((Integer.highestOneBit(num) << 1) - 1)은 주어진 정수의 비트 길이만큼의 모든 비트를 1로 설정한 마스크를 생성합니다.
    num ^ mask는 num의 모든 비트를 반전시킵니다.
    */
    // Runtime: 0 ms, faster than 100.00%
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1)-1;
        return num ^ mask;
    }
    
    // highestOneBit 함수 사용하지 않는 풀이
    public static int findComplement2(int num) {
        int bitLength = 0;
        int temp = num;
        while (temp > 0) {
            bitLength++;
            temp >>= 1;
        }

        int mask = (1 << bitLength) - 1;

        return num ^ mask;
    }
}
