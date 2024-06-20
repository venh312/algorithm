package leetcode.problems;

/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000
*/
class FindMaxAverage {
    // // Runtime: 4 ms, faster than 66.37%
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        // 처음 k개 요소의 합을 계산합니다.
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        // 초기 maxSum은 처음 k개 요소의 합으로 설정합니다.
        double maxSum = currentSum;

        // 배열을 순회하면서 최대 평균값을 가진 k 길이의 부분 배열을 찾습니다.
        for (int i = k; i < n; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        // 최대 평균값을 반환합니다.
        return maxSum / k;
    }
}
