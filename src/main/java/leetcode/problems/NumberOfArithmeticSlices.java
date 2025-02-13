/*
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

Example 2:
Input: nums = [1]
Output: 0
*/
class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0; // 최소 길이 미달 시 등차수열 없음

        int count = 0;  // 등차수열 개수 누적
        int dp = 0; // 현재까지 등차수열을 만들 수 있는 개수

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) { 
                dp += 1;  // 등차수열 추가
                count += dp; // 전체 개수에 누적
            } else {
                dp = 0;  // 연속되지 않으면 초기화
            }
        }

        return count;
    }
}
