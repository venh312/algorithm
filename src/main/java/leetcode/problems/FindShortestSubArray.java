package leetcode.problems;

/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:
Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
*/
class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums)
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);

        int maxValue = 0;
        for (Integer key : countMap.keySet())
            maxValue = Math.max(maxValue, countMap.get(key));

        List<Integer> keys = new ArrayList<>();
        for (Integer key : countMap.keySet())
            if (maxValue == countMap.get(key))
                keys.add(key);

        int result = Integer.MAX_VALUE;
        for (Integer i : keys) {
            int numCount = 0;
            int length = 0;
            for (int n : nums) {
                if (i == n) {
                    numCount++;
                    if (length == 0) length++;
                }
                if (numCount == maxValue) {
                    result = Math.min(result, length);
                    break;
                }
                if (length > 0) length++;
            }
        }

        return result;
    }
}
