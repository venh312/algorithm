package leetcode.problems;

/*
Given an integer array nums and an integer k, 
return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
*/
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // 현재 요소가 이미 HashSet에 존재하는 경우
            if (set.contains(nums[i])) {
                return true; // 조건을 만족하는 두 인덱스가 발견됨
            }
            
            set.add(nums[i]); // 현재 요소를 HashSet에 추가

            // HashSet의 크기가 k를 초과하면
            // i-k 인덱스의 요소를 제거하여 윈도우를 유지합니다.
            if (set.size() > k) { // 3 > 2
                set.remove(nums[i - k]); // 2 - 2
            }
        }

        return false; // 배열을 모두 순회한 후에도 조건을 만족하는 두 인덱스를 찾지 못함
    }
}
