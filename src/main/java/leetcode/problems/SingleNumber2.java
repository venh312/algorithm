/*
https://leetcode.com/problems/single-number-iii/description/
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
*/
class SingleNumber2 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> hSet = new HashSet<>();

        // 중복된 값을 제거하여 고유 값만 남김
        for (int num : nums) {
            if (!hSet.add(num)) { // add가 실패하면 이미 존재하는 값
                hSet.remove(num);
            }
        }

        // Set에는 항상 두 개의 고유 값만 남음
        Iterator<Integer> iterator = hSet.iterator();
        return new int[]{iterator.next(), iterator.next()};
    }
}
