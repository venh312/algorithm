package leetcode.problems;

/*
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:
Input: nums = [1,2,2,3]
Output: true

Example 2:
Input: nums = [6,5,4,4]
Output: true

Example 3:
Input: nums = [1,3,2]
Output: false
*/
class IsMonotonic {
    public boolean isMonotonic(int[] nums) {
        return isIncreasing(nums) || isDecreasing(nums);
    }

    public boolean isIncreasing(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

        public boolean isDecreasing(int[] nums) {
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }
}
