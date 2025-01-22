/*
https://leetcode.com/problems/find-the-duplicate-number/description/

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
*/
public class FindDeuplicate {
    public int findDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int num : nums) {
            if (!uniqueNums.add(num)) return num;
        }

        return -1;
    }

    public int findDuplicateGPT(int[] nums) {
        // 사이클 탐지를 위한 slow와 fast 포인터 초기화
        int slow = nums[0];
        int fast = nums[0];

        // 사이클 존재 여부 확인 (토끼와 거북이 접근법)
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 사이클의 시작 지점을 찾기
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // 사이클의 시작 지점(즉, 중복된 숫자)을 반환
        return slow;
    }
}
