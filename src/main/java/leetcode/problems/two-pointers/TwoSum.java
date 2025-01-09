/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
*/
class TwoSum {
  
    // 정답은 맞으나, 시간 초과
    public int[] twoSumTimeLimit(int[] numbers, int target) {
        int[] result = new int[2];
     
        boolean flag = false;
        for (int i = 0; i < numbers.length && !flag; i++) {
            for (int k = i+1; k < numbers.length; k++) {
                if ((numbers[i] + numbers[k]) == target) {
                    result[0] = i+1;
                    result[1] = k+1;
                    flag = true;
                    break;
                }
            }
        }
    
        return result;
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}
