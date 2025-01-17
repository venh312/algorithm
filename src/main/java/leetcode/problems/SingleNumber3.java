/*
https://leetcode.com/problems/single-number-ii/description/

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99
*/
class SingleNumber3 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 숫자의 빈도 계산
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 빈도가 1인 숫자 반환
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // 기본 반환값 (문제 조건 상 도달하지 않음)
        return -1;
    }

    public int singleNumberGPT(int[] nums) {
        int ones = 0, twos = 0;
    
        for (int num : nums) {
            ones = (ones ^ num) & ~twos; // 현재 비트가 1번 등장한 경우
            twos = (twos ^ num) & ~ones; // 현재 비트가 2번 등장한 경우
        }
    
        return ones; // 최종적으로 ones에 고유한 숫자가 남는다.
    }
}
