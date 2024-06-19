package leetcode.problems;

/*
Given an integer array nums, find three numbers whose product is maximum and
return the maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6

Example 2:
Input: nums = [1,2,3,4]
Output: 24

Example 3:
Input: nums = [-1,-2,-3]
Output: -6
*/
public class MaximumProduct {
    // Runtime: 15 ms, faster than 5.10%
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // 두 가지 가능한 최대 곱 계산:
        // 1. 정렬 후 마지막 세 숫자의 곱
        // 2. 정렬 후 처음 두 숫자와 마지막 숫자의 곱
        int max1 = nums[n-1] * nums[n-2] * nums[n-3];
        int max2 = nums[0] * nums[1] * nums[n-1];

        return Math.max(max1, max2);
    }
}
