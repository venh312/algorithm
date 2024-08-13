/*
Given an integer array nums and an integer k, modify the array in the following way:

choose an index i and replace nums[i] with -nums[i].
You should apply this process exactly k times.
You may choose the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.

정수 배열 번호와 정수 k가 주어지면 다음과 같은 방법으로 배열을 수정합니다:
지수 i를 선택하고 숫자[i]를 -nums[i]로 바꾸다.
이 과정을 정확히 k번 적용해야 합니다.
동일한 인덱스 i를 여러 번 선택할 수 있습니다.
이런 식으로 배열을 수정한 후에 배열의 가능한 최대 합을 반환한다.

Example 1:
Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].

Example 2:
Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].

Example 3:
Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
*/
class LargestSumAfterKNegations {
  public int largestSumAfterKNegations(int[] nums, int k) {
      Arrays.sort(nums);
  
      int minusCount = (int) Arrays.stream(nums).filter(value -> {
          return value < 0;
      }).count();
  
      if (minusCount == 0 && k % 2 == 0) return Arrays.stream(nums).sum();
  
      int count = k - minusCount;
      minusCount = Math.min(Math.abs(minusCount), k);
  
      for (int i = 0; i < minusCount; i++) {
          int num = nums[i];
          nums[i] = -num;
      }
  
      if (count > 0 && count % 2 != 0) {
          Arrays.sort(nums);
          nums[0] = -nums[0];
      }
  
      return Arrays.stream(nums).sum();
  }
}
