/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

오름차순으로 졍렬된 배열에서 최대 2개의 중복만 허용하도록 배열의 구조와 개수를 반환한다.

※ Example
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
*/
class RemoveDuplicates {
    // 22%
    public int removeDuplicates(int[] nums) {
        int index = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = countMap.getOrDefault(nums[i], 0) + 1;
            if (count < 3) {
                countMap.put(nums[i], count);
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    // GPT 풀이 100%
    public int removeDuplicatesGPT(int[] nums) {
        if (nums.length <= 2) return nums.length; // 길이가 2 이하라면 그대로 반환
  
        int i = 2; // 결과 배열을 추적하는 포인터
  
        // 원래 배열 순회
        for (int j = 2; j < nums.length; j++) {
            // 현재 숫자가 결과 배열의 마지막 두 숫자와 다를 경우만 추가
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
  
        return i; // 결과 배열의 길이 반환
    }
}
