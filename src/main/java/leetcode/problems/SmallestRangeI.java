package leetcode.problems;

/*
You are given an integer array nums and an integer k.

In one operation, you can choose any index i where 0 <= i < nums.length
and change nums[i] to nums[i] + x where x is an integer from the range [-k, k].
You can apply this operation at most once for each index i.

The score of nums is the difference between the maximum and minimum elements in nums.

Return the minimum score of nums after applying the mentioned operation at most once for each index in it.

Example 1:
Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.

Example 2:
Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.

Example 3:
Input: nums = [1,3,6], k = 3
Output: 0
Explanation: Change nums to be [4, 4, 4]. The score is max(nums) - min(nums) = 4 - 4 = 0.
*/
class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        // 배열이 비어있거나 길이가 1인 경우 점수는 0입니다.
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 0;

        // 배열의 최대값과 최소값을 찾습니다.
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < minNum) minNum = num;
            if (num > maxNum) maxNum = num;
        }

        // 가능한 새로운 최소값과 최대값을 계산합니다.
        int newMin = minNum + k;
        int newMax = maxNum - k;

        // 점수는 새로운 최대값과 최소값의 차이입니다.
        return Math.max(0, newMax - newMin);
    }
}
