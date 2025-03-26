/*
https://leetcode.com/problems/maximum-subarray/description/
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
1 <= nums.length <= 105
  -104 <= nums[i] <= 104
*/
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0]; // 현재 인덱스까지의 합
    int maxSum = nums[0];     // 지금까지의 최대 부분합

    for (int i = 1; i < nums.length; i++) {
        // 이전 합에 더하는 것이 좋은지, 새로 시작하는 것이 좋은지 비교
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
    }
}
